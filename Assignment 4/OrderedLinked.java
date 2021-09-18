public class OrderedLinked <T extends Comparable> extends DoubleLinked {
    public void insert(T newData) {
        if (this.start == null) {
            start = new DNode(newData);
            start.setPrevious(null);
            start.setNext(null);
        } else {
            DNode current = start;
            while (newData < current.getData() && current.getNext() != null) {
                current = current.getNext();
            }
            if (current.getNext() == null) {
                current.setNext(new DNode(newData, current, null));
            } else {
                DNode next = current.getNext();
                current.setNext(new DNode(newData, current, next));
                next.setPrevious(current.getNext());
            }
        }
    }
}
