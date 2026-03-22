
public class DateCheck 
{

	private int day;
	private int month;
	private int year;
	
	public void setDate(int day, int month, int year) {
	    // 1. Validate Year (Allow all years from year 1 onwards)
	    if (year >= 1) {
	        this.year = year;
	    } else {
	        this.year = 2026; // Default
	    }

	    // 2. Validate Month
	    if (month >= 1 && month <= 12) {
	        this.month = month;
	    } else {
	        this.month = 1; // Default
	    }

	    // 3. Validate Day
	    int maxDays;
	    if (this.month == 2) {
	        maxDays = isLeap(this.year) ? 29 : 28;
	    } else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
	        maxDays = 30;
	    } else {
	        maxDays = 31;
	    }

	    if (day >= 1 && day <= maxDays) {
	        this.day = day;
	    } else {
	        this.day = 1; // Default to 1st if input is invalid
	    }
	}
	public void display()
	{
		System.out.println("Date: "+day+"/"+month+"/"+year);
	}
	// Inside DateCheck class
	public static boolean isLeap(int year) 
	{
	    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	

}
