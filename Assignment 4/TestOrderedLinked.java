public class TestOrderedLinked <T extends Comparable> {
    OrderedLinked<T> OrderedLinkedList;

    public TestOrderedLinked() {
        this.OrderedLinkedList = new OrderedLinked<T>(); // is this redundant?
    }

    public void testInsert(T item) {
        System.out.println("\nAdding "+item+" to OrderedLinked");
        OrderedLinkedList.insert(item);
        System.out.println("Current size of our OrderedLinked: "+OrderedLinkedList.getSize());
        OrderedLinkedList.print();
    }

    public void testRemove(T item) {
        System.out.println("\nRemoving "+item+" from OrderedLinked");
        if (OrderedLinkedList.remove(item)) {
            System.out.println("Removed "+item+" successfully!");
        } else {
            System.out.println("Unable to remove "+item+".");
        }
        System.out.println("Current size of our OrderedLinked: "+OrderedLinkedList.getSize());
        OrderedLinkedList.print();
    }

    public void testSearch(T item) {
        System.out.println("\nSearching to see if " + item + " is in OrderedLinked");
        if (OrderedLinkedList.search(item)) {
            System.out.println(item+" is in the OrderedLinkedList!");
        } else {
            System.out.println("Unable to find "+item+" in the OrderedLinkedList.");
        }
    }


    public static void main(String[] args) {

        System.out.println("Now testing for Integers");
        TestOrderedLinked<Integer> intOrderedLinked = new TestOrderedLinked<>();
        intOrderedLinked.testInsert(15);
        intOrderedLinked.testInsert(15);
        intOrderedLinked.testInsert(10);
        intOrderedLinked.testInsert(10);
        intOrderedLinked.testInsert(5);
        intOrderedLinked.testInsert(5);
        intOrderedLinked.testInsert(1);
        intOrderedLinked.testInsert(1);
        intOrderedLinked.testInsert(10);
        intOrderedLinked.testInsert(10);
        intOrderedLinked.testInsert(5);
        intOrderedLinked.testInsert(5);
        intOrderedLinked.testInsert(15);
        intOrderedLinked.testInsert(15);

        intOrderedLinked.testRemove(15);
        intOrderedLinked.testRemove(1);
        intOrderedLinked.testRemove(1);

        for (int i = 0; i < 100; i++) {
            intOrderedLinked.testSearch(31);
        }

        for (int i = 0; i < 100; i++) {
            intOrderedLinked.testInsert(5);
        }

        for (int i = 0; i < 120; i++) {
            intOrderedLinked.testRemove(5);
        }

        System.out.println("--------------------------------------------------------");
        System.out.println("Now testing for Characters");
        TestOrderedLinked<Character> characterTestOrderedLinked = new TestOrderedLinked<>();

        characterTestOrderedLinked.testRemove('a');
        characterTestOrderedLinked.testRemove('b');
        characterTestOrderedLinked.testRemove('c');

        characterTestOrderedLinked.testSearch('a');
        characterTestOrderedLinked.testSearch('b');
        characterTestOrderedLinked.testSearch('c');

        characterTestOrderedLinked.testInsert('a');
        characterTestOrderedLinked.testInsert('b');
        characterTestOrderedLinked.testInsert('y');
        characterTestOrderedLinked.testInsert('y');
        characterTestOrderedLinked.testInsert('z');
        characterTestOrderedLinked.testInsert('x');
        characterTestOrderedLinked.testInsert('z');
        characterTestOrderedLinked.testInsert('x');
        characterTestOrderedLinked.testInsert('x');
        characterTestOrderedLinked.testInsert('x');

        characterTestOrderedLinked.testInsert('A');
        characterTestOrderedLinked.testInsert('A');
        characterTestOrderedLinked.testInsert('A');
        characterTestOrderedLinked.testInsert('A');
        characterTestOrderedLinked.testInsert('D');
        characterTestOrderedLinked.testInsert('D');
        characterTestOrderedLinked.testInsert('D');
        characterTestOrderedLinked.testInsert('D');
        characterTestOrderedLinked.testInsert('Z');

        characterTestOrderedLinked.testInsert('1');
        characterTestOrderedLinked.testInsert('x');
        characterTestOrderedLinked.testInsert('3');
    }
}

