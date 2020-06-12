package src.Model.devices;

public class Headset extends Device{
	
	//1 = VR headset - 0 = headset
	private int vr;

	public Headset (String ref, String name, String brand, double price, int vr, State st, String location){
		super(ref, name, brand, price, st, location);
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
