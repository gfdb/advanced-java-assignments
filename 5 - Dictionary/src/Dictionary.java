
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class Dictionary {
	public static String removePunctuation(String str)
	{
			if (str.contains("\\")) {
				str = str.substring(0, str.length()-1);
			}
		str = str.replaceAll("[ ? : \' , = ; ! \\ {} .]", "");
		return str;
		
	}
	public static String removeInts(String s)
	{
		s = s.toUpperCase();
		if  (s.contains("0") ||
			s.contains("1") ||
			s.contains("2") ||
			s.contains("3") ||
			s.contains("4") ||
			s.contains("5") ||
			s.contains("6") ||
			s.contains("7") ||
			s.contains("8") ||
			s.contains("9") ) {
			return "";
		}
		return s;
			
	}
	public static ArrayList<String> removeDuplicates (ArrayList<String> list)
	{
		ArrayList<String> list1 = new ArrayList<String>();
		
		for (String element : list)
		{
			if (!list1.contains(element)) 
			{
				list1.add(element);
			}
		}
		return list1;
	}
	
	public static void ReadFile(Scanner sc, PrintWriter pw) 
	{
		ArrayList<String> array = new ArrayList<String>(10);
		
		
		while (sc.hasNextLine()) 
		{
			String s = sc.nextLine();
			String w = "";
			Scanner lineScanner = new Scanner(s);
			while(lineScanner.hasNext())
			{
				w = lineScanner.next();
				w = removeInts(w);
				w = removePunctuation(w);
				if (!w.contentEquals(""))
					array.add(w.toUpperCase());
			}	
		}
		array = removeDuplicates(array);
		array.add("MC\u00B2");
		array.remove("E");
		array.sort(null);
		pw.println("The document produced this sub-dictionary, which includes " + (array.size()-1)
							+ " entries.");
		char unicode = 65;
		for (int i = 0; i <array.size(); i++)
		{
			if (array.get(i).charAt(0) == unicode ) 
			{
				pw.println("\n" + unicode + "\n==");
				unicode++;
			}
			else if (array.indexOf("YET") == i)
			{
				unicode = 89;
				pw.println("\n" + unicode + "\n==");
				unicode++;
			}
			
			pw.println(array.get(i));
		}
	
		
	}
	public static void main(String[] args) 
	{
		
		Scanner scanME = null;
		PrintWriter pw = null;
		
		try
		{
			scanME = new Scanner(new FileInputStream("PersonOfTheCentury.txt"));
			pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
			ReadFile(scanME, pw);
			
			scanME.close();
			pw.close();
			
			System.out.println("File created successfully.");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The file you are looking for was not found." 
							 + "\nReview that the file is in the correct place."
							 + "\nProgram will now terminate.");
			System.exit(0);
		}

		
	}
}
