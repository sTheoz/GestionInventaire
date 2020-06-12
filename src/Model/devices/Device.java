package src.Model.devices;

public abstract class Device {
	
	public enum State{OK, KO, INCIDENT, GOOD, BAD, NEW, NA}

	protected String reference ; 
	protected String name ; 
	protected String brand ;
	protected double price ;
	protected State state;
	protected int id;

	public Device(String ref, String name, String brand, double price, State st){
		super();
		Stock s = Stock.getInstance();
		this.id = s.getId();
		this.reference = ref ;
		this.name = name ;
		this.brand = brand ;
		this.price = price ;
		this.state = st;
	}

	public Device(){
		super();
		this.state = State.NEW;
		Stock s = Stock.getInstance();
		this.id = s.getId();
	}

	public State getState(){
		return state;
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

	public void setState(State st){
		this.state = st;
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
