package src.devices;

public class Tablet extends Telephone{

	public Tablet(){
		super();
		this.type = Devices.Type.Tablet;
	}
	
	public Tablet (String ref, String nom, String marque, double prix, SE se, double sz){
		super(ref, nom, marque, prix, se, sz);
		this.type = Devices.Type.Tablet;
	}
	
}
