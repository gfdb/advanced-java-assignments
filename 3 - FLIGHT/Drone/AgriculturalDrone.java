package Drone;
import Uav.UAV;
/**
 * A AgriculturalDrone is a child of an UAV. It has all the inherited methods and attributes including a few of its own. 
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */
public class AgriculturalDrone extends UAV {
	/**
	 * Integer, the carrying capacity of a Agricultural Drone.
	 */
	private int Carrycapacity;
	/**
	 * String, the brand of a Agricultural Drone.
	 */
	private String Brand;
	/**
	 * Default constructor for the UAV class.
	 * Default values:
	 * Brand: "null"
	 * Carryingcapacity: 0
	 */
		public AgriculturalDrone()
		{
			this.Carrycapacity = 0;
			this.Brand = "null";
		}
		/**
		 * Parameterized constructor for the AgriculturalDrone class. Takes a Double, Double, Int, String.
		 * @param w The weight of an AgriculturalDrone.
		 * @param p The price of an AgriculturalDrone.
		 * @param CC The Carrying capacity of an AgriculturalDrone.
		 * @param B The Brand of an AgriculturalDrone.
		 */
		public AgriculturalDrone(double w, double p,int CC, String B)
		{
			setWeight(w);
			setPrice(p);
			this.Carrycapacity = CC;
			this.Brand = B;
		}
		/**
		 * Copy constructor for the AgriculturalDrone class. Accepts another AgriculturalDrone object as a parameter.
		 * @param A An AgriculturalDrone object. 
		 */
		public AgriculturalDrone(AgriculturalDrone A)
		{
			this.Carrycapacity = A.Carrycapacity;
			this.Brand = A.Brand;
			setPrice(A.getPrice());
			setWeight(A.getWeight());
		}
		/**
		 * Accessor method for the Carrying Capacity attribute.
		 * @return Returns the int Carrycapacity of an AgriculturalDrone.
		 */
		public int getCarrycapacity() {
			return Carrycapacity;
		}
		/**
		 * The mutator method for the carrying capacity attribute.
		 * @param carrycapacity The carrying capacity of an AgriculturalDrone.
		 */
		public void setCarrycapacity(int carrycapacity) {
			Carrycapacity = carrycapacity;
		}
		/**
		 * Accessor method for the Brand attribute.
		 * @return Returns the String Brand of an AgriculturalDrone.
		 */
		public String getBrand() {
			return Brand;
		}
		/**
		 * The mutator method for the Brand attribute.
		 * @param brand The brand of an AgriculturalDrone.
		 */
		public void setBrand(String brand) {
			Brand = brand;
		}	
		/**
		 * The toString method for the Agricultural Drone class.
		 * @return A sentence describing the attributes of the Agricultural Drone class and their values. 
		 */
		public String toString()
		{
			return "This is a Agricultual drone of weight "+ getWeight() +"kg and price "+ getPrice()
					+ " dollars. It can carry " +this.Carrycapacity+"kg and is of the brand "+this.Brand+".";
		}
		/**
		 * The equals method for the AgriculturalDrone class. Checks if two AgriculturalDrone objects have the same attribute values.
		 * @param A An AgriculturalDrone object.
		 * @return True if the attribute values are the same, False otherwise. 
		 */
		public boolean equals(AgriculturalDrone A)
		{
			if(super.getWeight() == getWeight() && (Double.compare(A.getPrice(), this.getPrice()) == 0) && this.Carrycapacity == A.Carrycapacity && this.Brand.equals(A.Brand))
			{
				return true;
			}
			
			return false;
			
		}
	
}
