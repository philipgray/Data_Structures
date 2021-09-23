/**
 * @author Philip Gray
 */
public class OrderedLinked <T extends Comparable> extends DoubleLinked {
    public void insert(T newData) {
        if (this.start == null) {
            start = new DNode(newData);
            end = start;
            len++;
        } else {
            boolean operationIncomplete = true;
            DNode current = start;
            while (operationIncomplete) {
                if (newData.compareTo(current.getData()) <= 0) {
                    // if our newData is less than current data
                    if (current.getPrevious() == null) {
                        // if newData is less or equal to than the first item in our list
                        current.setPrevious(new DNode(newData, null, current));
                        start = current.getPrevious();
                    } else {
                        // if newData is less than or equal to an item in our list
                        DNode previous = current.getPrevious();
                        previous.setNext(new DNode(newData, previous, current));
                        current.setPrevious(previous.getNext());
                    }
                    len++;
                    operationIncomplete = false;
                } else if (current.getNext() == null) {
                    current.setNext(new DNode(newData, current));
                    end = current.getNext();
                    len++;
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    public boolean remove(T newData) {
        DNode current = start;
        boolean didWeRemove = false;
        if (current != null) {
            while (newData.compareTo(current.getData()) != 0) {
                if (current.getNext() != null) {
                    current = current.getNext();
                } else {
                    // if we run out of items to compare to
                    break;
                }
            }
            if (newData.compareTo(current.getData()) == 0) {
                if (current.getPrevious() == null) {
                    // we're removing the first item in our list
                    if (current.getNext() != null) {
                        start = current.getNext();
                        start.setPrevious(null);
                    } else {
                        // There was only one item in our list
                        start = null;
                        end = null;
                    }
                } else {
                    if (current.getNext() != null) {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    } else {
                        current.getPrevious().setNext(null);
                        end = null;
                    }
                }
                didWeRemove = true;

            }
        }
        if (didWeRemove) {
            len--;
        }
        return didWeRemove;
    }

    public void removeFirst() {
        if (start != null) {
            if (start.getNext() != null) {
                // if there is more than one item in the list
                start = start.getNext();
                start.setPrevious(null);
            } else {
                // if there is only one item in the list
                start = null;
            }
        }
    }

    public void removeLast() {
        if (end != null) {
            if (end.getPrevious() != null) {
                // if there is more than one item in the list
                end = end.getPrevious();
                end.setNext(null);
            } else {
                // if there is only one item in the list
                end = null;
            }
        }
    }

    public boolean search(T newData) {
        DNode current = start;
        boolean didWeFind = false;
        if (current != null) {
            while (newData.compareTo(current.getData()) != 0) {
                if (current.getNext() != null) {
                    current = current.getNext();
                } else {
                    // if we run out of items to compare to
                    break;
                }
            }
            if (newData.compareTo(current.getData()) == 0) {
                didWeFind = true;
            }
        }
        return didWeFind;
    }
}
