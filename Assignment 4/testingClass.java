public class testingClass {
    public static void testInsert(OrderedLinked<Integer> insert_list_here, Integer number) {
        System.out.println("Adding "+number+" to OrderedLinked");
        insert_list_here.insert(number);
        System.out.println("Current size of our OrderedLinked: "+insert_list_here.getSize());
        insert_list_here.print();
    }

    public static void testRemove(OrderedLinked<Integer> insert_list_here, Integer number) {
        System.out.println("Removing "+number+" from OrderedLinked");
        if (insert_list_here.remove(number)) {
            System.out.println("Removed "+number+" successfully!");
        } else {
            System.out.println("Unable to remove "+number+".");
        };
        System.out.println("Current size of our OrderedLinked: "+insert_list_here.getSize());
        insert_list_here.print();
    }

    public static void main(String[] args) {
        OrderedLinked<Integer> newIntegerList = new OrderedLinked<>();
        System.out.println("\nTesting insert();");
        testInsert(newIntegerList, 5);
        testInsert(newIntegerList, 3);
        testInsert(newIntegerList, 2);
        testInsert(newIntegerList, 6);
        testInsert(newIntegerList, 1);
        testInsert(newIntegerList, 1);
        testInsert(newIntegerList, 6);
        testInsert(newIntegerList, 0);
        System.out.println("\nTesting .remove();");
        testRemove(newIntegerList, 0);
        testRemove(newIntegerList, 3);
        testRemove(newIntegerList, 3);
    }
}
