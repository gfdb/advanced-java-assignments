package plane;

import Helis.Helicopter;
import Helis.Quadcopter;
import Multirotor.MultiRotor;
import Uav.UAV;
import Drone.AgriculturalDrone;
import Drone.MAV;
/**
 * The driver class to demonstrate all flying machines.  
 * @author Gianfranco Dumoulin and Zuhaad bin Aabid 
 * @version 1.0
 */
public class Driver {

	/**
	 * Copies an array of FlyingMachine objects. Get's the class of an object, and based on the class, creates 
	 * a new object of that type. 
	 * @param flyingArray An array of flying machines.
	 * @return The copied array of flying machines.
	 */
		public static FlyingMachines[] copyFlyingObjects(FlyingMachines[] flyingArray) 
		{
			int flyingSize = flyingArray.length;
			FlyingMachines[] newFlyingArray=new FlyingMachines[flyingSize];
			for (int j = 0; j < flyingArray.length; j++) 
			{
				String className=flyingArray[j].getClass().getSimpleName();
				switch(className) 
				{
					case "Airplane": 
						newFlyingArray[j]=new Airplane((Airplane) flyingArray[j]);
						break;
					case "Helicopter": 
						newFlyingArray[j]=new Helicopter((Helicopter) flyingArray[j]);
						break;
					case "Quadcopter": 
						newFlyingArray[j]=new Quadcopter((Quadcopter) flyingArray[j]);
						break;
					case "UAV": 
						newFlyingArray[j]=new UAV((UAV) flyingArray[j]);
					break;
					case "MultiRotor": 
						newFlyingArray[j]=new MultiRotor((MultiRotor) flyingArray[j]);
					break;
					case "AgriculturalDrone": 
						newFlyingArray[j]=new AgriculturalDrone((AgriculturalDrone) flyingArray[j]);
					break;
					case "MAV": 
						newFlyingArray[j]=new MAV((MAV) flyingArray[j]);
					break;
				}
			}
			return newFlyingArray;
		}
		

