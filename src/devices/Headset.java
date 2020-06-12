package src.devices;

public class Headset extends Devices{
	
	//1 = VR headset - 0 = headset
	private int vr;

	public Headset(){
		super();
		this.vr = 0;
	}
	
	public Headset (String ref, String name, String brand, double price, State st){
		super(ref, name, brand, price, st);
		this.vr = 0;
	}

	public Headset (String ref, String name, String brand, double price, int vr, State st){
		super(ref, name, brand, price, st);
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
