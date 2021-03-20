
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
	
	public static void swap(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		DigitalVideoDisc tmp = new DigitalVideoDisc();
		tmp.setDVD(disc1);
		disc1.setDVD(disc2);
		disc2.setDVD(tmp);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.title();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
