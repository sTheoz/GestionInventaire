package src.devices;

public class Headset extends Devices{
	
	//1 = VR headset - 0 = headset
	private int vr;

	public Headset(){
		super();
		this.vr = 0;
		this.type = Devices.Type.Headset;
	}
	
	public Headset (String ref, String nom, String marque, double prix){
		this.reference = ref ; 
		this.name = nom ; 
		this.brand = marque ; 
		this.price = prix ;
		this.vr = 0;
		this.type = Devices.Type.Headset;
	}

	public Headset (String ref, String nom, String marque, double prix, int vr){
		this.reference = ref ; 
		this.name = nom ; 
		this.brand = marque ; 
		this.price = prix ;
		this.vr = vr;
		this.type = Devices.Type.Headset;
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
