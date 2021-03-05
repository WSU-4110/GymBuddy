import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        String name = "";
        String password = "";
        //database.login.connect("admin","password123");
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to GymBuddy Demo v1.1");
        System.out.println("-------------------");
        System.out.println();
        System.out.println("Input a number to select the option:");
        System.out.println("(1) User Registration");
        System.out.println("(2) Login");
        int choice = input.nextInt();

        switch(choice) {
            case 1://registers a user by going to the registration tab, and applies the information entered into the users.csv file
                System.out.println("user registration");
                database.registration.register();
                break;
            case 2://takes the username and password given by the user, and compares it user info in users.csv to see if the match
                boolean loggedIn = false;
                input.nextLine();
                while (loggedIn == false) {
                    System.out.println("Please enter your first name");
                    name = input.nextLine();
                    System.out.println("Please enter your password");
                    password = input.nextLine();

                    if (database.login.connect(name, password) == true) {// if user info matches, it will log the user in, and show who the active user is
                        System.out.println(name + " Logged in successfully");
                        loggedIn = true;
                    } else {
                        System.out.println("Login failed");
                    }
                }
                user active= new user();
                String loggedUser[] =  (database.userGrab.grab(name,password));//this creates a class instance from the user.java page, and makes it easier to manipulate data
                active = activeUser(loggedUser);
                while (loggedIn == true) {
                    System.out.println("(1) Display user info");
                    System.out.println("(2) Change user's full name");
                    System.out.println("(3) Change user's sex");
                    System.out.println("(4) Change user's date of birth");
                    System.out.println("(5) Change user's phone number");
                    System.out.println("(6) Change user's email");
                    System.out.println("(7) Exit");
                    int option = input.nextInt();

                    String temp;
                    int tempint;

                    switch (option) {
                        case 1:
                            active.infoDump();
                            System.out.println();
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("Input the new first name: ");
                            temp = input.next();
                            active.setFirstName(temp);
                            System.out.println();

                            System.out.println("Input the new last name: ");
                            temp = input.next();
                            active.setLastName(temp);
                            System.out.println();
                            break;
                        case 3:

                            System.out.println();
                            System.out.println("Input the users sex: ");
                            temp = input.next();
                            // not working????
                            // works if you replace temp with 'female'????
                            active.setGender(temp);
                            System.out.println();
                            break;
                        case 4:
                            System.out.println();
                            System.out.println("Input the day of birth");
                            tempint = input.nextInt();
                            active.setBirthdayDay(tempint);
                            System.out.println();
                            System.out.println();
                            System.out.println("Input the month of birth");
                            tempint = input.nextInt();
                            active.setBirthdayMonth(tempint);
                            System.out.println();
                            System.out.println();
                            System.out.println("Input the year of birth");
                            tempint = input.nextInt();
                            active.setBirthdayYear(tempint);
                            System.out.println();
                            break;
                        case 5:
                            // see if this needs the dashes or not
                            System.out.println();
                            System.out.println("Input the new phone number in the form XXX-XXX-XXXX");
                            temp = input.next();
                            active.setPhoneNumber(temp);
                            System.out.println();
                            break;
                        case 6:
                            System.out.println();
                            System.out.println("Input the new email");
                            temp = input.next();
                            active.setEmail(temp);
                            System.out.println();
                            break;
                        case 7:
                            loggedIn = false;
                            break;
                        default:
                            System.out.println("error not a valid choice");
                            break;
                    }

                }

                break;
        }

        }
    public static user activeUser(String[] user){//creates a user class for the active user in the client session
        user active = new user();
        active.setFirstName(user[0]);
        active.setLastName(user[1]);
        active.setPhoneNumber(user[3]);
        active.setEmail(user[4]);
        active.setGender(user[5]);
        active.setBirthdayYear(Integer.parseInt(user[6]));
        active.setBirthdayMonth(Integer.parseInt(user[7]));
        active.setBirthdayDay(Integer.parseInt(user[8]));

        return active;
    }



}
