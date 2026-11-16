def main_menu():
    running = True

    while running:
        print("\n==============================")
        print("     NOKIA 5510 MAIN MENU")
        print("==============================")
        print("1. Phone book")
        print("2. Messages")
        print("3. Chat")
        print("4. Call register")
        print("5. Tones")
        print("6. Settings")
        print("7. Call divert")
        print("8. Music")
        print("9. Games")
        print("10. Calculator")
        print("11. Reminders")
        print("12. Clock")
        print("13. Profiles")
        print("14. Services")
        print("15. SIM services")
        print("0. Exit")

        choice = int(input("Enter: "))

        match choice:  
            case 1:
                phonebook_menu()  
            case 2:
                messages_menu()  
            case 3:
                print("Chat - Coming soon")
            case 0:
                print("Phone Off. Bye!")
                return
            case _:
                print("Invalid, try again")


# ===== CHILD 1: Phone book - INNER SWITCH =====
def phonebook_menu():
    while True:
        print("\n--- PHONE BOOK ---")
        print("1. Search")
        print("2. Service Nos")
        print("3. Add name")
        print("4. Erase")
        print("5. Edit")
        print("6. Copy")
        print("7. Assign tone")
        print("8. Send b'card")
        print("9. Options")
        print("10. Speed dials")
        print("11. Voice tags")
        print("0. Back")

        choice = int(input("Enter: "))

        match choice: 
            case 1:
                print("Searching contacts...")
            case 2:
                print("Service Nos...")
            case 3:
                print("Add name...")
            case 4:
                print("Erase...")
            case 5:
                print("Edit...")
            case 6:
                print("Copy...")
            case 7:
                print("Assign tone...")
            case 8:
                print("Send b'card...")
            case 9:
                print("Options - Type of view / Memory status")
            case 10:
                print("Speed dials...")
            case 11:
                print("Voice tags...")
            case 0:
                print("Back to Main Menu")
                return
            case _:
                print("Invalid")


# ===== CHILD 2: Messages - INNER SWITCH =====
def messages_menu():
    while True:
        print("\n--- MESSAGES ---")
        print("1. Write messages")
        print("2. Inbox")
        print("3. Outbox")
        print("4. Picture messages")
        print("5. Templates")
        print("6. Smileys")
        print("7. Message settings")
        print("8. Info service")
        print("9. Voice mailbox number")
        print("10. Service command editor")
        print("0. Back")

        choice = int(input("Enter: "))

        match choice:  
            case 1:
                msg = input("Write message: ")
                print(msg)
            case 2:
                print("Inbox...")
            case 3:
                print("Outbox...")
            case 4:
                print("Picture messages...")
            case 5:
                print("Templates...")
            case 6:
                print("Smileys...")
            case 7:
                message_settings_menu()  
            case 8:
                print("Info service...")
            case 9:
                print("Voice mailbox number...")
            case 10:
                print("Service command editor...")
            case 0:
                print("Back to Main Menu")
                return
            case _:
                print("Invalid")


# ===== LEVEL 3: Message Settings -> Set 1 -> etc =====
def message_settings_menu():
    while True:
        print("\n--- MESSAGE SETTINGS ---")
        print("1. Set 1")
        print("2. Common")
        print("0. Back")

        choice = int(input("Enter: "))

        match choice:
            case 1:
                print("Set 1: Message centre number, Message sent as, Validity")
            case 2:
                print("Common: Delivery reports, Reply via same centre")
            case 0:
                return
            case _:
                print("Invalid")

if __name__ == "__main__":
    main_menu()
