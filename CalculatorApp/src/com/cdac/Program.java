/*public class Program {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int choice;


        do {
        	System.out.println("==========Menu==========");
            System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n0. Exit");
            System.out.println("Choose option: ");
            choice = ConsoleInput.getInt();

            if (choice == 0) break;

            System.out.println("\nChoose Input Type:");
            System.out.println("1. Ints | 2. Floats | 3. Mixed (Int + Float)");
            int type = ConsoleInput.getInt();

            float resultF = 0;
            int resultI = 0;
            boolean isIntResult = false; // Flag to track which result to show

            switch (type) {
                case 1:
                    System.out.print("Enter Int 1: ");
                    int i1 = ConsoleInput.getInt();
                    System.out.print("Enter Int 2: ");
                    int i2 = ConsoleInput.getInt();

                    switch (choice) {
                        case 1: resultI = calc.add(i1, i2);      break;
                        case 2: resultI = calc.subtract(i1, i2); break;
                        case 3: resultI = calc.multiply(i1, i2); break;
                        case 4: resultF = calc.division(i1, i2); break; 
                    }
                    break;

                case 2:
                    System.out.print("Enter Float 1: ");
                    float f1 = ConsoleInput.getFloat();
                    System.out.print("Enter Float 2: ");
                    float f2 = ConsoleInput.getFloat();

                    switch (choice) {
                        case 1: resultF = calc.add(f1, f2);      break;
                        case 2: resultF = calc.subtract(f1, f2); break;
                        case 3: resultF = calc.multiply(f1, f2); break;
                        case 4: resultF = calc.division(f1, f2); break;
                    }
                    break;

                case 3:
                    System.out.print("Enter Int: ");
                    int mi = ConsoleInput.getInt();
                    System.out.print("Enter Float: ");
                    float mf = ConsoleInput.getFloat();

                    switch (choice) {
                        case 1: resultF = calc.add(mi, mf);      break;
                        case 2: resultF = calc.subtract(mi, mf); break;
                        case 3: resultF = calc.multiply(mi, mf); break;
                        case 4: resultF = calc.division(mi, mf); break;
                    }
                    break;
            }

            System.out.println("----------------------------------------");

            if (isIntResult) {
                System.out.println("⭐ RESULT: " + resultI);
            } else {
                System.out.println("⭐ RESULT: " + resultF);
            }
            System.out.println("----------------------------------------");

        } while (choice != 0);

        System.out.println("Goodbye!");
    }
}*/
package com.cdac;

public class Program {
    public static void main(String[] args) {
        Calculator calculate = new Calculator();
        int choice;

        do {
            System.out.println("\nSelect Operation:");
            System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n0. Exit");
            System.out.print("Choose operation: ");
            choice = ConsoleInput.getInt();

            if (choice == 0) break;

            System.out.println("\nChoose Input Type:");
            System.out.println("1. Ints | 2. Floats | 3. Mixed (Int + Float)");
            int type = ConsoleInput.getInt();

            System.out.println("----------------------------------------");

            switch (type) {
                case 1: 
                    System.out.print("Enter Int 1: ");
                    int i1 = ConsoleInput.getInt();
                    System.out.print("Enter Int 2: ");
                    int i2 = ConsoleInput.getInt();

                    if (choice == 4) {
                      
                        System.out.println("RESULT: " + calculate.division(i1, i2));
                    } else {
                        int resI = 0;
                        if (choice == 1) resI = calculate.add(i1, i2);
                        else if (choice == 2) resI = calculate.subtract(i1, i2);
                        else if (choice == 3) resI = calculate.multiply(i1, i2);
                        System.out.println("RESULT: " + resI); 
                    }
                    break;

                case 2:
                    System.out.print("Enter Float 1: ");
                    float f1 = ConsoleInput.getFloat();
                    System.out.print("Enter Float 2: ");
                    float f2 = ConsoleInput.getFloat();

                    float resF2 = 0;
                    if (choice == 1) resF2 = calculate.add(f1, f2);
                    else if (choice == 2) resF2 = calculate.subtract(f1, f2);
                    else if (choice == 3) resF2 = calculate.multiply(f1, f2);
                    else if (choice == 4) resF2 = calculate.division(f1, f2);
                    System.out.println("RESULT: " + resF2); 
                    break;

                case 3:
                    System.out.print("Enter Int: ");
                    int mi = ConsoleInput.getInt();
                    System.out.print("Enter Float: ");
                    float mf = ConsoleInput.getFloat();

                    float resF3 = 0;
                    if (choice == 1) resF3 = calculate.add(mi, mf);
                    else if (choice == 2) resF3 = calculate.subtract(mi, mf);
                    else if (choice == 3) resF3 = calculate.multiply(mi, mf);
                    else if (choice == 4) resF3 = calculate.division(mi, mf);
                    System.out.println("RESULT: " + resF3);
                    break;
            }
            System.out.println("----------------------------------------");

        } while (choice != 0);

        System.out.println("Goodbye!");
    }
}