package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;



public class TestPassingParameter {
	public static class DVDWrapper {
		public DigitalVideoDisc dvd;

		public DVDWrapper(DigitalVideoDisc disc) {
			this.dvd = disc;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

		DVDWrapper jungleWrapper = new DVDWrapper(jungleDVD);
		DVDWrapper cinderellaWrapper = new DVDWrapper(cinderellaDVD);
		
		swap(jungleWrapper, cinderellaWrapper);
		System.out.println("Jungle DVD title: " + jungleWrapper.dvd.title());
		System.out.println("Cinderella DVD title: " + cinderellaWrapper.dvd.title());
	}
	
	public static void swap(DVDWrapper disc1, DVDWrapper disc2) {
		DigitalVideoDisc tmp = disc1.dvd;
		disc1.dvd = disc2.dvd;
		disc2.dvd = tmp;
	}

}
