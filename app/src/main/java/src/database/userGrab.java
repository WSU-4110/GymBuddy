package database;

import java.io.BufferedReader;
import java.io.FileReader;

public class userGrab {
    public static String[] grab(String name, String password){
        String line = "";
        try{
            FileReader userData = new FileReader("users.csv");
            BufferedReader reader = new BufferedReader(userData);
            //this is for getting the csv file readable


            while((line = reader.readLine()) !=null){
                String[] user = line.split(","); //takes the string from csv document and turns it into an array
                if(name.equals(user[0]) && password.equals(user[2])){
                    return user;
                }
            }
        }
        catch(Exception e){
            System.out.print(e);
        }
        String [] empty = new String[0];
        return empty;
    }
}
