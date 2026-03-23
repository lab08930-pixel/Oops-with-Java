/*
public class Date 
{

	private int day;
	private int month;
	private int year;
	
	public static boolean isLeap(int year) 
	{
	    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	public static int getDaysInMonth(int m, int y) {
	    int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    if (m == 2 && Date.isLeap(y)) {
	        return 29;
	    }
	    return days[m];
	}
	
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
	    int maxDays = getDaysInMonth(month, year);

	    if (day >= 1 && day <= maxDays) {
	        this.day = day;
	    } else {
	        this.day = 1; // Default to 1st if input is invalid
	    }
	}
		
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	
	public int totalDays(Date dateObj) 
	{
		int m = dateObj.getMonth();
		int y = dateObj.getYear();

		int total = 365 * (y - 1) + ((y - 1) / 4) - ((y - 1) / 100) + ((y - 1) / 400);
		
		for (int i = 1; i < m; i++) 
			{
				total = total  + getDaysInMonth(i,y);
			}

		return total + dateObj.getDay();
	}
	
	public Date daysToDate(long N) {
		   
	    long remaining = N - 1; 

	    // Step 1: 400-year cycles (146,097 days)
	    long cycles400 = remaining / 146097;
        remaining = remaining % 146097;
        int year = (int) (cycles400 * 400) + 1;

        // Step 2: 100-year blocks
        long cycles100 = Math.min(remaining / 36524, 3);
        remaining = remaining - (cycles100 * 36524);
        year = year + (int) (cycles100 * 100);
        
        // Step 3: 4-year blocks
        long cycles4 = remaining / 1461;
        remaining = remaining % 1461;
        year = year + (int) (cycles4 * 4);

	    // Step 4: Single years
	    while (true) {
	        int daysInYear = Date.isLeap(year) ? 366 : 365;
	        if (remaining < daysInYear) break;
	        remaining= remaining - daysInYear;
	        year++;
	    }
	    // Step 5: Months
	    int month = 1;
	    while (true) {
	        int daysInThisMonth = getDaysInMonth(month, year); // Use the helper!
	        if (remaining < daysInThisMonth) {
	            break;
	        }
	        remaining = remaining - daysInThisMonth;
	        month = month + 1;
	    }

	    // Step 6: Final Construction
	    int day = (int)remaining + 1;
	    
	    Date result = new Date();
	   
	    result.setDate(day, month, year);
	    
	    return result;
	}
	
	public Date addDays(Date d, int days)
	{
		
		return daysToDate(totalDays(d)+days);
	}
	
	public Date addMonths(Date d1, int monthsToAdd) {
	    
	    int oldDay = d1.getDay();
	    int oldMonth = d1.getMonth();
	    int oldYear = d1.getYear();

	    
	    int totalMonths = (oldYear * 12) + (oldMonth - 1) + monthsToAdd;
	    int newYear = totalMonths / 12;
	    int newMonth = (totalMonths % 12) + 1;

	    
	    int maxDaysInNewMonth = getDaysInMonth(newMonth, newYear);
	    int newDay;
	    
	    if (oldDay > maxDaysInNewMonth) {
	        newDay = maxDaysInNewMonth;
	    } else {
	        newDay = oldDay;
	    }

	    
	    Date result = new Date();
	    result.setDate(newDay, newMonth, newYear);
	    return result;
	}	
	
	public Date addYears(Date date, int yearsToAdd) {
	    // 1 Year is always 12 Months in the Gregorian Calendar
	    int monthsToJump = yearsToAdd * 12;
	    
	    // Reuse the existing logic!
	    return addMonths(date, monthsToJump);
	}
	
	public void compareDates(Date d1, Date d2) {
		int t1 = totalDays(d1);
		int t2 = totalDays(d2);

		if (t1 == t2) {
			System.out.println("Dates are the same.");
		} 
		else {
	        System.out.println("The second date is later than the first.");
	        System.out.println("Difference: " + (t2 - t1) + " days.");
	    }
	}
}*/
public class Date {
    private int day;
    private int month;
    private int year;

    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int m, int y) {
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (m == 2 && Date.isLeap(y)) {
            return 29;
        }
        return days[m];
    }

    public void setDate(int day, int month, int year) {
        this.year = (year >= 1) ? year : 2026;
        this.month = (month >= 1 && month <= 12) ? month : 1;
        int maxDays = getDaysInMonth(this.month, this.year);
        this.day = (day >= 1 && day <= maxDays) ? day : 1;
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    // --- Math Logic ---

    public int totalDays(Date dateObj) {
        int m = dateObj.getMonth();
        int y = dateObj.getYear();
        int total = 365 * (y - 1) + ((y - 1) / 4) - ((y - 1) / 100) + ((y - 1) / 400);
        for (int i = 1; i < m; i++) {
            total += getDaysInMonth(i, y);
        }
        return total + dateObj.getDay();
    }

    public Date daysToDate(long N) {
        long remaining = N - 1;
        long cycles400 = remaining / 146097;
        remaining %= 146097;
        int year = (int) (cycles400 * 400) + 1;

        long cycles100 = Math.min(remaining / 36524, 3);
        remaining -= (cycles100 * 36524);
        year += (cycles100 * 100);

        long cycles4 = remaining / 1461;
        remaining %= 1461;
        year += (cycles4 * 4);

        while (true) {
            int daysInYear = Date.isLeap(year) ? 366 : 365;
            if (remaining < daysInYear) break;
            remaining -= daysInYear;
            year++;
        }

        int month = 1;
        while (true) {
            int daysInThisMonth = getDaysInMonth(month, year);
            if (remaining < daysInThisMonth) break;
            remaining -= daysInThisMonth;
            month++;
        }

        Date result = new Date();
        result.setDate((int) remaining + 1, month, year);
        return result;
    }

    // --- Operation Methods ---

    public Date addDays(int days) {
        return daysToDate(totalDays(this) + days);
    }

    public Date addMonths(int monthsToAdd) {
        int totalMonths = (this.year * 12) + (this.month - 1) + monthsToAdd;
        int newYear = totalMonths / 12;
        int newMonth = (totalMonths % 12) + 1;

        int maxDays = getDaysInMonth(newMonth, newYear);
        int newDay = Math.min(this.day, maxDays);

        Date result = new Date();
        result.setDate(newDay, newMonth, newYear);
        return result;
    }

    public Date addYears(int yearsToAdd) {
        return addMonths(yearsToAdd * 12);
    }

    public long getDifference(Date other) {
        return Math.abs((long) totalDays(this) - totalDays(other));
    }
}