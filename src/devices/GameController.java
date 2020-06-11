package src.devices;

public class GameController extends Devices{
	
	public GameController(){
		super();
		this.type = Devices.Type.GameController;
	}
	
	public GameController (String ref, String nom, String marque, double prix){
		this.reference = ref ;
		this.name = nom ;
		this.brand = marque ;
		this.price = prix ;
		this.type = Devices.Type.GameController;
	}
	
	public String toString(){
		return super.toString();
	}
}
