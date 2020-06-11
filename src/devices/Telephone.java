package src.devices;

public class Telephone extends Devices{
	
	public enum SE{Android, iOs, Windows};
	
	private SE systemExp ; 
	double size ; 
	
	
	public Telephone(){
		systemExp = null; 
		size = 0.0;
		this.type = Devices.Type.Phone;
	}
	
	public Telephone (String ref, String nom, String marque, double prix, SE se, double sz){
		this.reference = ref ; 
		this.name = nom ; 
		this.brand = marque ; 
		this.price = prix ;
			
		systemExp = se ; 
		size = sz ;

		this.type = Devices.Type.Phone;
	}
	
	
	public void setSystemExp(SE se){
		systemExp =se ; 	
			
		}
	
	public void setSize(double sz){
	size =sz ; 	
		
	}
	
	public double getSize(){
	return size; 	
    }
	public SE getSystemExp(){
	return systemExp ;	
	
	}
public String toString(){
	return super.toString()	+ ", de systeme d'exploitation "+ this.getSystemExp() + 
			" et de taille "+ this.getSize() ; 
	}
	
	
}
