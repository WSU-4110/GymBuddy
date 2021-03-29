import java.util.Scanner;

public class modifyProfile extends user {
    int choice;


    private modifyProfile(){
        
    }
    public void modifyProfile(user User1) {

        displayUser(User1);


        System.out.println("Type 1 to modify your phone number. Type 2 to modify your email address. Type anything else to exit.");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        scan.close();

        switch (choice) {
            case 1: //for phone
                Scanner sc1 = new Scanner(System.in); //System.in is a standard input stream
                System.out.print("Enter the new phone number: ");
                String str1 = sc1.nextLine();              //reads string
                User1.setPhoneNumber(str1);
                break;

            case 2: //for email
                Scanner sc2 = new Scanner(System.in); //System.in is a standard input stream
                System.out.print("Enter the new email address: ");
                String str2 = sc2.nextLine();              //reads string
                User1.setEmail(str2);
                break;

            default: //default case
                System.out.println("Exited modify profile.");
        }
    }
}
