public class testingClass {
    public static void testInsert() {
        OrderedLinked<Integer> testInserting = new OrderedLinked<Integer>();

        testInserting.insert(5);
        testInserting.insert(11);
        testInserting.insert(1);
        testInserting.insert(2);

        testInserting.print();
    }

    public static void main(String[] args) {
        testInsert();
    }
}
