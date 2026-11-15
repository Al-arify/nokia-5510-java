import java.util.Scanner;

public class Learning {
public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
		
         System.out.print("Enter first number: ");
         int number = input.nextInt();
         int reverse = 0;

        while(number > 0){
         int digit = number % 10;
	      number = number / 10;
        reverse = reverse * 10 + digit;
        }
         System.out.print(reverse);
        
        }
      }



