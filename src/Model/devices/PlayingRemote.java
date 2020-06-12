package src.Model.devices;

public class PlayingRemote extends Device{
	
	public PlayingRemote (String ref, String name, String brand, double price, State st, String location, Device.Type type, int id){
		super(ref, name, brand, price, st, location, type, id);
	}
	
	public String toString(){
		return super.toString();
	}
}
