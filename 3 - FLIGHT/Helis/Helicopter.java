package Helis;

import plane.Airplane;
/**
 * A helicopter is a child of an Airplane. It has all the inherited methods and attributes including a few of its own. 
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */
public class Helicopter extends Airplane {
	/**
	 * The number of cylinders a helicopter has in its engine.
	 */
	private int Cylinders;
	/**
	 * The year that the helicopter was created.
	 */
	private int CreationYear;
	/**
	 * The number of passengers a helicopter can hold. 
	 */
	private int PassengerCapacity;
	/**
	 * The default constructor for a helicopter object. Creates a Helicopter and sets the values to default. 
	 */
	public Helicopter()
	{
		this.Cylinders = 0;
		this.CreationYear = 0;
		this.PassengerCapacity = 0;
	}
	/**
	 * Parameterized constructor for the Helicopter class. Creates a helicopter and sets the values of the object equal to the ones inputed.
	 * @param b The String brand of a helicopter object.
	 * @param p The double price of a helicopter object. 
	 * @param H The Int horsepower of a helicopter object.
	 * @param C The Int Creation year of a helicopter object.
	 * @param Cy The Int Cylinders of a helicopter object.
	 * @param PC The Int passenger capacity of a helicopter object.
	 */
	public Helicopter(String b, Double p, int H, int C, int Cy, int PC)
	{
		setBrand(b);
		setPrice(p);
		setHorsepower(H);
		this.CreationYear = Cy;
		this.Cylinders = C;
		this.PassengerCapacity =  PC;
	}
	/**
	 * Copy constructor for the helicopter class. Takes a helicopter and creates a new one with the same values. 
	 * @param A A helicopter object. 
	 */
	public Helicopter(Helicopter A)
	{
		setBrand(A.getBrand());
		setPrice(A.getPrice());
		setHorsepower(A.getHorsepower());
		this.CreationYear = A.CreationYear;
		this.Cylinders = A.Cylinders;
		this.PassengerCapacity =  A.PassengerCapacity;
	}
	/**
	 * The accessor method for the number of Cylinders in a helicopter's engine.
	 * @return INT. The number of cylinders.
	 */
	public int getCylinders() {
		return Cylinders;
	}
	/**
	 * The mutator method for the number of Cylinders in a helicopter's engine.
	 * @param cylinders Int. The number of cylinders. 
	 */
	public void setCylinders(int cylinders) {
		Cylinders = cylinders;
	}
	/**
	 * The accessor method for the year the helicopter was created. 
	 * @return The creation year of a helicopter object.
	 */
	public int getCreationYear() {
		return CreationYear;
	}
	/**
	 * The mutator method for the year the helicopter was created.
	 * @param creationYear The year the helicopter was created.
	 */
	public void setCreationYear(int creationYear) {
		CreationYear = creationYear;
	}
	/**
	 * Accesor method for the Passenger Capacity attribute.
	 * @return Returns the passenger capacity of a helicopter.
	 */
	public int getPassengerCapacity() {
		return PassengerCapacity;
	}
	/**
	 * Mutator method for the Passenger Capacity attribute.
	 * @param PassengerCapacity The passenger capacity of a helicopter. 
	 */
	public void setPassengerCapacity(int PassengerCapacity) {
		this.PassengerCapacity = PassengerCapacity;
	}
	/**
	 * The toString method for the Helicopter class.
	 * @return A sentence describing the attributes of the Helicopter class and their values. 
	 */
	public String toString()
	{
		return "This Helicopter is of the brand "+ getBrand() + ". Its price is "+ getPrice() + 
				" dollars. It has "+ getHorsepower() + " Horsepower."+ " It has "+ this.Cylinders+ " cylinders"
				+ ". It has a passenger capacity of "+ this.PassengerCapacity+ " people, and was made in "+this.CreationYear + ".";
	}
	/**
	 * The equals method for the Helicopter class. Checks if two Helicopter objects have the same attribute values.
	 * @param A An Helicopter object.
	 * @return True if the attribute values are the same, False otherwise. 
	 */
	public boolean equals(Helicopter A)
	{
		if(A.getBrand().equals(getBrand()) && (Double.compare(A.getPrice(), this.getPrice()) == 0) && getHorsepower() == A.getHorsepower()
				&& A.CreationYear == this.CreationYear && A.Cylinders == this.Cylinders && A.PassengerCapacity == this.PassengerCapacity)
		{
			return true;
		}
		return false;
	}

}
