
public class DateMain 
{
	public static void main(String[] agrs) {
		
		Date currentDate = new Date();
		
		System.out.println("Enter Day ");
		int day = ConsoleInput.getInt();
		
		System.out.println("Enter Month ");
		int month = ConsoleInput.getInt();
		
		System.out.println("Enter Year ");
		int year = ConsoleInput.getInt();
		
		currentDate.setDate(day, month, year);
		display(currentDate);
		
		System.out.println(currentDate.totalDays());
	}
	
	 public static void display(Date currentDate) {
	        System.out.print("CURRENT DATE: ");
	        System.out.println(currentDate.getDay() + "/" + currentDate.getMonth() + "/" + currentDate.getYear());
	    }
}

