// the purpose of this program is to act as an inventory software for someone who owns an appliance store
// they are prompted with the following main menu 
// System.out.print("What do you want to do?" 
// 				"1. Enter new appliances (password required)" 
// 				"2. Change information of an appliance (password required)" 
// 				"3. Display all appliances by a specific brand" 
// 				"4. Display all appliances under a certain a price." 
// 				"5. Quit"
// the user input that follows details how the program will operate



import java.util.Scanner;

/**
 * This is the Driver for the Appliance class. It implements methods from Appliance.
 * The purpose of this class is to serve as an interface for a user 
 * to access, add, display or modify parts of their inventory of appliances.
 * @author Zuhaad bin Aabid and Gianfranco Dumoulin 
 * @version 1.0
 */

public class Driver 
{

/**
 * The value of the number of password attempts is stored in this variable.
 */
public static int count = 0;
/**
 * The maximum number of Appliances that the user's store can contain.
 */
public static int MaxAppliance = 0;
/**
 * ----------------------------------------------------------
 */
public static int countinven = 0;
/**
 * The store's "inventory". An array of Appliances.
 */
static Appliance[] inventory;
/**
 * A key variable in the ApplianceModify() method. It is used to store the location of a unique Appliance within the inventory array.
 */
public static int currentArrayindex;

/**
 * This method will print a closing message and exit the program.
 */
public static void TerminateFinal() // terminates the program
{
	System.out.print(" Thank you for using the Appliance Application.");
}

/**
 * Will cycle through the array of Appliances until an appliance with a price less than the price parameter is found.
 * @param price A price that the user has input to find an Appliance cheaper than this price.
 * @return If there is a price that is less than the price requested it will return true, if not, it will return false.
 */
public static boolean pricecheck(double price)
{
	for(int i = 0;i<MaxAppliance;i++) //for loop cycles through array to find any value that is less than the price
	{									//returns true if it does.
		if(inventory[i].getprice() < price)
		{
			return true;
		}
	}
	return false;
}
/**
 * Will cycle through the array of appliances. For each appliance,
 * it will compare the parameter price to the price of the Appliance. If there is an appliance with a lower price, the appliance will be printed.
 * If there is no appliance will a lower price, the user will be informed. 
 * @param price A price that the user has input to find an Appliance cheaper than this price.
 */
public static void findPricelowerthan(double price)
{
	if(pricecheck(price))
{
	for (int i = 0;i<MaxAppliance;i++)        			//for loop cyrcles through array and prints any appliance 
	{														// lower than price inputed
		if(inventory[i].getprice() < price)
		{
			System.out.print(inventory[i]);
		}
	}
}
	else
	{
		System.out.println("No appliances with a price lower than "+ price);
	}
}

/**
 *  Will cycle through the array of Appliances, checking if the brand requested by the user is equal to the brand of one of the 
 * 		   existing appliances.
 * @param Brand The brand of an Appliance object requested by the user.  
 * @return If there is an existing Appliance with this brand it will return true, if not, it will return false.
 */
public static boolean Appliancecheck(String Brand)
{
	for (int i = 0;i<MaxAppliance;i++ )
	{
		if(inventory[i].getbrand().equals(Brand))  //for loop cycles through array and if statement determines which
		{											// appliance matches the required brand and returns true at the first
			return true;							//instance.
		}
	}
	return false;
}
/**
 * Will print all the Appliances of a specific brand.
 * @param Brand The brand of an Appliance input by the user. 
 */
public static void findAppliancesBy(String Brand)
{
	System.out.println("Here are all the appliances with the associated brand: ");	
	if(Appliancecheck(Brand))
	{
		for (int i = 0;i<MaxAppliance;i++)
		{
			if(inventory[i].getbrand().equals(Brand))					//for loop cycles through array and prints
			{														// all appliances with same brand name
				System.out.println(inventory[i]);
			}
		}
	}
	else
	{
		System.out.print("No such brand in array. Please try again");
	}
		mainmenu();
}

/**
 * Termination text for when password has been unsuccessfully input twelve times.
 */

public static void terminate()
{
	System.out.println("Program detected suspicious activities and will terminate\n" +  //suspicous termination of program
			"immediately!");
}
/**
 * Will validate whether or not the type of the type parameter is among the allowed types.
 * @param type The type of Appliance
 * @return Will return true if type is a string containing Fridge, Air-conditioner, Washer, Dryer, Freezer, Stove, Dishwasher, Water-Heater or Microwave. Will return false otherwise.
 */
public static boolean typeValidation(String type)
{
	if(type.equals("Fridge")||type.equals("Air-conditioner"))
	{
		return true;
	}
	else if(type.equals("Washer")||type.equals("Dryer")) //multiple if statements to determine whether type is a match
	{
		return true;
	}
	else if(type.equals("Freezer")||type.equals("Stove"))
	{
		return true;
	}
	else if(type.equals("Dishwasher")||type.equals("Water-Heater"))
	{
		return true;
	}
	else if(type.equals("Microwave"))
	{
		return true;
	}
	return false;
}
/**
 * Prints the menu for changing type, brand and price of an Appliance and quiting (going back to the mainmenu). Prompts the user for input about the change they are making.
 *  Takes user input and changes the Appliance values as requested by the user. Calls itself until the user quits.
 */
public static void changeRequest()   //switch handles different cases required by user through a sub-menu
{
	System.out.print("\nWhat information would you like to\n" + 
			"change?\n" + 
			"1. brand\n" + 
			"2. type\n" + 
			"3. price\n" + 
			"4. Quit\n" + 
			"Enter your choice > ");
	Scanner choice = new Scanner(System.in);
	switch (choice.nextInt())
	{
	case 1:
		System.out.print("What do you want the new brand to be? ");
		inventory[currentArrayindex].setbrand(choice.next());
		changeRequest();
		break;
	case 2:
		System.out.print("What do you want the new type to be? ");
		if (typeValidation(choice.next()))
		{
			inventory[currentArrayindex].settype(choice.next());
		}	
		else 
		{
			System.out.print("\nPlease enter an appliance from the following choices \n"
    				+ "(Fridge, Air-conditioner, Washer, Dryer, Freezer, Stove, \n"
    				+ "Dishwasher, Water-Heater, and Microwave.)\n\n");
		}
		changeRequest();
		break;
	case 3:
		System.out.print("What do you want the new price to be? ");
		inventory[currentArrayindex].setprice(choice.nextDouble());
		changeRequest();
		break;
	case 4:
		mainmenu();
		break;
	default:
		System.out.println("That is not a valid input.\nPlease try again.\n");
		changeRequest();
		break;
		
	}
}
/**
 * Obtains serial number from user and searches for an Appliance with the same serial number. Will then run changeRequest() if such an Appliance is found. 
 * If not the user will be informed that there is no matching serial numbers in the inventory.
 */
public static void ApplianceModify() // attains serial number from user and searches for appliance with the serial
{										// then begins the code for changing values
	System.out.print("Please enter the Serial Number of the appliance: "); 
	Scanner Serial = new Scanner(System.in);
	long Serialnum = Serial.nextLong();
	for(int i = 0; i<MaxAppliance ; i++)
	{
		if(inventory[i].getSerial() == Serialnum)
		{
			currentArrayindex = i;
			System.out.println(inventory[i]);
			changeRequest();
		}
		else if (i == MaxAppliance) // if no appliance with serial number exists gives the user a y/n
		{											//where user decides to continue or repeat and enter correct values
			System.out.println("No such Appliance exists.");
			System.out.print("Would you like to try another serial number (y/n): ");
			String yn = Serial.next();
			if(yn.equals("y"))
			{
				ApplianceModify();
			}
			else if(yn.equals("n"))
			{
				mainmenu();
			}
		}
	}
}


/**
 * Adds objects to the inventory array by taking user input for multiple Appliance objects at a time.
 */
public static void addOBJ() //add objects to the array
{
	int i = 1;
	if(countinven == MaxAppliance)
	{
		System.out.print("You have reached the max amount of space in your store. ");
		mainmenu();
	}
	
	System.out.print("Please enter how many appliances you would like to add: ");
	Scanner objnum = new Scanner(System.in);
    int objamount = objnum.nextInt();
    int x = MaxAppliance - countinven;
    if (objamount > MaxAppliance)
    {
    	System.out.println("\nYou entered more than the maximum amount of remaining spaces please try again. \n"
    			+ "The remaining spaces are: " + x);
    	addOBJ(); 
    }
    else
    {
    while ( countinven < objamount)
    {
    	System.out.print("Please enter the type of Appliance "+i + ": ");
    	String newType = objnum.next();
    	    	currentArrayindex = i - 1;
    	if(typeValidation(newType))
    	{
    	System.out.print("Please enter the brand of Appliance "+ i +": ");
    	String newBrand = objnum.next();
    	System.out.print("Please enter the price of Appliance "+i +": ");
    	Double newPrice = objnum.nextDouble();
    	inventory[countinven] = new Appliance(newType,newBrand,newPrice);
    	countinven++;
    	i++;
    	}
    	else
    	{
    		System.out.print("Please enter an appliance from the following choices \n"
    				+ "(Fridge, Air-conditioner, Washer, Dryer, Freezer, Stove, \n"
    				+ "Dishwasher, Water-Heaters, and Microwave.)\n");
    		addOBJ(); 
    	}
    	
    }
    System.out.print("\nAll appliances succesfully added.\n");
    }
	mainmenu();
}

/**
 * Will check if the password input by the user matches the saved password.
 * @param p The password input by the user.
 * @return If the passworod matches, returns true. If not, returns false.
 */
public static boolean passcheck(String p) //checks the password
	{				
		for (int i = 1; i <= 3; i++)
		{
			if (p.equals("c249") && i<3)
			{
				return true;
			}
			else if(p != "c249" && i<3)
			{
				System.out.print("Please enter the correct password: ");
				Scanner password = new Scanner(System.in);
				String pass = password.next();
				p = pass;
			}				
			else if (i == 3)
			{
				if(count == 3)
				{
					terminate();
				}
				else if(count <3)
				{				
					count++;
					mainmenu();						
				}
			}
		}
		return false;
	}
/**
 * Prints the main menu of the program. Gives the option to choose between, entering a new Appliance, 
 * changing the information of an existing appliance,
 * display all appliances by a specific brand,
 * displaying all appliances under a certain price,
 * and quiting the program.
 */
public static void mainmenu()   //main hub where user selects the options he wants to do through a menu
	{									//main menu handled by if statements and links to seperate methods for each action
	System.out.println("");
		Scanner option = new Scanner(System.in);		
		System.out.print("What do you want to do?\n" + 
				"1. Enter new appliances (password required)\n" + 
				"2. Change information of an appliance (password required)\n" + 
				"3. Display all appliances by a specific brand\n" + 
				"4. Display all appliances under a certain a price.\n" + 
				"5. Quit\n"
				+ "Please enter your choice > ");
		int choice = option.nextInt();
		 if(choice == 1)
		{
			System.out.print("Please enter your password: ");
			
			String pass = option.next();
			if (passcheck(pass))
			{
				count = 0;
				addOBJ();		
			}			
		}
		else if(choice == 2)	
		{
			System.out.print("Please enter your password: ");
			String pass = option.next();
			if (passcheck(pass))
			{
				count = 0;
				ApplianceModify();
			}
		}
		else if(choice == 3)
		{
			System.out.print("Please enter the name of the brand: ");
			String brandchoice = option.next();
			findAppliancesBy(brandchoice);
		}
		else if(choice == 4)
		{
			System.out.print("Please enter the price: ");
			Double pricecheck = option.nextDouble();
			findPricelowerthan(pricecheck);
			mainmenu();
		}
		else if(choice == 5)
		{
			TerminateFinal();
		}
		option.close();
	}
/**
 * The main method for the driver class. Stars the program and accepts user input for initial values like inventory.
 * @param args
 */
public static void main(String[] args) //start of program and taking in initial values.
	{
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("-----Welcome to the Appliance Application-----");
		System.out.print("Please indicate the maximum number of appliances"
				+ "\nyour store can contain -> ");
		MaxAppliance = input.nextInt();
		inventory = new Appliance[MaxAppliance];
		System.out.println("Thank you for your input");		
		mainmenu();

		
		input.close();
	}
	

}
