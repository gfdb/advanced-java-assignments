package Multirotor;
import Helis.Helicopter;

/**
 * A MultiRotor is a child of an Helicopter. It has all the inherited methods and attributes including a few of its own. 
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */
public class MultiRotor extends Helicopter{
	/**
	 * The number of rotors a multirotor object has.
	 */
	private int numRotors;
	/**
	 * The default constructor for a Multirotor object. Creates a Multirotor and sets the values to default. 
	 */
	public MultiRotor()
	{
			this.numRotors = 0;
	}
	/**
	 * Parameterized constructor that takes values of String, Double, int, int, int, int, int.
	 * @param b A string, brand name of a Multirotor object.
	 * @param p A double, price of a Multirotor object.
	 * @param H An integer, horsepower of a Multirotor object.
	 * @param C An integer, the number of cylinders of a Multirotor object.
	 * @param Cy An integer, the creation year of a Multirotor object.
	 * @param PC An integer, the number of passengers of a Multirotor object.
	 * @param R An integer, the number of rotors of a Multirotor object.
	 */
	public MultiRotor(String b, Double p, int H, int C, int Cy, int PC, int R)
	{
		setBrand(b);
		setPrice(p);
		setHorsepower(H);
		setCreationYear(Cy);
		setCylinders(C);
		setPassengerCapacity(PC);
		this.numRotors = R;
	}
	/**
	 * Copy constructor for the Multirotor class. Takes a Multirotor and creates a new one with the same values. 
	 * @param A A Multirotor object. 
	 */
	public MultiRotor(MultiRotor A)
	{
		setCreationYear(A.getCreationYear());
		setCylinders(A.getCylinders());
		setPassengerCapacity(A.getPassengerCapacity());
		setBrand(A.getBrand());
		setPrice(A.getPrice());
		setHorsepower(A.getHorsepower());
		this.numRotors = A.getnumRotors();
	}
	/**
	 * The accessor method for a Multirotor object.
	 * @return The number of rotors of a Multirotor object.
	 */
	public int getnumRotors() {
		return numRotors;
	}
	/**
	 * The mutator method for the number of rotors of a multirotor.
	 * @param rotorcount The number of rotors. 
	 */
	public void setnumRotors(int rotorcount) {
		numRotors = rotorcount;
	}
	/**
	 * The toString method for the Multirotor class.
	 * @return A sentence describing the attributes of the Multirotor class and their values. 
	 */
	public String toString()
	{
		return "This MultiRotor is of the brand " + getBrand() + ". Its price is "+ getPrice() + 
				" dollars. It has "+ getHorsepower() + " Horsepower."+ " It has "+ getCylinders() + " cylinders."
				+ " It has a passenger capacity of " + getPassengerCapacity() + " people and was made in "+ getCreationYear()
				+ ". It has " + this.numRotors + " rotors.";
	}
	/**
	 * The equals method for the Multirotor class. Checks if two Multirotor objects have the same attribute values.
	 * @param A An Multirotor object.
	 * @return True if the attribute values are the same, False otherwise. 
	 */
	public boolean equals(MultiRotor A)
	{
		if( A.getBrand().equals(this.getBrand())&& (Double.compare(A.getPrice(), this.getPrice()) == 0) && A.getHorsepower() == getHorsepower()
				&& A.getCreationYear() == getCreationYear() && A.getCylinders() == getCylinders() && A.getPassengerCapacity() == getPassengerCapacity()
				&& A.numRotors == this.numRotors)
		{
			return true;
		}
		return false;
	}
}