import java.util.ArrayList;

public class MobilePhone
{
    /*
        Use of a public + private method everywhere to follow information hiding principle.
        The issue was that the parameters for most methods were the sameso I couldn't overload them which led to two methods with different names for private and public access.
     */
    public static ArrayList<Contact> contactArrayList = new ArrayList<>(); //Prevents the need of instantiating the MobilePhone class..

    public static boolean addContact(String name, String number) { //Why does Tim use a static method instead of simple constructors? Is the usage of constructor bad for code readability?
        return addContact(new Contact(name, number));
    }

    private static boolean addContact(Contact contact) {
        if (MobilePhone.contactSearch(contact.getName())) {
            return false;
        }
        contactArrayList.add(contact);
        return true;
    }

    public static void printContacts() {
        printAllContacts();
    }

    private static void printAllContacts() {
        int counter = 1;
        System.out.println("Your saved contacts:");
        for (Contact contact : MobilePhone.contactArrayList) {
            System.out.println(counter++ + ". " + contact.getName() + " | " + contact.getNumber());
        }
    }

    public static boolean editContact(String oldName, String newName, String newNumber) {
        return changeContact(oldName, newName, newNumber);
    }

    private static boolean changeContact(String oldName, String newName, String newNumber) { //Why not just change the fields instead of creating a new contact object like Tim did?
        for (Contact contact : contactArrayList) {
            if (contact.getName().equals(oldName)) {
                contact.setName(newName);
                contact.setNumber(newNumber);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteContact(String name) {
        return removeContact(name);
    }

    private static boolean removeContact(String name) {
        for (Contact contact : contactArrayList) {
            if (contact.getName().equals(name)) {
                contactArrayList.remove(contact);
                return true;
            }
        }
        return false;
    }

    public static boolean contactSearch (String name) {
        return searchForContact(name);
    }

    private static boolean searchForContact(String name) {
        for (Contact contact : contactArrayList) {
            if (contact.getName().equals(name)) {
                return true;
            };
        }
        return false;
    }

}
