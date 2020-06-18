package src.Model.devices;

import src.Model.Storage;

/**
 * Webcam est une classe représentant une webcam
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class Webcam extends Device{

	public enum Resolution{LOW, MEDIUM, HIGH, NA};  

	private static final long serialVersionUID = 416L;
	
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