	public static void main(String[] args) {

		int count = 0;
		Double leastExpensive[] = new Double[2];
		Double holder0 = 0.0;
		Double holder1 = 0.0;
		
		Airplane A1 = new Airplane("Airbus" , 300000.0, 30);
		Airplane A2 = new Airplane("Airbus" , 300000.0, 30);
		Airplane A3 = new Airplane("BOENG" , 500000.0, 31);
		
		Helicopter H1 = new Helicopter("Eurocopter", 15000.0, 15, 4, 2009, 2);
		Helicopter H2 = new Helicopter("Eurocopter", 15000.0, 15, 4, 2009, 2);
		Helicopter H3 = new Helicopter("AmericaCopter", 15000.0, 15, 4, 2009, 2);
		
		Quadcopter Q1 = new Quadcopter("XK", 800.0, 1, 0, 2017, 0, 25);
		Quadcopter Q2 = new Quadcopter("XionToys", 450.0, 1, 0, 2012, 0, 25);
		Quadcopter Q3 = new Quadcopter("XK", 800.0, 1, 0, 2017, 0, 25);
		
		MultiRotor M1 = new MultiRotor("XDrone", 1000.0, 1, 0, 2014, 0, 6);
		MultiRotor M2 = new MultiRotor("YDrone", 1000.0, 1, 0, 2014, 0, 6);
		MultiRotor M3 = new MultiRotor("ZDrone", 1000.0, 1, 0, 2014, 0, 6);
		
		UAV uav1 = new UAV(2500, 1000000.0);
		UAV uav2 = new UAV(3000, 1000000.0);
		UAV uav3 = new UAV(3100, 1000000.0);
		
		AgriculturalDrone AD1 = new AgriculturalDrone(3000, 500000.0, 5000, "TerraFarms");
		AgriculturalDrone AD2 = new AgriculturalDrone(3000, 500000.0, 5000, "LunarFarms");
		AgriculturalDrone AD3 = new AgriculturalDrone(3000, 500000.0, 5000, "MartianFarms");
		
		MAV mav1 = new MAV(2000, 200000.0, "ModelX", 22.3);
		MAV mav2 = new MAV(1000, 3500000.0, "ModelY", 27.3);
		MAV mav3 = new MAV(3000, 250000.0, "ModelZ", 21.3);
		
		
		FlyingMachines AirplaneArray[] = {A1, A2, A3, H1, H2, H3, Q1, Q2, Q3, M1, M2, M3, uav1, uav2, uav3, AD1, AD2, AD3, mav1, mav2, mav3};
		for (int i = 0; i<AirplaneArray.length; i++)
		{
			System.out.println(AirplaneArray[i]);
		}
		
		if (A1.equals(A2)) {
			System.out.println("These two airplanes are the same!");
		} else {
			System.out.println("These two airplanes are not the same!");
		}
		if (A2.equals(A3)) {
			System.out.println("These two airplanes are the same!");
		}
		else {
			System.out.println("These two airplanes are not the same!");
		}
		if (H1.equals(H2)) {
			System.out.println("These two helicopters are the same!");
		}
		else {
			System.out.println("These two helicopters are not the same!");
		}
		
		

		
			// Separate List
			System.out.println("\n\nSeparate List\n-----------------------------\n");
			Airplane[] AirplaneList = {A1, A2, A3, H1, H2, H3, Q1, Q2, Q3, M1, M2, M3};
			UAV[] UAVList= { uav1, uav2, uav3, AD1, AD2, AD3, mav1, mav2, mav3};
			int ASize=AirplaneList.length;
			int USize=AirplaneList.length;
			if (ASize+USize < 2) 
	        { 
	            System.out.println("Should be more at least 2 elements");
	            return; 
	        } 
			else 
	        {
				double min2,min1;
				min2=min1=Double.MAX_VALUE;
				for (int i = 0; i < AirplaneList.length; i++)
				{
					double price=AirplaneList[i].getPrice();
					if(price<min1) {
					min2=min1;
					min1=price;
					}else if (price < min2 && price != min1) { 
						min2 = price; 
					}
				}
				for (int i = 0; i < UAVList.length; i++)
				{
					double price=UAVList[i].getPrice();
					if(price<min1) {
					min2=min1;
					min1=price;
					}else if (price < min2 && price != min1) { 
						min2 = price; 
					}
					
				}
				if (min2 == Double.MAX_VALUE) 
				{
		            System.out.println("No second smallest");
				}
				else 
				{
					System.out.println("The smallest =" + min1 + " and second " + min2); 
				}
	        }
			
			//Using Abstract Class
			System.out.println("\n\nAbstract Class\n-------------------------------\n");
			FlyingMachines[] FlyingList = {A1, A2, A3, H1, H2, H3, Q1, Q2, Q3, M1, M2, M3, uav1, uav2, uav3, AD1, AD2, AD3, mav1, mav2, mav3};
			if (FlyingList.length < 2) 
	        { 
	            System.out.println("Should atleast 2 elements"); 
	            return; 
	        } else {
	        	double min2,min1;
	        	min2=min1=Double.MAX_VALUE;
			for (int i = 1; i < FlyingList.length; i++)
			{
				double price=FlyingList[i].getPrice();
				if(price<min1) {
				min2=min1;
				min1=price;
				}else if (price < min2 && price != min1) { 
					min2 = price; 
				}
			}
				if (min2 == Double.MAX_VALUE) {
		            System.out.println("No second smallest");
				}else {
		            System.out.println("The smallest =" + min1 + " and second " + min2); 
				}
	        }
			
			
			//drive for use of copyFlyingObjects
			System.out.println("\n\ndrive for use of copyFlyingObjects\n-----------------------------\n");
			FlyingMachines[] newFlyingObjects=copyFlyingObjects(FlyingList);
			for (int i = 1; i < newFlyingObjects.length; i++)
			{
				System.out.println(newFlyingObjects[i]);
			}
			System.out.println("A succesful copy has been completed.");
			System.exit(0);
			
	      }
		

		
		

	}


