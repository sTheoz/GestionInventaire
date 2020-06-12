package src.Model.devices;

public class Test {
    public static void main(String[] args) {
        Phone p = new Phone("ref", "mi mix 3", "Xiaomi", 8.8, Phone.SE.Android, 5.2, Device.State.NEW, "S206");
        System.out.println(p.toString());
        Device d = new Phone("ref", "mi mix 3", "Xiaomi", 8.8, Phone.SE.Android, 5.2, Device.State.NEW, "S206");
        System.out.println(d.toString());
        p = (Phone) d;
        System.out.println(p.getSystemExp());
        System.out.println(Stock.getInstance().getInventory());
    }
}