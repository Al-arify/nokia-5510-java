import java.util.Scanner;
public class Q23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month name and year: ");
        String month = input.next();
        int year = input.nextInt();

        boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        month = month.toLowerCase();

        if (month.equals("january") || month.equals("march") || month.equals("may") || month.equals("july") || month.equals("august") || month.equals("october") || month.equals("december")) {
            System.out.println(month + " " + year + " has 31 days");
            
        } else if (month.equals("april") || month.equals("june") || month.equals("september") || month.equals("november")) {
            System.out.println(month + " " + year + " has 30 days");
        } else if (month.equals("february")) {
            if (isLeap) System.out.println(month + " " + year + " has 29 days");
            else System.out.println(month + " " + year + " has 28 days");
        } else {
            System.out.println("Invalid month");
        }
    }
}