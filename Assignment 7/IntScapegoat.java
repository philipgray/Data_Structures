import java.util.*;
import java.util.Queue;

public class IntScapegoat implements IntDataSet {
    public IntNode root;
    int count = 0;

    public void insert(int data){
        if( root == null ){
            root = new IntNode(data);
        } else {
            IntNode test = root.insert(data);
            if (test == null) {
                count++;
                System.out.println("why is my insert returning null");
                System.out.println(count);
            } else {
                checkForProblems(test.getParent());
            }
        }
    }

    public boolean search(int target) {
        if( root == null){
            return false;
        }
        else{
            return root.search(target);
        }
    }

    public void checkForProblems(IntNode node) {

        if (node.getParent() != null) {
            IntNode parent = node.parent;
            if ((node.getDescendents() / parent.getDescendents()) > 2.0/3) {
                rebuild(parent);
            } else {
                checkForProblems(parent);
            }
        }
        /**
         if (node.amITheProblem()) {
            rebuild(node);
         } else if (node.getParent() != null) {
            checkForProblems(node.getParent());
         }
         **/
    }



    public void rebuild(IntNode scapeGoat) {
        ArrayList<Integer> chopped = new ArrayList<>();
        Queue<IntNode> nodeQueue = new LinkedList<>();

        nodeQueue.add(scapeGoat);

        while (!nodeQueue.isEmpty()) {
            IntNode current = nodeQueue.remove();
            chopped.add(current.getData());
            if (current.getLeft() != null) {
                nodeQueue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                nodeQueue.add(current.getRight());
            }
        }

        Collections.shuffle(chopped);
        IntNode parent;

        if (scapeGoat.getParent() == null) {
            root = new IntNode(chopped.get(0));
            chopped.remove(0);
            parent = root;
        } else {
            parent = scapeGoat.getParent();
            if (parent.getRight() == scapeGoat) {
                parent.setRight(null);
            } else {
                parent.setLeft(null);
            }
        }

        for (int val : chopped) {
            parent.insert(val);
        }
    }

    public IntNode getRoot() {
        return root;
    }
}
