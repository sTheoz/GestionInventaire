package src.Model.devices;

import src.Model.Storage;

public class Phone extends Device{
	
	public enum SE{Android, iOs, Windows, NA};
	
	private SE systemExp ; 
	double size ; 
	
	private static final long serialVersionUID = 412L;

	public Phone (String ref, String name, String brand, double price, SE se, double sz, State st, Storage location, Device.Type type, int id){
		super(ref, name, brand, price, st, location, type, id);
		this.systemExp = se ; 
		this.size = sz ;
	}
	
	
	public void setSystemExp(SE se){
		this.systemExp = se ; 	
	}
	
	public void setSize(double sz){
		this.size =sz ; 		
	}
	
	public double getSize(){
		return size; 	
    }
	public SE getSystemExp(){
		return systemExp ;	
	}
	
	public String toString(){
		return super.toString()	+ " "+ this.getSystemExp() + 
			" "+ this.getSize() + '"'; 
	}
}
