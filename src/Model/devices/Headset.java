package src.Model.devices;

import src.Model.Storage;

/**
 * Headset est une classe représentant un casque électronique, il peut être VR ou non
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class Headset extends Device{
	
	//1 = VR headset - 0 = headset
	private int vr;

	private static final long serialVersionUID = 411L;

	public Headset (String ref, String name, String brand, double price, int vr, State st, Storage location, Device.Type type, int id){
		super(ref, name, brand, price, st, location, type, id);
		this.vr = vr;
	}
	
	public String toString(){
		return super.toString();
	}

	public int getVR(){
		return this.vr;
	}

	public void setVR(int vr){
		this.vr = vr;
	}
}
