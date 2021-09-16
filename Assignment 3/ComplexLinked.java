public class ComplexLinked extends SimpleLinked {

    public boolean remove(char c) {
        Node current = start;
        boolean itemFound = false;

        if (start.getData() == c) {
            if (start.getNext() != null) {
                start = start.getNext();
                // this is a bad practice lol
                return true;
            }
        }
        while (current.getData() != c) {
            if (current.getNext() == null) {
                break;
            } else {
                current = current.getNext();
            }
        } if (current.getData() == c) {
            itemFound = true;
            Node previous = current.getBefore();
            Node next = current.getNext();

            if (previous != null) {
                previous.setNext(next);
            }
            if (next != null) {
                if (previous != null) {
                    next.setBefore(previous);
                } else {
                    next.setBefore(null);
                }
            }
        }
        return itemFound;
    }

    public void insert(int pos, char c) {
        int currentPos = 0;
        Node current = start;

        while (currentPos != pos && current.getNext() != null) {
            currentPos++;
            current = current.getNext();
        }
        if (pos == 0) {
            // this is we're appending at 0 case
            if (start == null) {
                // if the linkedlist is empty
                start = new Node(c);
            } else {
                // if the list isn't empty
                Node newNode = new Node(c, null, current);
                current.setBefore(newNode);
                start = newNode;
            }
        } else if (currentPos == pos) {
            System.out.println(currentPos);
            Node previous = current.getBefore();
            Node next = current.getNext();
            if (next == null) {
                // going to end
                Node newNode = new Node(c, previous, current);
                previous.setNext(newNode);
                current.setBefore(newNode);
                current.setNext(null);
            } else {
                Node newNode = new Node(c, previous, current);
                previous.setNext(newNode);
                current.setBefore(newNode);
            }
        }
    }

    public ComplexLinked reverse() {
        ComplexLinked newComplexLinked = new ComplexLinked();
        Node current = start;

        while (current != null) {
            newComplexLinked.insert(0, current.getData());
            current = current.getNext();
        }
        return newComplexLinked;
    }
}
