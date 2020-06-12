package src.Model.devices;

public class Phone extends Device{
	
	public enum SE{Android, iOs, Windows, NA};
	
	private SE systemExp ; 
	double size ; 
	
	
	public Phone(){
		super();
		this.systemExp = SE.NA;
		this.size = 0.0;
	}
	
	public Phone (String ref, String name, String brand, double price, SE se, double sz, State st){
		super(ref, name, brand, price, st);
		systemExp = se ; 
		size = sz ;
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
