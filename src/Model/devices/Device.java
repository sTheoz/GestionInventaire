package src.Model.devices;

import src.Model.User;

import java.io.Serializable;

import src.Model.Storage;

public abstract class Device implements Serializable{
	
	public enum State{OK, KO, NEW, NA}
	public enum Type{Phone, Webcam, Headset, Sensor, PlayingRemote, Tablet, NA}

	private static final long serialVersionUID = 4L;

	private String reference ; 
	private String name ; 
	private String brand ;
	private double price ;
	private State state;
	private int id;
	private Storage location;
	private User accountable;
	private boolean available;
	private Type type;

	public Device(String ref, String name, String brand, double price, State st, Storage location, Type type, int id){
		super();
		this.reference = ref ;
		this.name = name ;
		this.brand = brand ;
		this.price = price ;
		this.state = st;
		this.location = location;
		this.available = true;
		this.type = type;
		this.id = id;
	}

	public User getAccountable(){
		return this.accountable;
	}

	public Storage getLocation(){
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

	public Type getType(){
		return this.type;
	}

	public boolean isAvailable(){
		return available;
	}

	public void setLocation(Storage s){
		this.location = s;
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
