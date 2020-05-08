package Drone;

import Uav.UAV;
/**
 * A MAV is a child of an UAV. It has all the inherited methods and attributes including a few of its own. 
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */
public class MAV extends UAV {
	/**
	 * A string, the model of a MAV object.
	 */
	private String model;
	/**
	 * A double, the size of a MAV object. 
	 */
	private double size;
	/**
	 * Default constructor for the UAV class.
	 * Default values:
	 * Model: "null"
	 * Size: 1
	 */
		public MAV()
		{
			this.model = "null";
			this.size = 1;
		}
	/**
	 * Parameterized constructor for the MAV class. Takes a Double, Double, String, Double.
	 * @param w Double, the weight of a MAV object.
	 * @param p Double, the price of a MAV object.
	 * @param m String, the model of a MAV object.
	 * @param s Double, the size of a MAV object. 
	 */
		public MAV(double w, double p, String m,double s)
		{
			setWeight(w);
			setPrice(p);
			this.model = m;
			this.size = s;
		}
		/**
		 * Copy constructor for the MAV class. Accepts another MAV object as a parameter.
		 * @param A A MAV object.
		 */
		public MAV(MAV A)
		{
			this.model = A.model;
			this.size = A.size;
			setWeight(A.getWeight());
			setPrice(A.getPrice());
		}
		/**
		 * Accessor method for the Model attribute.
		 * @return Returns the String Model of an MAV.
		 */
		public String getModel() {
			return model;
		}
		/**
		 * The mutator method for the Model attribute.
		 * @param weight The model of a MAV.
		 */
		public void setModel(String model) {
			this.model = model;
		}
		/**
		 * Accessor method for the Size attribute.
		 * @return Returns the Double Size of an MAV.
		 */
		public double getSize() {
			return size;
		}
		/**
		 * The mutator method for the Size attribute.
		 * @param weight The size of a MAV.
		 */
		public void setSize(double size) {
			this.size = size;
		}
		/**
		 * The toString method for the MAV class.
		 * @return A sentence describing the attributes of the MAV class and their values. 
		 */
		public String toString()
		{
			return "This is a MAV of weight "+getWeight()+"kg and price "+getPrice()+" dollars. Its model is "+ this.model
					+ " and is of the size "+this.size + ".";
		}
		/**
		 * The equals method for the MAV class. Checks if two MAV objects have the same attribute values.
		 * @param A An MAV object.
		 * @return True if the attribute values are the same, False otherwise. 
		 */
		public boolean equals(MAV A)
		{
			if(A.getWeight() == this.getWeight() && (Double.compare(A.getPrice(), this.getPrice()) == 0) && A.model.equals(this.model) && A.size == this.size)
			{
				return true;
			}
			
			return false;
		}
	
}
