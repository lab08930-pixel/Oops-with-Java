public class DateOperation {
	
	private static int getDaysInMonth(int m, int y) {
	    int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    if (m == 2 && DateCheck.isLeap(y)) {
	        return 29;
	    }
	    return days[m];
	}
	public int totalDays(DateCheck dateObj) 
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
	
	public DateCheck daysToDate(long N) {
	   
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
	        int daysInYear = DateCheck.isLeap(year) ? 366 : 365;
	        if (remaining < daysInYear) break;
	        remaining= remaining - daysInYear;
	        year++;
	    }


	    // Step 5: Months (Refactored to match totalDays)
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
	    
	    DateCheck result = new DateCheck();
	   
	    result.setDate(day, month, year);
	    
	    return result;
	}
	
	public DateCheck addDays(DateCheck d, int days)
	{
		
		return daysToDate(totalDays(d)+days);
	}
	
	public DateCheck addMonths(DateCheck d1, int monthsToAdd) {
	    
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

	    
	    DateCheck result = new DateCheck();
	    result.setDate(newDay, newMonth, newYear);
	    return result;
	}	
	public void compareDates(DateCheck d1, DateCheck d2) {
		int t1 = totalDays(d1);
		int t2 = totalDays(d2);

		if (t1 == t2) {
			System.out.println("Dates are the same.");
		} else if (t1 > t2) {
	        System.out.println("The first date is later than the second.");
	        System.out.println("Difference: " + (t1 - t2) + " days.");
	    } else {
	        System.out.println("The second date is later than the first.");
	        System.out.println("Difference: " + (t2 - t1) + " days.");
	    }
	}
	
}