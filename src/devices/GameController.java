package src.devices;

public class GameController extends Devices{
	
	public GameController(){
		super();
		this.state = State.NEW;
	}
	
	public GameController (String ref, String name, String brand, double price, State st){
		super(ref, name, brand, price, st);
	}
	
	public String toString(){
		return super.toString();
	}
}
