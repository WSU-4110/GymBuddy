import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to GymBuddy Demo v1.1");
        System.out.println("-------------------");
        System.out.println();
        System.out.println("Input a number to select the option:");
        System.out.println("(1) User Registration");
        System.out.println("(2) Demo User");

        int choice = input.nextInt();

        switch(choice) {
            case 1:
                System.out.println("user registration");
                break;
            case 2:
                System.out.println("Welcome to our User Demo");

                Boolean run = true;
                user testSubject = new user();

                while (run == true) {
                    System.out.println("(1) Load preset user");
                    System.out.println("(2) Display user info");
                    System.out.println("(3) Change user's full name");
                    System.out.println("(4) Change user's sex");
                    System.out.println("(5) Change user's date of birth");
                    System.out.println("(6) Change user's phone number");
                    System.out.println("(7) Change user's email");
                    System.out.println("(8) exit ");
                    int option = input.nextInt();

                    String temp;
                    int tempint;

                    switch (option) {
                        case 1:
                            testSubject.demoUser();
                            System.out.println();
                            break;
                        case 2:
                            testSubject.infoDump();
                            System.out.println();
                            break;
                        case 3:
                            System.out.println();
                            System.out.println("Input the new first name: ");
                            temp = input.next();
                            testSubject.setFirstName(temp);
                            System.out.println();

                            System.out.println("Input the new last name: ");
                            temp = input.next();
                            testSubject.setLastName(temp);
                            System.out.println();
                            break;
                        case 4:

                            System.out.println();
                            System.out.println("Input the users sex: ");

                            temp = input.next();
                            // not working????
                            // works if you replace temp with 'female'????
                            //System.out.println(temp);
                            //auto sets to female for demo
                            // weirdest issue ever
                            testSubject.setGender("female");
                            System.out.println();
                            break;
                        case 5:
                            System.out.println();
                            System.out.println("Input the day of birth");
                            tempint = input.nextInt();
                            testSubject.setBirthdayDay(tempint);
                            System.out.println();
                            System.out.println();
                            System.out.println("Input the month of birth");
                            tempint = input.nextInt();
                            testSubject.setBirthdayMonth(tempint);
                            System.out.println();
                            System.out.println();
                            System.out.println("Input the year of birth");
                            tempint = input.nextInt();
                            testSubject.setBirthdayYear(tempint);
                            System.out.println();
                            break;
                        case 6:
                            // see if this needs the dashes or not
                            System.out.println();
                            System.out.println("Input the new phone number in the from XXX-XXX-XXXX");
                            temp = input.next();
                            testSubject.setPhoneNumber(temp);
                            System.out.println();
                            break;
                        case 7:
                            System.out.println();
                            System.out.println("Input the new email");
                            temp = input.next();
                            testSubject.setEmail(temp);
                            System.out.println();
                            break;
                        case 8:
                            run = false;
                            break;
                    }
                }
                break;
        }
        /*
        System.out.println("Demo User");
        System.out.println();
        testUser test = new testUser();
        test.user1.infoDump();
        // i don't like this method because it relies on knowing that in test there is a
        // container named 'user1' and you need prior knowledge of that by reading code
        // basically object in side an object
        */
    }


    public void registration(){

    }
}
