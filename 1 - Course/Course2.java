// -----------------------------------------------------------------------------------------------
// Written by: Gianfranco Dumoulin
// Date: April 14 2019
// Purpose: This program is a dynamic one. You can add up to 30 course objects to the program.
// The program simply compares Student A and B's classes and tells you which courses they have in common.
// It then asks the user if they want to check if Student A is taking a particular course.
// It then does the same for Student B. Nothing is hard coded, so all a user has to do is create a 
// new course object. 
// -----------------------------------------------------------------------------------------------

import java.util.Scanner;
public class Course2 {

	public static void main(String[] args) {
		// create the student arrays
		Scanner w = new Scanner(System.in);
		Course student1[] = new Course[30];
		Course student2[] = new Course[30];
	// creating 4 courses for student A (IP means "in progress") 
		Course course1 = new Course("Math272", 3.0, "A+");
		Course course2 = new Course("Comp248", 3.5, "A");
		Course course3 = new Course("Comp249", 3.5, "IP");
		Course course4 = new Course("Comp232", 3.0, "B+");
	// creating the 3 course objects for student B (IP stands for "In Progress")
		Course course5 = new Course("Comp248", 3.5, "IP");
		Course course6 = new Course("Comp232", 3.0, "B+");
		Course course7 = new Course("Soen287", 3.0, "B");
		
		// assigning the course objects to the student arrays 
		// student A
		student1[0] = course1;
		student1[1] = course2;
		student1[2] = course3;
		student1[3] = course4;
		// Student B
		student2[0] = course5;
		student2[1] = course6;
		student2[2] = course7;
		
		// Displaying the courses for both students
		int count = 0;
		System.out.print("Courses on Student A's list:"
				+ "\nCourse name:\t\tNumber of Credits:\tGrade:"
				+ "\nCourse name: " + course1.getname() + "\tNumber of Credits: " + course1.getcredits() + "\tGrade: " + course1.getgrade()
				+ "\nCourse name: " + course2.getname() + "\tNumber of Credits: " + course2.getcredits() + "\tGrade: " + course2.getgrade()
				+ "\nCourse name: " + course3.getname() + "\tNumber of Credits: " + course3.getcredits() + "\tGrade: " + course3.getgrade()
				+ "\nCourse name: " + course4.getname() + "\tNumber of Credits: " + course4.getcredits() + "\tGrade: " + course4.getgrade());
		System.out.print("\n\nCourses on Student B's list:"
				+ "\nCourse name: " + course5.getname() + "\tNumber of Credits: " + course5.getcredits() + "\tGrade: " + course5.getgrade()
				+ "\nCourse name: " + course6.getname() + "\tNumber of Credits: " + course6.getcredits() + "\tGrade: " + course6.getgrade()
				+ "\nCourse name: " + course7.getname() + "\tNumber of Credits: " + course7.getcredits() + "\tGrade: " + course7.getgrade());
		
		System.out.print("\n\nList of courses from Student A's list on Student B's list:\n");
		
		// counting the number of courses in the first array
		for (int z=0; z<student1.length; z++) {
			if (student1[z] == null) {
				break;
			} else {
				count++;
			}
		}
				// counting the number of courses in the second array
		int count1 = 0;
		for (int z=0; z<student2.length; z++) {
			if (student2[z] == null) {
				break;
			} else {
				count1++;
			}
		}
		
		
		// scanning both students arrays in order to check if they are taking the same courses
		for (int x = 0; x<count; x++) {
			for (int i = 0; i<count1; i++) {
				if (student1[x].getname() == student2[i].getname()) {
					System.out.println(student1[x].getname());
				
				}
			}
		}
		
		System.out.println("\nFirst course to check for Student A (no spaces please)?");
		String checkCourse0 = w.nextLine();
		
		// checking to see if any of the courses match the user input 
		for (int x = 0; x<count; x++) {
			if (student1[x].getname().equalsIgnoreCase(checkCourse0)) {
				System.out.println("Course " + checkCourse0 + " part of Student A's courses\n");
				count = 0;
				break;
			} else if (!(student1[x].getname().equalsIgnoreCase(checkCourse0)) && x == (count-1) ) {
				System.out.println("Course " + checkCourse0 + " not part of Student A's courses\n");
			} else if (!(student1[x].getname().equalsIgnoreCase(checkCourse0))){
				continue;
			} 
		}
		
		System.out.println("Second course to check for Student B (no spaces please)?");
		checkCourse0 = w.nextLine();

		// checking to see if any of the courses match the user input 
		for (int x = 0; x<count1; x++) {
			if (student2[x].getname().equalsIgnoreCase(checkCourse0)) {
				System.out.println("Course " + checkCourse0 + " part of Student B's courses\n");
				count1 = 0;
			} else if (!(student2[x].getname().equalsIgnoreCase(checkCourse0)) && x == (count1-1) ) {
				System.out.println("Course " + checkCourse0 + " not part of Student B's courses\n");
			} else if (!(student2[x].getname().equalsIgnoreCase(checkCourse0))){
				continue;
			}
				
			}
		} 
	}
