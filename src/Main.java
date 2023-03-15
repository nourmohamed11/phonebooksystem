import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        slist sll = new slist();
        ReadFile newIO = new ReadFile();
        Scanner in = new Scanner(System.in);
        String file = ("contacts.txt");

        String menu, search;
        boolean done = false;

        //Menu
        do {
            System.out.println("--------Menu--------");
            System.out.println("1. Add a New Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Sort Contacts");
            System.out.println("4. Search Contact");
            System.out.println("5. Search Recommendations");
            System.out.println("6. Total Time For Program");
            System.out.println("7. Exit");
            System.out.println("---------------------");
            menu = in.nextLine().toUpperCase();

            switch (menu) {
                case "A":
                    System.out.println("Add an entry");

                    System.out.print("Enter a FIRST NAME: ");
                    String firstname = in.nextLine();

                    System.out.print("Enter a LAST NAME: ");
                    String lastname = in.nextLine();

                    System.out.print("Enter an EMAIL ADDRESS: ");
                    String email = in.nextLine();

                    System.out.print("Enter a HOME NUMBER: ");
                    String homenumber = in.nextLine();

                    System.out.print("Enter a PHONE NUMBER: ");
                    String phonenumber = in.nextLine();



                    System.out.print("Enter a PROFESSION: ");
                    String profession = in.nextLine();
                    double a1 = System.nanoTime();
                    sll.add(firstname, lastname, email, homenumber, phonenumber, profession);
                    double b1 = System.nanoTime();
                    double sum = b1-a1;
                    System.out.println("Time com: " + sum);
                    break;

                case "Z":
                    sll.printList();
                break;

                case "S":
                    do {
                        System.out.println("Search for : \nFirst Name \nLast Name \nE-mail \nProfession");
                        search = in.nextLine().toUpperCase();
                        switch (search) {
                            case "F":
                                System.out.println("Enter the First Name to search for: ");
                                firstname = in.nextLine();
                                double a2 = System.nanoTime();
                                sll.firstnameSearch(firstname);
                                double b6 = System.nanoTime();
                                double sum9 = b6-a2;
                                System.out.println("Time com: " + sum9);
                                break;
                            case "L":
                                System.out.println("Enter the Last Name to search for: ");
                                lastname = in.nextLine();
                                double m1 = System.nanoTime();
                                sll.lastnameSearch(lastname);
                                double o1 = System.nanoTime();
                                double sum1= m1-o1;
                                System.out.println("Time com: " + sum1);
                                break;
                            case "E":
                                System.out.println("Enter an E-mail to search for: ");
                                email = in.nextLine();
                                double s1 = System.nanoTime();
                                sll.emailSearch(email);
                                double c1 = System.nanoTime();
                                double sum3= c1-s1;
                                System.out.println("Time com: " + sum3);
                                break;
                            case "P":
                                System.out.println("Enter an Profession to search for: ");
                                profession = in.nextLine();
                                double c3 = System.nanoTime();
                                sll.professionSearch(profession);
                                double c2 = System.nanoTime();
                                double sum5= c3-c2;
                                System.out.println("Time com: " +sum5);
                            default:
                                System.out.println("Unknown entry");
                        }
                    }while (!done);
                    System.out.println("Thanks for using this phonebook project");
                    break;
                case "D":
                    System.out.println("Enter index number to delete: ");
                    int delete = in.nextInt();
                    double p1 = System.nanoTime();
                    sll.delete(delete);
                    double c1 = System.nanoTime();
                    double sum33= p1-c1;
                    System.out.println("Time com: " +sum33);

                    break;
                case "P":
                    System.out.println("Print Phonebook");
                    double l1 = System.nanoTime();
                    sll.printList();
                    double q1 = System.nanoTime();
                    double sum4= l1-q1;
                    break;
                case "R":
                    System.out.println("Restore from disk");
                    newIO.ReadFile(sll);
                    break;
                case "Q":
                    System.out.println("Exiting!");
                    done = true;
                    break;
                default:
                    System.out.println("Unknown entry");
            }
        }  while (!done);
        System.out.println("Thanks for using this phonebook project");

    }
}

