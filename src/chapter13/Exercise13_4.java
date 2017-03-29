package chapter13;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exercise13_4 {
	static MyCalendar calendar = new MyCalendar();
	
	public static void main(String[] args) {
		int month = calendar.get(MyCalendar.MONTH) + 1;
		int year = calendar.get(MyCalendar.YEAR);
		if (args.length > 2) {
			System.out.println("Usage java Exercise13_04 month year");
		}
		else if (args.length == 2) {
			year = Integer.parseInt(args[1]);
			month = Integer.parseInt(args[0]);
			
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month - 1);
		}
		else if (args.length == 1) {
			month = Integer.parseInt(args[0]);
			
			calendar.set(Calendar.MONTH, month - 1);
		}
		
		// set date to the first day in a month  会影响 get(Calendar.DAY_OF_WEEK)的值 即这一天是星期几
		calendar.set(Calendar.DATE, 1);
		System.err.println("Calendar.DATE --> " + calendar.get(Calendar.DATE));
		//print calendar for the month
		printMonth(year, month);
	}

	static void printMonth(int year, int month) {
		// get start day of the week for the first date in the month
		int startDay = getStartDay();
		
		System.err.println("startDay --> " + startDay);
		int numOfDaysInMonth = calendar.daysInMonth();
		
		printMonthTitle(year, month);
		
		printMonthBody(startDay, numOfDaysInMonth);
	}

	private static void printMonthBody(int startDay, int numOfDaysInMonth) {
		// print padding space before the first day of the month
		int i = 0;
		// startDay   1 == Sunday - > 
		for (i = 0; i < startDay-1; i++) 
			System.out.print("    ");
		
		for (i = 1; i <= numOfDaysInMonth; i++) {
			System.out.printf("%4d", i);
			
			if ((i + startDay - 1) % 7 == 0)
				System.out.println();
		}
		
		System.out.println("");
	}
	// 得到星期几
	static int getStartDay() {
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	private static void printMonthTitle(int year, int month) {
		System.out.println("         "+calendar.getMonthName()+", "+year);
	    System.out.println("-----------------------------");
	    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

		
	}
	

}

class MyCalendar extends GregorianCalendar {
	/**
	 * @return the number of days in current month
	 */
	public int daysInMonth() {
		switch(super.get(MONTH)) {
			case 0: case 2: case 4: case 6: case 7: case 9: case 11:
				return 31;
			case 1: if (isLeapYear(get(YEAR))) return 29;
						else return 28;
			case 3: case 5: case 8: case 10: return 30;
			default: return 0;
		}
	}
	
	public String getMonthName() {
		String monthName = null;
		
		switch(get(MONTH)) {
			case 0: monthName = "January"; break;
			case 1: monthName = "Feburary"; break;
			case 2: monthName = "March"; break;
			case 3: monthName = "April"; break;
			case 4: monthName = "May"; break;
			case 5: monthName = "June"; break;
			case 6: monthName = "July"; break;
			case 7: monthName = "August"; break;
			case 9: monthName = "september"; break;
			case 10: monthName = "November"; break;
			case 11: monthName = "December"; break;
			default:
		}
		return monthName;
	}
}
