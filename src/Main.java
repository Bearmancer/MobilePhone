import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nokia 5200 booting up...");

        boolean loop = true;
        while(loop) {
            printInstructions();
            System.out.println("\nWhat would you like to do?");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0 -> printInstructions();
                case 1 -> addContact();
                case 2 -> editContact();
                case 3 -> removeContact();
                case 4 -> printContacts();
                case 5 -> loop = false;
                default -> System.out.println("Invalid input entered.");
            }
        }
    }

    private static void printContacts() {
        MobilePhone.printContacts();
    }

    private static void printInstructions() {
        System.out.println("\nPress 0 to see this menu again.");
        System.out.println("Press 1 to add a new contact");
        System.out.println("Press 2 to edit a contact");
        System.out.println("Press 3 to remove a contact");
        System.out.println("Press 4 to print down the phone.");
        System.out.println("Press 5 to shut down the phone.");
    }

    //In the spirit of encapsulation, I have used the Main class to handling all printing (except printing of array as per Tim.)

    public static void addContact() {
        System.out.println("What is the name of your contact?");
        String name = scanner.nextLine();
        System.out.println("What is the number of " + name + "?");
        String number = scanner.nextLine();
        if (MobilePhone.addContact(name, number)) {
            System.out.println("Contact successfully added.");
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public static void editContact() {
        System.out.println("Which contact would you like to edit?");
        String oldName = scanner.nextLine();
        System.out.println("What should " + oldName + "'s name be set to?");
        String newName = scanner.nextLine();
        System.out.println("What should " + newName + "'s number be set to?");
        String newNumber = scanner.nextLine();
        if (MobilePhone.editContact(oldName, newName, newNumber)) {
            System.out.println(oldName + "'s details successfully changed to " + newName + " | " + newNumber);
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void removeContact() {
        System.out.println("Which contact would you like to remove?");
        String name = scanner.nextLine();

        if (MobilePhone.deleteContact(name)) {
            System.out.println(name + " deleted from your contact list.");
        } else {
            System.out.println("Contact not found.");
        }

    }
}