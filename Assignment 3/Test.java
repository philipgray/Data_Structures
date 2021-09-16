public class Test{

    //This tests appending characters and printing
    //Note that this also works on classes that extend SimpleLinked
    public static void testSimple(SimpleLinked lst){

	lst.append('b');
	lst.append('a');
	lst.append('n');
	lst.append('a');
	lst.append('n');
	lst.append('a');

	System.out.println("This should print banana:");
	lst.print();
    }

    //This tests adding and removing in different locations
    //It also tests reversing the list
    public static void testComplex(ComplexLinked lst) {
		System.out.println("This should print banana");
		lst.print();

		lst.insert(0, 'e');
		lst.insert(1, 'g');
		lst.insert(2, 'g');
		lst.print();

		lst.remove('b');
		lst.remove('a');
		lst.remove('n');
		lst.remove('a');
		lst.remove('a');
		lst.remove('n');

		lst.print();
	System.out.println("This should print ananab:");
	ComplexLinked new_lst = lst.reverse();
	lst.remove('n');
	lst.remove('n');
	new_lst.print();

	new_lst.append('z');
	new_lst.append('q');

	ComplexLinked new_lst3 = new_lst.reverse();
	new_lst3.print();
    }

    public static void main(String[] args){
	SimpleLinked simple = new SimpleLinked();
	ComplexLinked complex = new ComplexLinked();

	testSimple(simple);
	testSimple(complex);
	testComplex(complex);
	
    }
}
