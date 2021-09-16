//This class represents a node in a Linked List
//The class holds one character of data

public class Node{
    private char data;
    private Node before;
    private Node next;

    public Node(char c) {
        this.data = c;
        this.before = null;
        this.next = null;
    }

    public Node(char c, Node before) {
	    this.data = c;
        this.before = before;
        this.next = null;
    }

    public Node(char c, Node before, Node next) {
        this.data = c;
        this.before = before;
        this.next = next;
    }

    public char getData(){
	return data;
    }

    public Node getNext(){
	return next;
    }

    public Node getBefore() {
        return before;
    }

    public void setData(char c){
	    this.data = c;
    }

    public void setNext(Node n) {
        this.next = n;
    }
    public void setBefore(Node before) {
        this.before = before;
    }

}
