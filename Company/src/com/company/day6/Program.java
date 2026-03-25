package com.company.day6;


import com.cdac.ConsoleInput;
import org.oops.utils.LinkedList;

public class Program {

    public static void main(String[] args) {
        int choice = 0;
        final int MENU_ADD = 1;
        final int MENU_DISPLAY = 2;
        final int MENU_SORT = 3;
        final int MENU_EXIT = 4; // Adjusted to match your println (4. Exit)

        LinkedList objList = new LinkedList();
        
        do {
            System.out.println("====================================================");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Info");
            System.out.println("3. Sort");
            System.out.println("4. Exit");
            System.out.println("====================================================");
            System.out.println("Enter your Choice: ");
            choice = ConsoleInput.getInt();

            switch (choice) {
                case MENU_ADD: {
                    int subChoice = 0;
                    final int ADD_MANAGER = 1;
                    final int ADD_SALESPERSON = 2;
                    final int ADD_ENGINEER = 3;
                    final int EXIT_ADD = 4;

                    do {
                        System.out.println("====================================================");
                        System.out.println("1. Add Manager");
                        System.out.println("2. Add Salesperson");
                        System.out.println("3. Add Engineer");
                        System.out.println("4. Exit to Main Menu");
                        System.out.println("====================================================");
                        System.out.println("Enter your Choice: ");
                        subChoice = ConsoleInput.getInt();

                        if (subChoice != EXIT_ADD) {
                            System.out.println("Enter Name: ");
                            String name = ConsoleInput.getString();
                            System.out.println("Enter Address: ");
                            String address = ConsoleInput.getString();
                            System.out.println("Enter Age: ");
                            int age = ConsoleInput.getInt();
                            System.out.println("Enter Gender(true/false): ");
                            boolean gender = Boolean.parseBoolean(ConsoleInput.getString());
                            System.out.println("Enter Basic Salary: ");
                            float basicSalary = ConsoleInput.getFloat();

                            switch (subChoice) {
                                case ADD_MANAGER:
                                    System.out.println("Enter HRA: ");
                                    float hra = ConsoleInput.getFloat();
                                    objList.add(new Manager(name, address, age, gender, basicSalary, hra));
                                    break;

                                case ADD_SALESPERSON:
                                    System.out.println("Enter Commission: ");
                                    float commission = ConsoleInput.getFloat();
                                    objList.add(new SalesPerson(name, address, age, gender, basicSalary, commission));
                                    break;

                                case ADD_ENGINEER:
                                    System.out.println("Enter Bonus: ");
                                    float bonus = ConsoleInput.getFloat();
                                    objList.add(new Engineer(name, address, age, gender, basicSalary, bonus));
                                    break;

                                default:
                                    System.out.println("Invalid Input");
                                    break;
                            }
                        }
                    } while (subChoice != EXIT_ADD);
                }
                break; // End MENU_ADD

                case MENU_DISPLAY: {
                    int subChoice = 0;
                    final int DISPLAY_ALL = 1;
            		final int DISPLAY_FIRST = 2;
            		final int DISPLAY_NEXT = 3;
            		final int DISPLAY_PREVIOUS = 4;
            		final int DISPLAY_LAST = 5;
            		final int EXIT_DISPLAY = 6;
            		do {
            			System.out.println("=========================");
            			System.out.println("1. Display All Employee");
            			System.out.println("2. Display First Employee");
            			System.out.println("3. Display Next Employee");
            			System.out.println("4. Display Previous Employee");
            			System.out.println("5. Display Last Employee");
            			System.out.println("6. Exit to Main Menu");
            			System.out.println("Enter your Choice: ");
            			subChoice = ConsoleInput.getInt();

                        switch(subChoice) 
                        {
                        case DISPLAY_ALL:
				                        	for(int itmp=0; itmp<objList.maxCount; itmp++)
				                        	{
				                        		Object data = objList.getNode(itmp);
				                        		dataDisplay(data);
				                        	}break;
				                        		
                        case DISPLAY_FIRST:
                        				{
                        				Object first = objList.getFirst();
                        				dataDisplay(first);
                        				}break;
                        				
                        case DISPLAY_NEXT: {
                        					Object next = objList.getNext();
                        					dataDisplay(next);
                        					} break;
                        					
                        case DISPLAY_PREVIOUS:{
                        						Object previous = objList.getPrevious();
                        							dataDisplay(previous);
                        						} break;
                        						
                        case DISPLAY_LAST:{
                        					Object last = objList.getLast();
                        					dataDisplay(last);
                        				} break;
                        				
                        case EXIT_DISPLAY:{System.out.println("Exiting Display Menu...");}break;
                        default: System.out.println("Invalid Input. Choose Again."); break;
                    
                        }
                    } while (subChoice != EXIT_DISPLAY);
                }
                break; // End MENU_DISPLAY
                
                case MENU_SORT:{
                	 int subChoice = 0;
                	 final int SORT_MANAGERS= 1;
                	 final int SORT_ENGINEERS = 2;
                	 final int SORT_SALESPERSON = 3;
                	 final int SORT_ASC = 4;
                	 final int SORT_DESC = 5;
                	 final int EXIT_SORT =6;
                	 
                	 do {
                		 System.out.println("=========================");
                		 System.out.println("1. Sort All Managers");
                		 System.out.println("2. Sort All Engineers");
                		 System.out.println("3. Sort All SalesPersons");
                		 System.out.println("4. All Employees Alphabetic order ascending");
                		 System.out.println("5. All Employees Alphabetic order descending");
                		 System.out.println("6. Exit to Main Menu");
                		 System.out.println("=========================");
                		 System.out.println("Enter your Choice: ");
             			 subChoice = ConsoleInput.getInt();
             			 
             			 switch(subChoice) 
             			 {
             			 case SORT_MANAGERS:{
             				 
             				 for(int iTmp=0; iTmp<objList.maxCount; iTmp++)
             				 {
             					 for(int jTmp=0; jTmp<objList.maxCount-1;jTmp++) 
             					 {
             						Manager m1 = (Manager) objList.getNode(jTmp);
             			            Manager m2 = (Manager) objList.getNode(jTmp+1);

             			            if(m1.name.compareTo(m2.name) > 0)
             			            {
             			            	Object tmp = objList.getNode(jTmp);       // save m1
             			            	objList.delete(jTmp);                     // remove m1
             			            	objList.delete(jTmp);                     // remove m2 (shifted up)
             			            	objList.insert(jTmp, m2);                 // insert m2 first
             			            	objList.insert(jTmp + 1, (Manager)tmp);   // insert m1 after
             			            }
             					 }
             			    }
             				for(int itmp=0; itmp<objList.maxCount; itmp++)
                        	{
                        		Object data = objList.getNode(itmp);
                        		Employee objEmployee  = (Employee) data;
                 				if(objEmployee instanceof Manager)
                 				{
                 					Manager objManager =(Manager) objEmployee;
                 					System.out.println(objManager.display());
                 				}
                        	}
             				
             			 }break;
             			 case SORT_ENGINEERS:{}break;
             			 case SORT_SALESPERSON:{}break;
             			 case SORT_ASC:{}break;
             			 case SORT_DESC:{}break;
             			 case EXIT_SORT:{System.out.println("Exiting Sorting Menu...");}break;
             			 default: System.out.println("Invalid Input. Choose Again."); break;
             			 
             			 
             			 
             			 }
                		 
                		 
                		 
                		 
                		 
                	 } while(subChoice!=EXIT_SORT);
                	 
                	 
                }
                case MENU_EXIT:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Input.");
                    break;
            }
        } while (choice != MENU_EXIT);
    }

	private static void dataDisplay(Object data) {
		Employee objEmployee  = (Employee) data;
		if(objEmployee instanceof Manager)
		{
			Manager objManager =(Manager) objEmployee;
			System.out.println(objManager.display());
		}
		else if(objEmployee instanceof SalesPerson)
		{
			SalesPerson objSalesPerson = (SalesPerson) objEmployee;
			System.out.println(objSalesPerson.display());
		}
		else
		{
			Engineer objEngineer = (Engineer) objEmployee;
			System.out.println(objEngineer.display());
		}
	}

    // Helper methods moved outside of main
    private static Employee getEmployee(Employee[] arrEmployee, int iTmp) {
        return arrEmployee[iTmp]; // Simplified for logic check
    }
}