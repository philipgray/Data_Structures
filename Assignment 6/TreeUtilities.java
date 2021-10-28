//IMPORTANT: You will modify this class to add functions
//the functions that you need to add are described in the assignment document

//All functions in this class are static.
//This class is never intended to be constructed.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Random;

public abstract class TreeUtilities{

    public static void printTreeHelper(IntNode nd){
        if (nd != null){
            printTreeHelper(nd.getLeft());
            System.out.print(nd.getData());
            System.out.print(" ");
            printTreeHelper(nd.getRight());
        }
    }

    //This function prints all the data an IntSearchTree in order
    //Starting with the lowest and going to the highest
    public static void printTree(IntSearchTree tree){
        System.out.println("Tree Root: " +tree.getRoot().getData());
        printTreeHelper(tree.getRoot());
        System.out.println("");
    }

    //This function creates a IntSearchTree filled with randomly chosen data
    //num is the number of nodes in the random search tree
    //max_val is the upper limit on the randomly chosen integer data
    public static IntSearchTree makeRandomTree(int num, int max_val){
        Random rand = new Random();
        IntSearchTree tree = new IntSearchTree();

        for(int i=0; i<num; i++){
            int rand_data = rand.nextInt(max_val);
            tree.insert(rand_data);
        }

        return tree;
    }

    public static int getMax(IntSearchTree tree) {
        if (tree.getRoot() != null) {
            IntNode current = tree.getRoot();
            while (current.getRight() != null) {
                current = current.getRight();
            }
            return current.getData();
        }
        return -1;
    }

    public static int getNodeHeight(IntSearchTree tree, int target) {
        if (tree.getRoot() != null) {
            IntNode current = tree.getRoot();
            int height = 1;
            // while we're not at the end of our tree, or our current node isn't the target
            while (current.getData() != target) {
                // if our target is smaller than our current node
                if (current.isLeaf()) {
                    return -1;
                } else if (current.getData() > target) {
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                        height++;
                    } else {
                        return -1;
                    }
                } else if (current.getData() < target) {
                    if (current.getRight() != null) {
                        current = current.getRight();
                        height++;
                    } else {
                        return -1;
                    }
                } else {
                    System.out.println("something went horribly wrong in getNodeHeight!");
                    return -1;
                }
            }
            return height;
        }
        else {
            return -1;
        }
    }

    public static int getTreeHeight(IntSearchTree tree) {
        int maxHeight = 0;
        Stack<IntNode> ourQueue= new Stack<>();
        if (tree.getRoot() != null) {
            ourQueue.add(tree.getRoot());
            int currentHeight = 0;

            // depth first with a twist!
            while (!ourQueue.empty()) {
                IntNode currentNode = ourQueue.pop();
                if (currentNode.isLeaf()) {
                    currentHeight = toTheTop(currentNode);
                    if (currentHeight > maxHeight) {
                        maxHeight = currentHeight;
                    }
                } else {
                    if (currentNode.getRight() != null) {
                        ourQueue.add(currentNode.getRight());
                    }
                    if (currentNode.getLeft() != null) {
                        ourQueue.add(currentNode.getLeft());
                    }
                }
            }

        }
        return maxHeight;
    }

    public static int toTheTop(IntNode node) {
        IntNode current = node;
        int height = 1;
        while (current.getParent() != null) {
            current = current.getParent();
            height++;
        }
        return height;
    }

    public static void helpVisualize(IntSearchTree tree) {
        Queue<IntNode> ourQueue = new LinkedList<>();
        StringBuilder ourString = new StringBuilder();
        if (tree.getRoot() != null) {
            IntNode current = tree.getRoot();
            ourQueue.add(current);

            while (!ourQueue.isEmpty()) {
                current = ourQueue.remove();
                ourString.append(current.getData()).append(" ");
                if (current.getLeft() != null) {
                    ourQueue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    ourQueue.add(current.getRight());
                }
            }
        }
        System.out.println(ourString);
    }

    public static int getNextInt(IntSearchTree tree, int target) {
        if (tree.search(target)) {
            int maxValue = getMax(tree);
            IntNode targetNode = null;
            Stack<IntNode> ourQueue = new Stack<>();
            ourQueue.add(tree.getRoot());

            while (!ourQueue.empty()) { // while our stack is not empty
                IntNode currentNode = ourQueue.pop();
                System.out.println(currentNode.getData());
                if (target < currentNode.getData() && (currentNode.getData() <= maxValue)) {
                    maxValue = currentNode.getData();
                }
                if (target == currentNode.getData()) {
                    if (targetNode == null) {
                        targetNode = currentNode;
                    }
                }
                if (currentNode.getRight() != null) {
                    ourQueue.add(currentNode.getRight());
                }
                if (currentNode.getLeft() != null) {
                    ourQueue.add(currentNode.getLeft());
                }
            }
            if (maxValue == target) {
                assert targetNode != null;
                //System.out.println("inside max == target");
                if (targetNode.getRight() != null) {
                    if (targetNode.getRight().getData() == target) {
                        return target;
                    } else {
                        //System.out.println("not sure how we got here");
                        throw new RuntimeException();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            return maxValue;
        } else {
            throw new RuntimeException();
        }
    }

    //Don't hesitate to modify this code, it is only here for testing purposes
    public static void main(String[] args){
        IntSearchTree tree = makeRandomTree(10, 20);
        printTree(tree);

        System.out.println("Is 5 in the tree?");
        System.out.println(tree.search(5));
        System.out.println("Is 7 in the tree?");
        System.out.println(tree.search(7));
        System.out.println("Is 18 in the tree?");
        System.out.println(tree.search(18));

        System.out.println(getMax(tree));
        System.out.println("--------");

        printTree(tree);
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int target = rand.nextInt(20);
            int height = getNodeHeight(tree, target);

            if (height == -1) {
                System.out.println(target+" isn't in the tree.");
            } else {
                System.out.println(target +" has a height of "+height+".");
            }
        }

        helpVisualize(tree);
        for (int i = 0; i < 5; i++) {
            System.out.println("Tree Height: "+getTreeHeight(tree));
        }

        helpVisualize(tree);
        System.out.println(getNextInt(tree, 5));

        /*
         * This is for testing if there's two targets and nothing less than it.
         *
        IntSearchTree doubleValTest = new IntSearchTree();
        doubleValTest.insert(4);
        doubleValTest.insert(5);
        doubleValTest.insert(5);
        System.out.println(getNextInt(doubleValTest, 5));

        //System.out.println(getNextInt(tree, 5));
         */
    }
}
