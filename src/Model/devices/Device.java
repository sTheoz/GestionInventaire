package src.Model.devices;

import src.Model.people.People;

public abstract class Device {
	
	public enum State{OK, KO, INCIDENT, GOOD, BAD, NEW, NA}

	protected String reference ; 
	protected String name ; 
	protected String brand ;
	protected double price ;
	protected State state;
	protected int id;
	protected String location;
	protected People accountable;
	protected boolean available;

	public Device(String ref, String name, String brand, double price, State st, String location){
		super();
		Stock s = Stock.getInstance();
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

	public Device(){
		super();
		this.state = State.NEW;
		Stock s = Stock.getInstance();
		this.id = s.getId();
		this.location = "Storage";
		this.available = true;
		s.addDevice(this);
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

	public void setAccountable(People p){
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
