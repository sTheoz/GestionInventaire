package src.Model.devices;

import src.Model.Storage;

public class Headset extends Device{
	
	//1 = VR headset - 0 = headset
	private int vr;

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
