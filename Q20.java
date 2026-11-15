import java.util.Scanner;
public class Q20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter grade A-F: ");
        String g = input.next().toUpperCase();
        
        if (g.equals("A")) System.out.println("4");
        else if (g.equals("B")) System.out.println("3");
        else if (g.equals("C")) System.out.println("2");
        else if (g.equals("D")) System.out.println("1");
        else if (g.equals("F")) System.out.println("0");
        else System.out.println("Invalid grade");
    }
}