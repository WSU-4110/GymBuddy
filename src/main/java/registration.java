
import java.io.*;
import java.util.*;

public class registration {
    public static void register(){//this lets the user register to the database using the csv file. it saves all of the user info in users.csv
        try{
            Scanner input = new Scanner(System.in);
            FileReader userData = new FileReader("users.csv");
            BufferedReader reader = new BufferedReader(userData);
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv", true));

            String firstName = "", lastName = "", password = "", verifyPassword = "--", email = "", gender = "", phoneNumber = "";
            int birthYear = 0, birthMonth = 0, birthDay = 0;


            //this section is for collecting all of the info needed to register a new user
            System.out.println("please enter your first name");
            firstName = input.nextLine();
            System.out.println("please enter your last name");
            lastName = input.nextLine();
            while(!password.equals(verifyPassword)) {//this is in a while loop until the password and verify password are the same. we want it this way so the user cant misenter their password
                System.out.println("please enter your password");
                password = input.nextLine();
                System.out.println("please verify your password");
                verifyPassword = input.nextLine();
                if (!password.equals(verifyPassword)) {
                    System.out.println("error passwords do not match");
                }
            }
            System.out.println("please enter your phone number");
            phoneNumber = input.nextLine();
            System.out.println("please enter your email");
            email  = input.nextLine();
            System.out.println("please enter your gender");
            gender = input.nextLine();
            System.out.println("please enter your birth year");
            birthYear = input.nextInt();
            System.out.println("please enter your birth month");
            birthMonth = input.nextInt();
            System.out.println("please enter your birth day");
            birthDay = input.nextInt();


            //this is for getting the csv file readable
            String output[] = (firstName + "," + lastName + "," + password + "," + phoneNumber + "," + email
                    + "," + gender + "," + Integer.toString(birthYear) + "," +  Integer.toString(birthMonth) + "," + Integer.toString(birthDay)).split(",");
            //String output[] = "kyle,carr,password123,2222222222,email,male,1998,02,05".split(","); //this is a test line that needs to be erased later
            for(int i = 0; i < output.length; i++){
                writer.write(output[i] + ',');// iterates the file and adds the comma so the csv knows what the next file is
            }
            writer.write("\r\n");
            writer.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
