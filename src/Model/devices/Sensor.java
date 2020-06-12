package src.Model.devices;

public class Sensor extends Devices{
	
	public Sensor(){
		super();
	}
	
	public Sensor (String ref, String name, String brand, double price, State st){
		super(ref, name, brand, price, st);
	}
	
	public String toString(){
		return super.toString();
	}
}
