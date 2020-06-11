package src.devices;

public class Sensor extends Devices{
	
	public Sensor(){
		super();
		this.type = Devices.Type.Sensor;
	}
	
	public Sensor (String ref, String nom, String marque, double prix){
		this.reference = ref ; 
		this.name = nom ; 
		this.brand = marque ; 
		this.price = prix ;
		this.type = Devices.Type.Sensor;
	}
	
	public String toString(){
		return super.toString();
	}
}
