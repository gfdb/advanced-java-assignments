// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin
// Date: March 25 2019
// Purpose: intended to teach the students
// how to use custom methods. The purpose of the assignment is to better understand accessors, 
// mutators, constructors and how they work in a java program. The function of this actual algorithm 
// is nothing. It is not the driver class, the purpose of this class is to define and create the 
// custom methods.
// -----------------------------------------------------------------------------------------------

public class Course {
// declaration of the name, credits and grade variable
	private String name;
	private Double credits;
	private String grade; 
	// default constructor
	public Course() {
		
	}
	// parameterized constructor which requires a string, double and a string
	public Course(String name, Double credits, String grade) {
		this.name = name;
		this.credits = credits;
		this.grade = grade;
	}
	public Course(String name, Double credits) { //***************************************added
		this.name = name;
		this.credits = credits;
		this.grade = "IP";
	}
	Course(Course k) {
		name = k.name;
		credits = k.credits;
		grade = k.grade;
	}
	public boolean equaLs(Course course2, Course course3, Course course4){
		if ((course2.getname()).equalsIgnoreCase(course3.getname())) {
			return true;
		} else if ((course2.getname()).equalsIgnoreCase(course4.getname())){
			return true;
		} else if ((course3.getname()).equalsIgnoreCase(course4.getname())) {
			return true;
		}
		return false;
	}
	
	// Although they are not required, all of the "set" methods are here because without them the default constructor wouldn't do anything
	public void setname (String name) {
		this.name = name;
	}
	public void setcredits (Double credits) {
		this.credits = credits;
	}
	public void setLettergrade(String grade) {
		this.grade = grade;
	}
	// methods that returns name, credits and grade, respectively
	public String getname() {
		return name;
	}
	
	public Double getcredits() {
		return credits;
	}
	
	public String getgrade() {
		return grade;
	}
	// toString method that returns the string of each of the variables
	public String toString() {
		String s ="Course name: " + getname() + "\t" + "Number of Credits: " + getcredits() + "\t" + "Grade: " + getgrade();
		return s;
	}
}
