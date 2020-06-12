package src.Model.devices;

public class Sensor extends Device{
	
	public Sensor(){
		super();
	}
	
	public Sensor (String ref, String name, String brand, double price, State st, String location){
		super(ref, name, brand, price, st, location);
	}
	
	public String toString(){
		return super.toString();
	}
}
