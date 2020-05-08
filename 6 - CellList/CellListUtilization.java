import java.io.*;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) {
		CellList lst1 = new CellList();
		CellList lst2 = new CellList();
		
		Scanner sc = null;
		long l;
		String s;
		int i;
		double d;
		
		try
		{
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
			while (sc.hasNextLine()) 
			{
				l = sc.nextLong();
				s = sc.next();
				d = sc.nextDouble();
				i = sc.nextInt();
				if (lst1.contains(l) == false)
				{
					CellPhone cp = new CellPhone(l, s, i, d);
					lst1.addToStart(cp);
					lst2.addToStart(cp);
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The file you are trying to open could not be found.\n"
					+ "Please check that the file exits and try again."
					+ "\nProgram will not terminate.");
			System.exit(0);
		}
		lst1.showContents();
		lst2.showContents();
		System.out.println("\nChecking the equality  of lst1 and lst2...");
		if (lst1.equals(lst2))
		{
			System.out.println("These two lists are equal!");
		}
		else
		{
			System.out.println("These two lists are not equal!");
		}
		
		CellPhone c3 = new CellPhone();
		CellPhone c4 = new CellPhone(12345678, "Titan", 2033, 233.34);
		CellPhone c5 = new CellPhone(11111111, "Titan1", 2034, 233.35);
		CellPhone c6 = new CellPhone(22222222, "Titan2", 2035, 233.36);
		CellPhone c7 = new CellPhone(33333333, "Titan3", 2036, 233.37);
		CellPhone c8 = new CellPhone(44444444, "Titan4", 2037, 233.38);
		CellPhone c9 = new CellPhone(55555555, "Titan5", 2038, 233.39);

		System.out.println("\nWill now add c3 to start....");
		lst1.addToStart(c3);
		lst1.showContents();
		System.out.println("\nWill now insert c4 at index 8");
		lst1.insertAtIndex(c4, 7);
		lst1.showContents();
		System.out.println("\nWill now delete a node from the start.");
		System.out.println(lst1.deleteFromStart());
		lst1.showContents();
		System.out.println("\nWill now delete the node at index 3");
		lst1.deleteFromIndex(2);
		lst1.showContents();
		System.out.println("\nWill now replace index 5 with a new object...");
		if (lst1.replaceAtIndex(c3, 4))
			System.out.print("\nReplacement succesfull.");
		else
			System.out.print("\nReplacement not succesfull.");
		lst1.showContents();
		System.out.println("\nWill now replace the CellPhone at index 16 with c9");
		lst1.replaceAtIndex(c9, 15);
		lst1.showContents();
		System.out.println("\nWill now try to find c9");
		System.out.println("\nHere is the pointer to where c9 is located: " + lst1.find(55555555));
		System.out.println("\nWill now check whether or not the list contains c3 and c7");
		if (lst1.contains(1000000))
			System.out.println("\nThe list contains c3!");
		else
			System.out.println("\nThe list does not contain c3!");
		if (lst1.contains(33333333))
			System.out.println("\nThe list contains c7!");
		else
			System.out.println("\nThe list does not contain c7!");
		if (lst1.equals(lst2))
		{
			System.out.println("\nThese two lists are equal!");
		}
		else
		{
			System.out.println("\nThese two lists are not equal!");
		}
	}

}
