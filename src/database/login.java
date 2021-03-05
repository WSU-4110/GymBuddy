package database;
import java.util.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class login { //user enters their login info, and if it matches user data in the database, it returns true for a successful login, or false for a failed login
    public static boolean connect(String name, String password){
        String line = "";
        try{
            FileReader userData = new FileReader("users.csv");
            BufferedReader reader = new BufferedReader(userData);
            //this is for getting the csv file readable


            while((line = reader.readLine()) !=null){
                String[] user = line.split(","); //takes the string from csv document and turns it into an array
                if(name.equals(user[0]) && password.equals(user[2])){
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.print(e);
        }
        return false;
    }

}
