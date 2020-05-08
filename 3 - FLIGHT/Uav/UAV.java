package Uav;
import plane.FlyingMachines;
/**
 * A UAV is a child of an FlyingMachine. It has all the inherited methods and attributes including a few of its own. 
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */
public class UAV extends FlyingMachines {
/**
 * The weight of a UAV.
 */
	private double weight;
/**
 * The price of a UAV.
 */
	private double price;
	/**
	 * Default constructor for the UAV class.
	 * Default values:
	 * Price: 0
	 * Weight: 0
	 */
		public UAV()
		{
			this.weight = 0;
			this.price = 0;
		}
	/**
	 * Parameterized constructor for the UAV class. Takes a Double and a Double.
	 * @param w A double, the weight of a UAV object.
	 * @param p A double, The price of a UAv object.
	 */
		public UAV(double w, double p)
		{
			this.weight = w;
			this.price = p;
		}
		/**
		 * Copy constructor for the UAV class. Accepts another UAV object as a parameter. 
		 * Creates a new UAV using the values of the given UAV.
		 * @param A A UAV object.
		 */
		public UAV(UAV A)
		{
			this.weight = A.weight;
			this.price = A.price;
		}
		/**
		 * Accessor method for the Weight attribute.
		 * @return Returns the Double Weight of an UAV.
		 */
		public double getWeight() {
			return weight;
		}
		/**
		 * The mutator method for the Weight attribute.
		 * @param weight The weight of a UAV.
		 */
		public void setWeight(double weight) {
			this.weight = weight;
		}
		/**
		 * Accessor method for the Price attribute.
		 * @return Returns the Double Price of an UAV.
		 */
		public double getPrice() {
			return price;
		}
		/**
		 * The mutator method for the Price attribute.
		 * @param price The price of a UAV.
		 */
		public void setPrice(double price) {
			this.price = price;
		}
		/**
		 * The toString method for the UAV class.
		 * @return A sentence describing the attributes of the UAV class and their values. 
		 */
		public String toString()
		{
			return "This is a UAV of weight "+this.weight+"kg and price "+this.price + " dollars.";
		}
		/**
		 * The equals method for the UAV class. Checks if two UAV objects have the same attribute values.
		 * @param A An UAV object.
		 * @return True if the attribute values are the same, False otherwise. 
		 */
		public boolean equals(UAV A)
		{
			if(A.weight == this.weight && A.price == this.price)
			{
				return true;
			}
			
			return false;
			
		}

}
