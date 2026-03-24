public class Program {

	public static void main(String[] args) {
		int choice = 0;
		final int MENU_ADD = 1;
		final int MENU_DISPLAY = 2;
		final int MENU_EXIT = 3;

		Employee[] arrEmployee = new Employee[100];
		int indexEmployee = 0;

		do {
			System.out.println("====================================================");
			System.out.println("1.Add Employee");
			System.out.println("2. Display Info");
			System.out.println("3. Exit");
			System.out.println("====================================================");
			System.out.println("Enter your Choice: ");
			choice = ConsoleInput.getInt();

			switch (choice) {
			case MENU_ADD: {
				indexEmployee = handleAdd(arrEmployee, indexEmployee);
			}
				break;

			case MENU_DISPLAY: {
				handleDisplay(arrEmployee, indexEmployee);

			}
				break;

			case MENU_EXIT: {
				System.out.println("Exiting Program...");
				break;
			}
			default: {
				System.out.println("Invalid Input. Try Again..");
				break;
			}
			}
		} while (choice != 3);
	}

	private static int handleAdd(Employee[] arrEmployee, int indexEmployee) {
		int subChoice = 0;
		final int ADD_MANAGER = 1;
		final int ADD_SALESPERSON = 2;
		final int ADD_ENGINEER = 3;
		final int EXIT_ADD = 4;
		do {
			System.out.println("=========================");
			System.out.println("1.Add Manager");
			System.out.println("2. Add Salesperson");
			System.out.println("3. Add Engineer");
			System.out.println("4. Exit");
			System.out.println("Enter your Choice: ");
			subChoice = ConsoleInput.getInt();

			if (subChoice != EXIT_ADD) {
				System.out.println("Enter Name of Employee: ");
				String name = ConsoleInput.getString();
				System.out.println("Enter Address of Employee: ");
				String address = ConsoleInput.getString();
				System.out.println("Enter Age of Employee: ");
				int age = ConsoleInput.getInt();
				System.out.println("Enter Gender of Employee: ");
				String tmp = ConsoleInput.getString();
				boolean gender = Boolean.parseBoolean(tmp);
				System.out.println("Enter Basic Salary of Employee: ");
				float basicSalary = ConsoleInput.getFloat();

				switch (subChoice) {
				case ADD_MANAGER: {
					System.out.println("Enter the HRA: ");
					float hra = ConsoleInput.getFloat();
					arrEmployee[indexEmployee++] = new Manager(name, address, age, gender, basicSalary, hra);
				}
					break;

				case ADD_SALESPERSON: {
					System.out.println("Enter the Commission: ");
					float commission = ConsoleInput.getFloat();
					arrEmployee[indexEmployee++] = new SalesPerson(name, address, age, gender, basicSalary,
							commission);
				}
					break;

				case ADD_ENGINEER: {
					System.out.println("Enter the Overtime Pay: ");
					float overTime = ConsoleInput.getFloat();
					arrEmployee[indexEmployee++] = new Engineer(name, address, age, gender, basicSalary, overTime);
				}
					break;

				default: {
					System.out.println("Invalid input. Please select again.");
					break;
				}
				}
			} else {
				System.out.println("Exiting ADD, going back to Main Menu...");
			}

		} while (subChoice != 4);
		return indexEmployee;
	}

	private static void handleDisplay(Employee[] arrEmployee, int indexEmployee) {
		int subChoice = 0;
		final int DISPLAY_ALL = 1;
		final int DISPLAY_MANAGER = 2;
		final int DISPLAY_SALESPERSON = 3;
		final int DISPLAY_ENGINEER = 4;
		final int EXIT_DISPLAY = 5;
		do {
			System.out.println("=========================");
			System.out.println("1. Display All Employee");
			System.out.println("2. Display All Manager");
			System.out.println("3. Display All Salesperson");
			System.out.println("4. Display All Engineer");
			System.out.println("5. Exit");
			System.out.println("Enter your Choice: ");
			subChoice = ConsoleInput.getInt();

			switch (subChoice) {
			case DISPLAY_ALL: {
				for (int iTmp = 0; iTmp < indexEmployee; iTmp++) {
					if (arrEmployee[iTmp] instanceof Manager) {
						Manager objManager = (Manager) arrEmployee[iTmp];
						System.out.println(objManager.display());
					} else if (arrEmployee[iTmp] instanceof SalesPerson) {
						SalesPerson objSalesPerson = (SalesPerson) arrEmployee[iTmp];
						System.out.println(objSalesPerson.display());

					} else {
						Engineer objEngineer = (Engineer) arrEmployee[iTmp];
						System.out.println(objEngineer.display());
					}
				}
			}
				break;

			case DISPLAY_MANAGER: {
				for (int iTmp = 0; iTmp < indexEmployee; iTmp++) {
					if (arrEmployee[iTmp] instanceof Manager) {
						Manager objManager = (Manager) arrEmployee[iTmp];
						System.out.println(objManager.display());
					}
				}
			}
				break;

			case DISPLAY_SALESPERSON: {
				for (int iTmp = 0; iTmp < indexEmployee; iTmp++) {
					if (arrEmployee[iTmp] instanceof SalesPerson) {
						SalesPerson objSalesPerson = (SalesPerson) arrEmployee[iTmp];
						System.out.println(objSalesPerson.display());
					}
				}
			}
				break;

			case DISPLAY_ENGINEER: {
				for (int iTmp = 0; iTmp < indexEmployee; iTmp++) {
					if (arrEmployee[iTmp] instanceof Engineer) {
						Engineer objEngineer = (Engineer) arrEmployee[iTmp];
						System.out.println(objEngineer.display());
					}
				}
			}
				break;

			case EXIT_DISPLAY: {
				System.out.println("Exiting Display, going back to Main Menu...");
			}
				break;

			default: {
				System.out.println("Invalid input. Please select again.");
			}
			}
		} while (subChoice != 5);
	}

}