/*
 * Gianfranco Dumoulin 40097768
 * COMP249
 * Assignment #3
 * November 18 2019
 */



package jsonANDbib;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.StringTokenizer;

/**
 * @author Gianfranco Dumoulin
 * @version 1.0
 */
public class BibReader {
	
	public static int validFiles=0; 
	public static int invalidFiles=0; 
	
	public static void displayFileContents(BufferedReader br) throws IOException
	{
		int unicodeCHAR;
		
		unicodeCHAR = br.read();
		while(unicodeCHAR != -1) 
		{
			System.out.print((char)unicodeCHAR);		
			unicodeCHAR = br.read();		
		}
		
		br.close();
	}
	
	/**
	 * 
	 * @param scanME Scanner object used for the file input stream
	 * @param pIEEE PrintWriter for the IEEE files
	 * @param pACM PrintWriter for the ACM Files
	 * @param pNJ PrintWriter for the NJ Files
	 * @throws FileInvalidException
	 */
	public static void processFilesForValidation(Scanner scanME, PrintWriter pIEEE, PrintWriter pACM, PrintWriter pNJ) throws FileInvalidException {
		
		StringTokenizer tokenizer = null; 
		String[] tkn;
		int tknCntr=0;
		String nextLine="";
		int articleNUM =0;
		
		
		String ieee=""; 
		String ieeeAUTHOR="";
		String ieeeTITLE="";
		String ieeeJOURNAL="";
		String ieeeVOLUME="";
		String ieeeNUMBER="";
		String ieeeMONTH="";
		String ieeeYEAR="";
		String ieeePAGE="";

		String acm="";
		String acmAUTHOR="";

		
		String nj=""; 
		String njAUTHOR="";

		
		String author =""; 
		String title="";	
		String journal="";
		String volume ="";
		String number="";
		String page="";
		String month="";
		String year="";
		String doi ="";
		
		while (scanME.hasNextLine()) 
		{ 
			nextLine= scanME.nextLine();
			
			if (nextLine.contains("={}"))
			{ 
				invalidFiles++; 
				scanME.close(); 
				pIEEE.close();
				pACM.close();
				pNJ.close();
				throw new FileInvalidException("File Invalid. Field \"" + nextLine.substring(0, nextLine.indexOf("=")) + "\" is Empty. Processing stopped at this point. Other empty fields may be present as well!");
			}
			
			else 
			{
				if (nextLine.contains("@ARTICLE{")) 
				{ 
					articleNUM++;
				}
				
				if (nextLine.contains("author={")) 
				{ 
					author = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}"));	
					ieeeAUTHOR = author.replaceAll(" and", ",") + ".";
					njAUTHOR = author.replaceAll("and", "&");
					tokenizer = new StringTokenizer(author, " "); 
					tknCntr = tokenizer.countTokens();
					tkn = new String[tknCntr];
					for(int i=0; i<tknCntr; i++)
					{
						tkn[i] = tokenizer.nextToken();
					}
					author = tkn[0] + " " + tkn[1];
					acmAUTHOR = author + " et al";		
				}
				
				if (nextLine.contains("title={")) { 
					title = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}"));	
					ieeeTITLE= "\""+title+"\"";
				}
				
				if (nextLine.contains("journal={")) { 
					journal = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}")); 
					ieeeJOURNAL = journal;	
				}
				
