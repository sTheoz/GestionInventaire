package src.devices;



public class Webcam extends Devices{

	public enum Resolution{LOW, MEDIUM, HIGH};  
	
	private Resolution res ; 
	
	
	public Webcam(){
		res = null; 
		this.type = Devices.Type.Webcam;
	}
	
	public Webcam (String ref, String nom, String marque, double prix, Resolution rs){
	this.reference = ref ; 
	this.name = nom ; 
	this.brand = marque ; 
	this.price = prix ; 
	this.type = Devices.Type.Webcam;

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
