 package Helis;
/**
 * A Quadcopter is a child of a Helicopter. It has all the inherited methods and attributes including a few of its own. 
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */
public class Quadcopter extends Helicopter {
	/**
	 * The maximum flying speed of a quadcopter object.
	 */
	private int MaxFlyingSpeed;
	/**
	 * Default constructor for the Quadcopter class. Creates a Quadcopter with the default super constructor and sets MaxFlyingSpped to 0.
	 */
		public Quadcopter()
		{		
			this.MaxFlyingSpeed = 0;
		}
		/**
		 * Parameterized constructor that takes values of String, Double, int, int, int, int, int.
		 * @param b A string, brand name of a Quadcopter.
		 * @param p A double, price of a Quadcopter.
		 * @param H An integer, horsepower of a Quadcopter.
		 * @param C An integer, the number of cylinders in a Quadcopter.
		 * @param Cy An integer, the year a Quadcopter was created.
		 * @param PC An integer, the passenger capacity of a Quadcopter.
		 * @param MFS An integer, the maximum flying speed of a Quadcopter. 
		 */
		public Quadcopter(String b, Double p, int H,int C, int Cy, int PC, int MFS)
		{
			setBrand(b);
			setPrice(p);
			setHorsepower(H);
			setCreationYear(Cy);
			setCylinders(C);
			setPassengerCapacity(PC);
			this.MaxFlyingSpeed = MFS;
		}
		/**
		 * Copy constructor for the Quadcopter class. Takes a Quadcopter and creates a new one with the same values. 
		 * @param A A Quadcopter object. 
		 */
		public Quadcopter(Quadcopter A)
		{
			setBrand(A.getBrand());
			setPrice(A.getPrice());
			setHorsepower(A.getHorsepower());
			setCreationYear(A.getCreationYear());
			setCylinders(A.getCylinders());
			setPassengerCapacity(A.getPassengerCapacity());
			this.MaxFlyingSpeed = A.getMaxFlyingSpeed();
		}
		/**
		 * The accessor method for the maximum flying speed in a Quadcopter's engine.
		 * @return INT. The maximum flying speed of a quadcopter. 
		 */
		public int getMaxFlyingSpeed() {
			return MaxFlyingSpeed;
		}
		/**
		 * The mutator method for the maximum flying speed integer of a Quadcopter. 
		 * @param maxFlyingSpeed The maximum flying speed of a quadcopter. 
		 */
		public void setMaxFlyingSpeed(int maxFlyingSpeed) {
			MaxFlyingSpeed = maxFlyingSpeed;
		}
		/**
		 * The toString method for the Quadcopter class.
		 * @return A sentence describing the attributes of the Quadcopter class and their values. 
		 */
		public String toString()
		{
			return "This Quadcopter is of the brand "+ getBrand() + ". Its price is "+ getPrice() + 
					" dollars. It has "+ getHorsepower() + " Horsepower"+ ". It has "+ getCylinders() + " cylinders."
					+ " It has a passenger capacity of "+ getPassengerCapacity() + " people, and was made in "+ getCreationYear()
					+ ". It flies at "+ this.MaxFlyingSpeed +"km/h.";
		}
		/**
		 * The equals method for the Quadcopter class. Checks if two Quadcopter objects have the same attribute values.
		 * @param A An Quadcopter object.
		 * @return True if the attribute values are the same, False otherwise. 
		 */
		public boolean equals(Quadcopter A)
		{
			if(A.getBrand().equals(getBrand()) && A.getPrice() == this.getPrice() && A.getHorsepower() == getHorsepower()
					&& A.getCreationYear() == getCreationYear() && A.getCylinders() == getCylinders() && A.getPassengerCapacity() == getPassengerCapacity())
			{		
				return true;
			}
			
			
			return false;
			
		}


}



