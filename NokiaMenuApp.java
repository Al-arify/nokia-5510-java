import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class NokiaMenuApp {

    // 1. Blueprint for every menu item
    static class MenuNode {
        String title;
        List<MenuNode> subMenus = new ArrayList<>();

        MenuNode(String title) {
            this.title = title;
        }

        // Helper method to attach submenus easily
        MenuNode addSubMenu(MenuNode child) {
            subMenus.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Build the full Nokia 5510 menu tree
        MenuNode mainMenu = buildNokiaMenu();
        
        // Keep track of where the user currently is and where they came from
        MenuNode currentMenu = mainMenu;
        Stack<MenuNode> history = new Stack<>();

        while (true) {
            // Display current menu title and breadcrumb path
            System.out.println("\n==============================");
            System.out.println("  " + currentMenu.title.toUpperCase());
            System.out.println("==============================");

            // Check if we reached a final action (leaf node) or a submenu list
            if (currentMenu.subMenus.isEmpty()) {
                System.out.println("[Action]: Opening " + currentMenu.title + "...");
            } else {
                for (int i = 0; i < currentMenu.subMenus.size(); i++) {
                    System.out.println((i + 1) + ". " + currentMenu.subMenus.get(i).title);
                }
            }

            // Show navigation controls if the user is inside a submenu
            System.out.println("------------------------------");
            if (!history.isEmpty()) {
                System.out.println("0. Back   |   00. Main Menu");
            } else {
                System.out.println("0. Exit App");
            }
            System.out.print("Select option: ");

            String input = scanner.nextLine().trim();

            // Handle 00 (Return straight to Main Menu)
            if (input.equals("00")) {
                history.clear();
                currentMenu = mainMenu;
                continue;
            }

            // Handle 0 (Go Back one level or Exit)
            if (input.equals("0")) {
                if (history.isEmpty()) {
                    System.out.println("Turning off Nokia 5510. Goodbye!");
                    break;
                } else {
                    currentMenu = history.pop();
                    continue;
                }
            }

            // Handle numeric menu selections (1, 2, 3...)
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= currentMenu.subMenus.size()) {
                    history.push(currentMenu); // Save current menu before going deeper
                    currentMenu = currentMenu.subMenus.get(choice - 1);
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }

    // 2. Construct the Nokia 5510 Menu Hierarchy
    private static MenuNode buildNokiaMenu() {
        MenuNode root = new MenuNode("Nokia 5510 Main Menu");

        // --- 1. PHONE BOOK ---
        MenuNode phoneBook = new MenuNode("Phone book");
        MenuNode pbOptions = new MenuNode("Options")
                .addSubMenu(new MenuNode("Memory in use"))
                .addSubMenu(new MenuNode("Type of view"))
                .addSubMenu(new MenuNode("Memory status"));

        phoneBook.addSubMenu(new MenuNode("Search"))
                 .addSubMenu(new MenuNode("Service Nos."))
                 .addSubMenu(new MenuNode("Add name"))
                 .addSubMenu(new MenuNode("Erase"))
                 .addSubMenu(new MenuNode("Edit"))
                 .addSubMenu(new MenuNode("Copy"))
                 .addSubMenu(new MenuNode("Assign tone"))
                 .addSubMenu(new MenuNode("Send b'card"))
                 .addSubMenu(pbOptions)
                 .addSubMenu(new MenuNode("Speed dials"))
                 .addSubMenu(new MenuNode("Voice tags"));

        // --- 2. MESSAGES ---
        MenuNode messages = new MenuNode("Messages")
                .addSubMenu(new MenuNode("Write messages"))
                .addSubMenu(new MenuNode("Inbox"))
                .addSubMenu(new MenuNode("Outbox"))
                .addSubMenu(new MenuNode("Picture messages"))
                .addSubMenu(new MenuNode("Templates"))
                .addSubMenu(new MenuNode("Smileys"))
                .addSubMenu(new MenuNode("Message settings"))
                .addSubMenu(new MenuNode("Info service"))
                .addSubMenu(new MenuNode("Voice mailbox number"))
                .addSubMenu(new MenuNode("Service command editor"));

        // --- 3. CHAT ---
        MenuNode chat = new MenuNode("Chat");

        // --- 4. CALL REGISTER ---
        MenuNode callRegister = new MenuNode("Call register")
                .addSubMenu(new MenuNode("Missed calls"))
                .addSubMenu(new MenuNode("Received calls"))
                .addSubMenu(new MenuNode("Dialled numbers"))
                .addSubMenu(new MenuNode("Erase recent call lists"))
                .addSubMenu(new MenuNode("Show call duration"));

        // --- 5. TONES ---
        MenuNode tones = new MenuNode("Tones")
                .addSubMenu(new MenuNode("Ringing tone"))
                .addSubMenu(new MenuNode("Ringing volume"))
                .addSubMenu(new MenuNode("Incoming call alert"))
                .addSubMenu(new MenuNode("Message alert tone"))
                .addSubMenu(new MenuNode("Keypad tones"))
                .addSubMenu(new MenuNode("Warning tones"))
                .addSubMenu(new MenuNode("Vibrating alert"))
                .addSubMenu(new MenuNode("Screen saver"));

        // --- 6. SETTINGS ---
        MenuNode callSettings = new MenuNode("Call settings")
                .addSubMenu(new MenuNode("Automatic redial"))
                .addSubMenu(new MenuNode("Speed dialling"))
                .addSubMenu(new MenuNode("Call waiting"))
                .addSubMenu(new MenuNode("Summary after call"))
                .addSubMenu(new MenuNode("Send my caller ID"))
                .addSubMenu(new MenuNode("Line for outgoing call"));

        MenuNode phoneSettings = new MenuNode("Phone settings")
                .addSubMenu(new MenuNode("Language"))
                .addSubMenu(new MenuNode("Cell info display"))
                .addSubMenu(new MenuNode("Welcome note"))
                .addSubMenu(new MenuNode("Network selection"))
                .addSubMenu(new MenuNode("Confirm SIM service actions"));

        MenuNode settings = new MenuNode("Settings")
                .addSubMenu(callSettings)
                .addSubMenu(phoneSettings)
                .addSubMenu(new MenuNode("Security settings"))
                .addSubMenu(new MenuNode("Restore factory settings"));

        // --- 7. CALL DIVERT ---
        MenuNode callDivert = new MenuNode("Call divert")
                .addSubMenu(new MenuNode("Divert all voice calls"))
                .addSubMenu(new MenuNode("Divert if busy"))
                .addSubMenu(new MenuNode("Divert if not answered"))
                .addSubMenu(new MenuNode("Cancel all diverts"));

        // --- 8. MUSIC ---
        MenuNode music = new MenuNode("Music")
                .addSubMenu(new MenuNode("Music Player"))
                .addSubMenu(new MenuNode("Radio"))
                .addSubMenu(new MenuNode("Recorder"))
                .addSubMenu(new MenuNode("Track List"));

        // --- 9. GAMES ---
        MenuNode games = new MenuNode("Games")
                .addSubMenu(new MenuNode("Snake II"))
                .addSubMenu(new MenuNode("Pairs II"))
                .addSubMenu(new MenuNode("Space Impact"))
                .addSubMenu(new MenuNode("Bantumi"))
                .addSubMenu(new MenuNode("Bumper"));

        // --- 10. CALCULATOR ---
        MenuNode calculator = new MenuNode("Calculator");

        // --- 11. REMINDERS ---
        MenuNode reminders = new MenuNode("Reminders")
                .addSubMenu(new MenuNode("Add new"))
                .addSubMenu(new MenuNode("View all"));

        // --- 12. CLOCK ---
        MenuNode clock = new MenuNode("Clock")
                .addSubMenu(new MenuNode("Alarm clock"))
                .addSubMenu(new MenuNode("Clock settings"))
                .addSubMenu(new MenuNode("Date setting"));

        // --- 13. PROFILES ---
        MenuNode profiles = new MenuNode("Profiles")
                .addSubMenu(new MenuNode("Normal"))
                .addSubMenu(new MenuNode("Silent"))
                .addSubMenu(new MenuNode("Meeting"))
                .addSubMenu(new MenuNode("Outdoor"))
                .addSubMenu(new MenuNode("Pager"));

        // --- 14. SERVICES ---
        MenuNode services = new MenuNode("Services")
                .addSubMenu(new MenuNode("Home"))
                .addSubMenu(new MenuNode("Bookmarks"))
                .addSubMenu(new MenuNode("Service inbox"))
                .addSubMenu(new MenuNode("Settings"));

        // Attach all 14 main items to the root menu
        root.addSubMenu(phoneBook)
            .addSubMenu(messages)
            .addSubMenu(chat)
            .addSubMenu(callRegister)
            .addSubMenu(tones)
            .addSubMenu(settings)
            .addSubMenu(callDivert)
            .addSubMenu(music)
            .addSubMenu(games)
            .addSubMenu(calculator)
            .addSubMenu(reminders)
            .addSubMenu(clock)
            .addSubMenu(profiles)
            .addSubMenu(services);

        return root;
    }
}