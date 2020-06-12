package src.Model.devices;

public class Tablet extends Phone{

	public Tablet(){
		super();
	}
	
	public Tablet (String ref, String nom, String marque, double prix, SE se, double sz, State st){
		super(ref, nom, marque, prix, se, sz, st);
	}
	
}
