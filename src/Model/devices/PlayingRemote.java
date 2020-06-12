package src.Model.devices;

public class PlayingRemote extends Device{
	
	public PlayingRemote (String ref, String name, String brand, double price, State st, String location){
		super(ref, name, brand, price, st, location);
	}
	
	public String toString(){
		return super.toString();
	}
}
