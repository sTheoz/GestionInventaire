package src.devices;



public class Webcam extends Devices{

	public enum Resolution{LOW, MEDIUM, HIGH, NA};  
	
	private Resolution res ; 
	
	
	public Webcam(){
		super();
		this.res = Resolution.NA;
	}
	
	public Webcam (String ref, String name, String brand, double price, Resolution rs, State st){
		super(ref, name, brand, price, st);
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
