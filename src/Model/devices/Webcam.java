package src.Model.devices;

import src.Model.Storage;

public class Webcam extends Device{

	public enum Resolution{LOW, MEDIUM, HIGH, NA};  
	
	private Resolution res ; 
	
	public Webcam (String ref, String name, String brand, double price, Resolution rs, State st, Storage location, Device.Type type, int id){
		super(ref, name, brand, price, st, location, type, id);
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
