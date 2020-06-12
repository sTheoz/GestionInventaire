package src.Model.devices;

import src.Model.User;

public abstract class Device {
	
	public enum State{OK, KO, INCIDENT, GOOD, BAD, NEW, NA}

	private String reference ; 
	private String name ; 
	private String brand ;
	private double price ;
	private State state;
	private int id;
	private String location;
	private User accountable;
	private boolean available;

	public Device(String ref, String name, String brand, double price, State st, String location){
		super();
		Stock s = Stock.getInstance(0, 0);
		this.id = s.getId();
		this.reference = ref ;
		this.name = name ;
		this.brand = brand ;
		this.price = price ;
		this.state = st;
		this.location = location;
		this.available = true;
		s.addDevice(this);
	}

	public User getAccountable(){
		return this.accountable;
	}

	public String getLocation(){
		return this.location;
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

	public boolean isAvailable(){
		return available;
	}

	public void setLocation(String l){
		this.location = l;
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

	public void setAccountable(User p){
		this.accountable = p;
	}

	public String toString(){
		return "[" + id + "] " + brand + " " + name + " " + price + "€ [" + state + "]";
	}

	public void setAvailable(){
		this.available = true;
	}

	public void setUnavailable(){
		this.available = false;
	}
}
