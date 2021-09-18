public class TestOrderedLinked <T extends Comparable> {
    public void testInsert(OrderedLinked<T> insert_list_here, T item) {
        System.out.println("Adding "+item+" to OrderedLinked");
        insert_list_here.insert(item);
        System.out.println("Current size of our OrderedLinked: "+insert_list_here.getSize());
        insert_list_here.print();
    }

    public void testRemove(OrderedLinked<T> insert_list_here, T item) {
        System.out.println("Removing "+item+" from OrderedLinked");
        if (insert_list_here.remove(item)) {
            System.out.println("Removed "+item+" successfully!");
        } else {
            System.out.println("Unable to remove "+item+".");
        };
        System.out.println("Current size of our OrderedLinked: "+insert_list_here.getSize());
        insert_list_here.print();
    }
    /**
    public TestOrderedLinked() {
    }
    **/
    public void main(String[] args) {
        OrderedLinked<Integer> newIntegerList = new OrderedLinked<T>();
        System.out.println("\nTesting .insert() with Integers");
        testInsert(newIntegerList, 15);
    }
}

