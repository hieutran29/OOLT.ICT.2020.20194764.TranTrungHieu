import java.util.Scanner;

public class DayOfMonth {
	static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 
						 		31, 31, 30, 31, 30, 31
							   };
	
	static String[] MonthInShort = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
					  		 		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
					 				};
	
	static String[] monthInNumber = {"1", "2", "3", "4",
										"5", "6", "7", "8",
										"9", "10", "11", "12"
									};
	
	static String[] Month = {"January", "February", "March", "April", 
								"May", "June", "July", "August", 
								"September", "October", "November", "December"
							};
	
	static int getMonth(String month) {
		int ret = -1;
		if(month.length() >= 3) {
			String substringOfMonth = month.substring(0, 3);
			for(int i = 0; i < 12; i++) {
				if(MonthInShort[i].equals(substringOfMonth)) {
					ret = i;
				}
			}
		}
		else {
			for(int i = 0; i < 12; i++) {
				if(monthInNumber[i].equals(month)) {
					ret = i;
				}
			}
		}
		return ret;
	}
	
	static boolean isValidYear(String year) {
		return year.length() == 4;
	}
	
	static boolean isLeapYear(String year) {
		Integer y = Integer.parseInt(year);
		boolean ret = false;
		if(y % 100 == 0) {
			ret = (y % 400 == 0);
		}
		else {
			ret = (y % 4 == 0);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Month: ");
		String month = scanner.nextLine();
		int indexMonth;
		do {
			indexMonth = getMonth(month);
			if(indexMonth == -1) {
				System.out.println("Invalid month");
				System.out.print("Re-enter month: ");
				month = scanner.nextLine();
			}
		} while(indexMonth == -1);
		
		System.out.print("Year: ");
		String year = scanner.nextLine();
		while(!isValidYear(year)) {
			System.out.println("Invaid year");
			System.out.print("Re-enter year: ");
			year = scanner.nextLine();
		}
		
		int days = daysInMonth[indexMonth];
		days += (isLeapYear(year) && indexMonth == 1 ? 1 : 0);
		System.out.println("# Days in " + Month[indexMonth] + "-" + year + ": " + days);
		
		scanner.close();
	}

}
