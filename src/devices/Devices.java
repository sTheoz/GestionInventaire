package src.devices;

public abstract class Devices {
	
	public enum Type{Phone, Sensor, Headset, GameController, Webcam, Tablet};

	protected String reference ; 
	protected String name ; 
	protected String brand ;
	protected double price ;
	protected Type type;
	
	public Type getType(){
		return this.type;
	}

	public String getReference(){
		return reference; 
	}
	
	public String getName(){
		return name; 
	}
	
	public String getBrand(){
		return brand; 
	}
	
	public double getPrice(){
		return price; 
	}
	
	public void setType(Type t){
		type = t;
	}

	public void setReference(String ref){
		reference = ref; 
	}
	
	public void setName(String nm){
		name = nm; 
	}
	
	public void setBrand(String marque){
		brand = marque; 
	}
	public void setPrice(double prix){
		price = prix; 		
	}
	
	public String toString(){
	return " Cet appareil est le " + this.getName()+ " dont la reference est "+ this.getReference()+ " , la marque est "+ this.getBrand()+
			", le prix en euros "+ this.getPrice(); 
	}
	
}
