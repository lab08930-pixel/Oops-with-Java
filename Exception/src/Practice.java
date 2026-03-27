import java.util.Scanner;

class Exceptionn
{
	public void processWithdraw(double totalAmount , double withdrawAmount)
	{
		if (withdrawAmount > totalAmount)
		{
			throw new IllegalArgumentException("Withdraw Amount is Greater than Total Amount");
		}
		
		System.out.println("Processing Amount "+ withdrawAmount);
		System.out.println("Remaining Amount = "+ (totalAmount - withdrawAmount));
	}
}

public class Practice 
{
	public static void main(String[] ss)
	{
		Scanner sc = new Scanner(System.in);
		double balance = 1000;
		Exceptionn e = new Exceptionn();
		
		System.out.println("Current Balance = "+balance);
		System.out.println("Enter Withdraw Amount");
		int n=6;
		
		try {
			try 
			{
				if(n==6)
				{
					throw new Exception ("Not a good practice");
				}
			}catch(Exception e1) {
				System.out.println(e1.getMessage());
			}
			finally {
				System.out.println("Try inside Try");
			}
			
			double withdrawAmount = sc.nextDouble();
			
			e.processWithdraw(balance,withdrawAmount);
			
		}catch(IllegalArgumentException err) {
			System.out.println("Error = "+ err.getMessage());
			
		}
		catch(Exception err) {
			System.out.println("Invalid");
		}
		finally{
			sc.close();
			System.out.println("Completed........ Please Visit Again");
		};
	}
}