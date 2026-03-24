public class Date 
{
	private int day,month,year;
	
	public boolean isLeap(int year) {
		return (year%4==0 && year%100!=0) || (year%400==0);
	}
	
	public int daysInMonth(int month, int year) {
		int [] arr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(isLeap(year)&& month==2)
		{
			return 29;
		}
		return arr[month];
	}
	public void setDate(int day, int month, int year)
	{
		// year
		if(year>=1)
		{
			this.year=year;
		}
		else
		{
			this.year=2026;
		}
		// month
		if(month>=1 && month<=12)
		{
			this.month=month;
		}
		else
		{
			this.month=1;
		}
		
		int maxDays = daysInMonth(this.month,this.year);
		// day		
		if(day>=1 && day<=maxDays)
		{
			this.day=day;
		}
		else
		{
			this.day=1;
		}
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}
	public int getYear() { 
		return year;
	}
	
	public int totalDays()
	{
		int month = this.getMonth();
		int year = this.getYear();
		
		int total = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		
		for(int i=1; i<month; i++)
		{
			total += daysInMonth(i,year);
		}
		return total+this.getDay();
	}
	
	public int addDays(int days)
	{
		
		return ( this.totalDays() + days);
	}
	
	
}
