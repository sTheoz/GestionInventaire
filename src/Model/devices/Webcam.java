package src.Model.devices;

public class Webcam extends Device{

	public enum Resolution{LOW, MEDIUM, HIGH, NA};  
	
	private Resolution res ; 
	
	public Webcam (String ref, String name, String brand, double price, Resolution rs, State st, String location){
		super(ref, name, brand, price, st, location);
		res = rs ;
	}
	
	
	public void setRes(Resolution rs){
		res =rs ; 				
		}
	
	public Resolution getRes(){
		return res ;	
	}

	public String toString(){
		return super.toString()+ ", de resolution " + this.getRes();	
	}
}
