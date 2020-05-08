package plane;
/**
 * An Airplane is a child of a FlyingMachine. It inherits all methods and attributes from the class. An airplane 
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 *
 */
public class Airplane extends FlyingMachines {
	/*
	 * Modified from protected to private access. There are some disadvantages of using the private access modifier, 
	 * the biggest one being that private attributes cannot be seen in other classes or child classes. This means that to access private attributes
	 * one must use the Accessor and Mutator methods of a class, if that class has them that is. There are however many advantages to private access modifiers.
	 * Protected is the strongest form of encapsulation in java. Having private attributes leaves little to no risk of there being an impact on other parts
	 * of the program if protected attributes are changed or modified in any way.
	 */
	/**
	 * The brand of an Airplane. For example, BOENG.
	 */
	private String Brand;
	/**
	 * The price of an Airplane.
	 */
	private Double Price;
	/**
	 * The horsepower of an Airplane.
	 */
	private int Horsepower;
/**
 * Default constructor for the Airplane class.
 * Default values:
 * Price: 0
 * Brand: "no brand"
 * Horsepower: 0
 */
		public Airplane()
		{
			this.Brand = "no brand";
			this.Price = 0.0;
			this.Horsepower = 0;
		}
		/**
		 * Parameterized constructor for the Airplane class. Takes a String, Double and Integer as parameters.
		 * @param b The brand of the Airplane.
		 * @param p The price of the Airplane.
		 * @param H The horsepower of the Airplane.
		 */
		public Airplane(String b, Double p, int H)
		{
			this.Brand = b;
			this.Price = p;
			this.Horsepower = H;
		}
		/**
		 * Copy constructor for the Airplane class. Accepts another Airplane object as a parameter. 
		 * Creates a new Airplane using the values of the given Airplane.
		 * @param A An airplane object.
		 */
		public Airplane(Airplane A)
		{
			this.Brand = A.Brand;
			this.Price = A.Price;
			this.Horsepower = A.Horsepower;
		}
		/**
		 * Accessor method for the Brand attribute.
		 * @return Returns the String Brand of an airplane.
		 */
		public String getBrand() {
			return Brand;
		}
		/**
		 * The mutator method for the Brand attribute.
		 * @param brand The brand of an Airplane.
		 */
		public void setBrand(String brand) {
			Brand = brand;
		}
		/**
		 * The accessor method for the Price attribute.
		 * @return Returns the price of a given Airplane.
		 */
		public double getPrice() {
			return this.Price;
		}
		/**
		 * Mutator method for the price attribute of an Airplane. Sets the price of an airplane to a given value.
		 * @param price The price of an airplane.
		 */
		public void setPrice(Double price) {
			Price = price;
		}
		/**
		 * Accessor method for the Horsepower attribute of an Airplane.
		 * @return The horsepower of an Airplane.
		 */
		public int getHorsepower() {
			return Horsepower;
		}
		/**
		 * The mutator method for the horsepower attribute of an Airplane. Sets the horsepower of an airplane to a given value.
		 * @param horsepower The horsepower of an Airplane. 
		 */
		public void setHorsepower(int horsepower) {
			Horsepower = horsepower;
		}
		
		/**
		 * The toString method for the Airplane class.
		 * @return A sentence describing the attributes of the class and their values. 
		 */
		public String toString()
		{
			return "This airplane is of the brand "+ this.Brand + ". Its price is "+ this.Price + 
					" dollars. It has "+ this.Horsepower + " Horsepower.";
		}
		/**
		 * The equals method for the Airplane class. Checks if two Airplane objects have the same attribute values.
		 * @param A An Airplane object.
		 * @return True if the attribute values are the same, False otherwise. 
		 */
		public boolean equals(Airplane A)
		{
			if((A.getBrand()).equals(this.getBrand()) && (Double.compare(A.getPrice(), this.getPrice()) == 0) && (A.getHorsepower() == this.getHorsepower()))
			{
				return true;
			} else
				return false;
		}
		

}