				if (nextLine.contains("volume={")){ 
					volume = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}")); 
					ieeeVOLUME = "vol. " + volume;	
				}
				
				if (nextLine.contains("number={")) { 
					number = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}")); 
					ieeeNUMBER = "no. " +number;
				}
				
				if (nextLine.contains("pages={")) { 
					page = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}")); 
					ieeePAGE = "p. " + page;
				}
				
				if (nextLine.contains("month={")){ 
					month = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}")); 
					ieeeMONTH = month;	
				}
				
				if (nextLine.contains("year={")){ 
					year = nextLine.substring(nextLine.indexOf("{")+1, nextLine.indexOf("}")); 
					ieeeYEAR = year;	
				}			
				
				if (nextLine.contains("doi={")){ 
					doi = nextLine.substring(nextLine.indexOf("{")+1, nextLine.length()-3);
					doi = "DOI:https://doi.org/" + doi;
				}
				
				
				if (nextLine.equals("}")){ 
					ieee = ieeeAUTHOR +" " + ieeeTITLE +", " + ieeeJOURNAL +", " + ieeeVOLUME +", " + ieeeNUMBER +", " + ieeePAGE +", " + ieeeMONTH + " " + ieeeYEAR +".";
					pIEEE.println(ieee);
					pIEEE.println();
					
					acm = "["+articleNUM+"] "+ acmAUTHOR + ". " + year +". " + title + ". " + journal + ". " + volume + ", " + number + " (" + year + "), " + page +". " + doi +".";
					pACM.println(acm);
					pACM.println();
					
					nj = njAUTHOR + ". " + title + ". " + journal + ". " + volume + ", " + page + " (" + year + ").";
					pNJ.println(nj);
					pNJ.println();
				}
				
			}
			
			if (scanME.hasNextLine() == false) 
				validFiles++;
		}
		scanME.close();
		pIEEE.close();
		pACM.close();
		pNJ.close();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner scanME = null; 
		
		PrintWriter ieee = null; 
		PrintWriter acm = null;
		PrintWriter nj = null;
		
		int attempts =0;
		
		BufferedReader br = null;
		String readFile =""; 
		
		String latexFiles = ""; 
		String ieeeFileName=""; 
		String acmFileName=""; 
		String njFileName =""; 
		
		File ieeeFile = null;  
		File acmFile = null;
		File njFile = null;
		
		System.out.println("Welcome to BibCreator!");
		System.out.println();
		
		
		for (int i=1; i<=10; i++) { 
			latexFiles = "Latex"+i+".bib"; 
		
			ieeeFileName = "IEEE"+i+".json";
			acmFileName = "ACM"+i+".json";
			njFileName = "NJ"+i+".json";
		
			try{
				scanME = new Scanner(new FileInputStream(latexFiles));
				ieee = new PrintWriter(new FileOutputStream(ieeeFileName));
				acm = new PrintWriter(new FileOutputStream(acmFileName));
				nj = new PrintWriter(new FileOutputStream(njFileName));
				ieeeFile = new File(ieeeFileName);
				acmFile = new File(acmFileName);
				njFile = new File(njFileName);
				
				processFilesForValidation(scanME, ieee, acm, nj); 
				
			}
			catch (FileNotFoundException e){ 
				System.out.println("Could not open input file " +latexFiles+ " for reading. Please check if file exists!");
				System.out.println("Program will terminate after closing any opened files.");
				System.exit(0);
			}
			catch (FileInvalidException e) { 
				System.out.println("\nError: Detected Empty Field!\n" +
								   "============================\n");
				System.out.println("Problem detected with input file: " + latexFiles);
				System.out.println(e.getMessage());
				
				if (ieeeFile.delete() == acmFile.delete() == njFile.delete() == true)
					continue;
				else 
				{
					System.out.println("The desgonated output files have NOT been deleted successfully. "
							+ "\nProgram will stop running to prevent a crash.");
					System.exit(0);
				}
				
			}
		
		}
		System.out.println("\n\nA total of " + invalidFiles + " files were invalid, and could not be processed. All other " + validFiles + " \"Valid\" files have been created.\n");
		
		while (attempts < 2) {
			System.out.print("Please enter the name of one of the files that you need to review:");
			readFile = input.next();
			
			try {
				br = new BufferedReader(new FileReader(readFile));
				System.out.println("Here are the contents of the successfully created Jason File: " + readFile);
				attempts =2; 
			}
			catch (FileNotFoundException e) {
				if (attempts >= 1) { 
					System.out.println("Could not open input file again! Either file does not exist or could not be created.");
					System.out.println("Sorry! I am unable to display your desired files! Program will exit!");
					System.exit(0);
				}
				System.out.println("Could not open input file. File does not exist; possibly it could not be created!");
				System.out.println("\nHowever, you will be allowed another chance to enter another file name.");
				attempts++;
				
				
			}
		}
	
		try {
			displayFileContents(br);
			System.out.println("\n\nGoodbye ! Hope you have enjoyed creating then needed files using BibCreator.");
		}
		catch(IOException e) {
			System.out.println("Error occured while reading the file: " + readFile);
			System.out.println("Program will terminate");
			System.exit(0);
		}
	
	}
	
}
