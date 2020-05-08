import java.util.Scanner;
public class CellPhone implements Cloneable {
	private long serialNum;
	private static long serialNumCntr = 1000000;
	private String brand;
	private int year; 
	private double price;
	
	public CellPhone() 
	{
		brand = "NoName";
		year = 0;
		price = 100.0;
		serialNum = serialNumCntr;
		serialNumCntr++;
	}
	public CellPhone(long serialNum, String brand, int year, double price) 
	{
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.serialNum = serialNum;
	}
	public CellPhone(CellPhone c1, long l1) 
	{
		this.brand = c1.brand;
		this.year = c1.year;
		this.price = c1.price;
		serialNum = l1;
	}
	public CellPhone clone() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nPlease enter your desired serial number: ");
		CellPhone c1 = new CellPhone(sc.nextLong(), this.brand, this.year, this.price);
		sc.close();
		return c1;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getSerialNum()
	{
		return serialNum;
	}
	
	public boolean equals(Object x)
	{
		if (x == null || x.getClass() != this.getClass())
			return false;
		CellPhone c1 = (CellPhone)x;
		if (this.brand.equals(c1.brand) && Double.compare(this.price, c1.price) == 0 && this.year == c1.year)
			return true;
		return false;
	}
	public String toString()
	{
		return "[" + this.serialNum + ": " + this.brand + " " + this.price + " " + this.year + "]"; 
	}
	
}
