public class TestOrderedLinked <T extends Comparable> {
    OrderedLinked<T> OrderedLinkedList;

    public TestOrderedLinked() {
        this.OrderedLinkedList = new OrderedLinked<T>(); // is this redundant?
    }

    public void testInsert(T item) {
        System.out.println("\nAdding "+item+" to OrderedLinked");
        OrderedLinkedList.insert(item);
        // System.out.println("Current size of our OrderedLinked: "+OrderedLinkedList.getSize());
        OrderedLinkedList.print();
    }

    public void testRemove(T item) {
        System.out.println("\nRemoving "+item+" from OrderedLinked");
        if (OrderedLinkedList.remove(item)) {
            System.out.println("Removed "+item+" successfully!");
        } else {
            System.out.println("Unable to remove "+item+".");
        }
        // System.out.println("Current size of our OrderedLinked: "+OrderedLinkedList.getSize());
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
        intOrderedLinked.testInsert(10);
        intOrderedLinked.testInsert(5);
        intOrderedLinked.testInsert(1);

        intOrderedLinked.testRemove(15);
        intOrderedLinked.testRemove(1);
        intOrderedLinked.testRemove(1);


        System.out.println("--------------------------------------------------------");
        System.out.println("Now testing for Characters");
        TestOrderedLinked<Character> characterTestOrderedLinked = new TestOrderedLinked<>();

        characterTestOrderedLinked.testInsert('c');
        characterTestOrderedLinked.testInsert('q');
        characterTestOrderedLinked.testInsert('f');
        characterTestOrderedLinked.testInsert('a');
        characterTestOrderedLinked.testInsert('a');
        characterTestOrderedLinked.testInsert('A');
        characterTestOrderedLinked.testInsert('D');

        characterTestOrderedLinked.testSearch('A');
        characterTestOrderedLinked.testSearch('D');


        characterTestOrderedLinked.testRemove('d');
        characterTestOrderedLinked.testRemove('a');
        characterTestOrderedLinked.testRemove('q');
        characterTestOrderedLinked.testRemove('f');

        characterTestOrderedLinked.testSearch('f');
    }
}

