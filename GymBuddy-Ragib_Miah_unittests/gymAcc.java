package gymtest;


public class Gym {
    //Creating Gym class to store info
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNo;
    private String email;
    private String location;

    public Gym(String firstName, String lastName, int age, String phoneNo, String email, String location) {
        //Constructor to create objects
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNo = phoneNo;
        this.email = email;
        this.location = location;
    }

    // get and set function for all the fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}