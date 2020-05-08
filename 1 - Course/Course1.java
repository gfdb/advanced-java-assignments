// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin
// Date: March 25 2019
// Purpose: This is an the driver class to the public class Course.
// It's purpose is to test the course objects "course#" and then print each of the parameters.
// -----------------------------------------------------------------------------------------------
public class Course1 {

	public static void main(String[] args) {
		// declaration of course object
		Course course2 = new Course("COMP248", 3.5, "A+");
		Course course3 = new Course("MATH232", 3.0, "B");
		Course course4 = new Course("MATH123", 4.0, "B+");
		// calling the toString method to return the string values and then print them
		System.out.println(course2.toString());
		System.out.println(course3.toString());
		System.out.println(course4.toString());
		
		
	}

}
