package TestPackage;
import LibPackage.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle DVD title: " + jungleDVD.title());
		System.out.println("Cinderella DVD title: " + cinderellaDVD.title());
		
		changeTitle(jungleDVD, cinderellaDVD.title());
		System.out.println("jungle DVD title: " + jungleDVD.title());
	}
	
	public static void swap(Object disc1, Object disc2) {
		Object tmp = disc1;
		disc1 = disc2;
		disc2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.title();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
