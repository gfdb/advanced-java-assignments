/**
 * An appliance is an object that has four attributes: type, brand, price and serial number.
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid
 * @version 1.0
 */
public class Appliance 
{
	
	/**
	 * @author Zuhaad_bin_Aabid_&_Gianfranco_Dumoulin
	 */
	/**
	 * The type of an Appliance, for example, microwave.
	 */
	private String type;
	/**
	 * The brand of an Appliance, for example, Samsung.
	 */
	private String brand;
	/**
	 * The value of the serial number of the next Appliance that is created.
	 */
	private static long serialnumber = 1000000;
	/**
	 * The price of an Appliance
	 */
	private double price = 1;
	/**
	 * The serial number of an Appliance.
	 */
	private long objserial;

	/**
	 * Parameterized constructor for an Appliance object.
	 * @param t The type of the Appliance. For example, a microwave.
	 * @param b The brand of the Appliance. For example, Samsung.
	 * @param p The price of the Appliance. Units in Dollars. 
	 */
	
	
	Appliance(String t, String b, Double p) //appliance constructor
	{
	
		brand = b;
		type = t;
		price = p;
		serialnumber += 1;		
		objserial = serialnumber;
	}
	
	/**
	 * Will set Appliance price.
	 * The price cannot be less than 1. 
	 * If it is, a string stating this will be printed. 
	 * @param p The replacement price for the Appliance. 
	 */
	public void setprice(double p) //sets the Appliance price
	{
		
		if(price > 1)
		{this.price = p;}
		else	
		{System.out.print("Price cannot be lower than 1$");}
		
	}
	/**
	 * Will set Appliance brand.
	 * @param b The replacement brand for the Appliance. 
	 */
	public void setbrand(String b) //sets the Appliance brand
	{
		this.brand = b;
	}
	/**
	 * This will set the Appliance's type.
	 * @param t The replacement type for the Appliance.  
	 */
	
	public void settype(String t) //sets the Appliance type
	{
		this.type = t;
	}
	/**
	 * Will return the serial number of an Appliance.
	 * @return The serial number of an appliance.
	 */
	public long getSerial()
	{
		return this.objserial;
	}
	/**
	 * Will return the price of an Appliance.
	 * @return The price of an appliance.
	 */
	public double getprice() //gets the objects price
	{
		return this.price;
	}
	/**
	 * Will return the type of an Appliance.
	 * @return The type of an appliance.
	 */
	public String getType() //gets the objects type
	{
		return this.type;
	}
	/**
	 * Will return the brand of an Appliance.
	 * @return The brand of an appliance.
	 */
	public String getbrand() //gets the objects brand
	{
		return this.brand;
	}
/**
 * Prints the price, brand and type of an Appliance.
 * @return a string containing the price, brand and type of an Appliance.
 */
	public String toString() //overrides the toString method
	{
		return "\nPrice: " + this.price + "\nBrand: " + this.brand + "\nType: " + this.type + "\nSerial Number:"	+ this.objserial;
	}
	/**
	 * Checks if two Appliance objects are equal by comparing price, brand and type.
	 * @param b An Appliance object. 
	 * @return If the price, brand and type of both Appliances are the same. It will return true, if not, it will return false.
	 */
	public boolean equals(Appliance b)
	{
		if (this.price == b.price && this.brand == b.brand && this.type == b.type)
			{return true;}
		
		return false;		
	}
	/**
	 * Calculates the number of Appliance objects that have been created.
	 * @return the number of Appliance objects that have been created
	 */
	public static long findNumberOfCreatedAppliances() //returns total appliances made by calculating the difference in serial number 
	{ 												// to the original starting number.
		return serialnumber - 1000000;
	}
	
		
}
