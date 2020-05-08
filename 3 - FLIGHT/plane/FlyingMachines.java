package plane;
/**
 * A FlyingMachine is the parent class created in order to compare the attributes of different types of objects.
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */

//-----------------------------------------------------
// Assignment 2
// Part 1
// Written by: Gianfranco Dumoulin (40097768) and Zuhaad bin Aabid (40085293)
// ------------------------------------------------------
public abstract class FlyingMachines {
/**
 * The default constructor of the Flying Machine class. Will create a flying machine object with no attributes.
 */
	public FlyingMachines() 
	{
		
	}
/**
 * The accessor method for the non existent price attribute of a flying machine. This method is only here to be overridden.
 * @return Will always return a value of 0.
 */
	public double getPrice() 
	{
		
		return 0;
	}

}
