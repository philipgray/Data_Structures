//This is a binary search tree that stores integers

public class IntNode{
    public IntNode left;
    public IntNode right;
    public IntNode parent;
    public int height;
    public int descendents;
    public int data;

    public IntNode insert(int new_data) {
        this.descendents++;
        IntNode end = null;

        if( new_data >= data) {
            //Insert larger values on the right
            if( right == null){
                right = new IntNode(new_data);
                right.setParent(this);
                right.setHeight();
                end = right;
            }
            else {
                end = right.insert(new_data);
            }
        } else {
            if( left == null){
                left = new IntNode(new_data);
                left.setParent(this);
                left.setHeight();
                end = left;
            }
            else{
                end = left.insert(new_data);
            }
        }
        return end;
    }

    public boolean search(int target){
        if( data == target ){
            return true;
        }
        if( target > data ){
            //Find larger values on the right
            if( right != null){
                return right.search(target);
            }
        }

        if( target < data){
            //Find smaller values on the left
            if(left != null){
                return left.search(target);
            }
        }
        return false;
    }

    public boolean amITheProblem() {
        System.out.println("NODE INFORMATION:\nNODE: "+this.getData()+"\n\tHEIGHT: "+
                this.getHeight()+"\n\tDESCENDENTS: "+this.descendents);

        return Math.pow(1.5, this.height) > this.descendents;
    }

    public double getDescendents() {
        return descendents;
    }

    public int getData(){
        return data;
    }

    public void setData(int d){
        data = d;
    }

    public IntNode getLeft(){
        return left;
    }

    public void setLeft(IntNode nd){
        left = nd;
    }

    public IntNode getRight(){
        return right;
    }

    public void setRight(IntNode nd){
        right = nd;
    }

    public IntNode getParent(){
        return parent;
    }

    public int getHeight() {
        return height;
    }

    public void setParent(IntNode nd){
        parent = nd;
    }

    public void setHeight() {
        if (this.parent != null) {
            this.height = this.parent.getHeight() + 1;
        }
    }

    public boolean isLeaf(){
        return (left == null) && (right == null);
    }

    public void newChild() {

    }

    //Constructor
    public IntNode(int the_data){
        data = the_data;
        height = 1;

    }
}
