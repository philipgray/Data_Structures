import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class TreeUtilitiesV2 {
    public static IntSearchTree insertInOrder(int numberOfIntegers) {
        IntSearchTree ourTree = new IntSearchTree();

        for (int i = 1; i <= numberOfIntegers; i++) {
            ourTree.insert(i);
        }

        return ourTree;
    } // insertInOrder

    public static IntScapegoat insertInOrderScapegoat(int numberOfIntegers) {
        IntScapegoat ourTree = new IntScapegoat();

        for (int i = 1; i <= numberOfIntegers; i++) {
            ourTree.insert(i);
        }
        return ourTree;
    }


    public static IntSearchTree insertRandomly(int numberOfIntegers) {
        IntSearchTree ourTree = new IntSearchTree();
        ArrayList<Integer> arrayList = new ArrayList();

        for (int i = 1; i <= numberOfIntegers; i++) {
            arrayList.add(i);
        }

        Collections.shuffle(arrayList);

        for (Integer number : arrayList) {
            ourTree.insert(number);
        }


        return ourTree;
    } // end insertRandomly

    public static IntScapegoat insertRandomlyScapegoat(int numberOfIntegers) {
        IntScapegoat ourTree = new IntScapegoat();
        ArrayList<Integer> arrayList = new ArrayList();

        for (int i = 1; i <= numberOfIntegers; i++) {
            arrayList.add(i);
        }

        Collections.shuffle(arrayList);

        for (Integer number : arrayList) {
            ourTree.insert(number);
        }
        return ourTree;
    } // end insertRandomlyScapegoat

    public static int getTreeHeight(IntDataSet tree) {
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
        /**
        IntNode current = node;
        int height = 1;
        while (current.getParent() != null) {
            current = current.getParent();
            height++;
        }
         **/
        return node.getHeight();
    }

    public static void testRandomHeight(int numberOfTries, int numberOfInts) {
        int min = numberOfInts;
        int max = 0;

        int current;

        for (int i = 1; i <= numberOfTries; i++) {
            IntSearchTree ourTree = new IntSearchTree();
            ArrayList<Integer> integerArrayList = new ArrayList<>();

            for (int z = 1; z <= numberOfInts; z++) {
                integerArrayList.add(z);
            }
            Collections.shuffle(integerArrayList);

            for (Integer currentValue : integerArrayList) {
                ourTree.insert(currentValue);
            }
            current = getTreeHeight(ourTree);

            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }


        }

        System.out.println("After "+numberOfTries+" tries we found the following:\n\tThe maximum height is: " +max+
                "\n\tThe minimum height was: "+min);
    }

    public static void main(String[] args) {

        IntSearchTree thousandIntTree = insertInOrder(1000);
        System.out.println(getTreeHeight(thousandIntTree));

        testRandomHeight(10000, 1000);

        System.out.println("Scapegoat height:");

        IntScapegoat orderScapegoat = insertInOrderScapegoat(1000);
        System.out.println(getTreeHeight(orderScapegoat));

        System.out.println("Scapegoat height:");
        IntScapegoat randomScapegoat = insertRandomlyScapegoat(1000);
        System.out.println(getTreeHeight(randomScapegoat));
    }
}
