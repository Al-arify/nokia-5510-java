import java.util.Scanner;

public class NokiaMenu {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        mainMenu(input);
        input.close();
    }

    public static void mainMenu(Scanner input){
            boolean running = true;
            
            while (running) {
                
                System.out.println("\n==============================");
                System.out.println("     NOKIA 5510 MAIN MENU");
                System.out.println("==============================");

               
                System.out.println("1. Phone book");
                System.out.println("2. Messages");
                System.out.println("3. Chat");
                System.out.println("4. Call register");
                System.out.println("5. Tones");
                System.out.println("6. Settings");
                System.out.println("7. Call divert");
                System.out.println("8. Music");
                System.out.println("9. Games");
                System.out.println("10. Calculator");
                System.out.println("11. Reminders");
                System.out.println("12. Clock");
                System.out.println("13. Profiles");
                System.out.println("14. Services");
                System.out.println("15. SIM services");
                System.out.println("0. Exit");
                System.out.print("Enter: ");
                int choice = input.nextInt();

            switch (choice) { // OUTER SWITCH
                case 1:
                    phonebookMenu(input); // Go to INNER SWITCH inside method
                    break;
                case 2:
                    messagesMenu(input); // Go to INNER SWITCH inside method
                    break;
                case 3:
                    System.out.println("Chat - Coming soon");
                    break;
                case 0:
                    System.out.println("Phone Off. Bye!");
                    return;
                default:
                    System.out.println("Invalid, try again");
            }
        }
    }

    // ===== CHILD 1: Phone book - INNER SWITCH =====
    public static void phonebookMenu(Scanner input) {
            while (true) {
                System.out.println("\n--- PHONE BOOK ---");
                System.out.println("1. Search");
                System.out.println("2. Service Nos");
                System.out.println("3. Add name");
                System.out.println("4. Erase");
                System.out.println("5. Edit");
                System.out.println("6. Copy");
                System.out.println("7. Assign tone");
                System.out.println("8. Send b'card");
                System.out.println("9. Options");
                System.out.println("10. Speed dials");
                System.out.println("11. Voice tags");
                System.out.println("0. Back");
                System.out.print("Enter: ");

                int choice = input.nextInt();

            switch (choice) { // INNER SWITCH 1
                case 1:
                    System.out.println("Searching contacts...");
                    break;
                case 2:
                    System.out.println("Service Nos...");
                    break;
                case 3:
                    System.out.println("Add name...");
                    break;
                case 4:
                    System.out.println("Erase...");
                    break;
                case 5:
                    System.out.println("Edit...");
                    break;
                case 6:
                    System.out.println("Copy...");
                    break;
                case 7:
                    System.out.println("Assign tone...");
                    break;
                case 8:
                    System.out.println("Send b'card...");
                    break;
                case 9:
                    System.out.println("Options - Type of view / Memory status");
                    break;
                case 10:
                    System.out.println("Speed dials...");
                    break;
                case 11:
                    System.out.println("Voice tags...");
                    break;
                case 0:
                    System.out.println("Back to Main Menu");
                    return; // BACK to outer switch
                default:
                    System.out.println("Invalid");
            }
        }
    }

    // ===== CHILD 2: Messages - INNER SWITCH =====
    public static void messagesMenu(Scanner input) {
        while (true) {
            System.out.println("\n--- MESSAGES ---");
            System.out.println("1. Write messages");
            System.out.println("2. Inbox");
            System.out.println("3. Outbox");
            System.out.println("4. Picture messages");
            System.out.println("5. Templates");
            System.out.println("6. Smileys");
            System.out.println("7. Message settings");
            System.out.println("8. Info service");
            System.out.println("9. Voice mailbox number");
            System.out.println("10. Service command editor");
            System.out.println("0. Back");
            System.out.print("Enter: ");
            int choice = input.nextInt();

            switch (choice) { // INNER SWITCH 2
                case 1:
                    System.out.println(input.nextLine());
                    break;
                case 2:
                    System.out.println("Inbox...");
                    break;
                case 3:
                    System.out.println("Outbox...");
                    break;
                case 4:
                    System.out.println("Picture messages...");
                    break;
                case 5:
                    System.out.println("Templates...");
                    break;
                case 6:
                    System.out.println("Smileys...");
                    break;
                case 7:
                    messageSettingsMenu(input); // DEEPER NESTING: Switch inside Switch inside Switch
                    break;
                case 8:
                    System.out.println("Info service...");
                    break;
                case 9:
                    System.out.println("Voice mailbox number...");
                    break;
                case 10:
                    System.out.println("Service command editor...");
                    break;
                case 0:
                    System.out.println("Back to Main Menu");
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    // ===== LEVEL 3: Message Settings -> Set 1 -> etc =====
    public static void messageSettingsMenu(Scanner input) {
        while (true) {
            System.out.println("\n--- MESSAGE SETTINGS ---");
            System.out.println("1. Set 1");
            System.out.println("2. Common");
            System.out.println("0. Back");
            System.out.print("Enter: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Set 1: Message centre number, Message sent as, Validity");
                    break;
                case 2:
                    System.out.println("Common: Delivery reports, Reply via same centre");
                    break;
                case 0:
                    return; // Back to Messages
                default:
                    System.out.println("Invalid");
            }
        }
    }
}