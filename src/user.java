public class user {

    public String firstName = "", lastName ="";
    //public int age;
    public String phoneNumber; //most convenient data type IMO if you're wondering
    public String email = "";
    public String gender = "";
    public int birthdayYear, birthdayMonth, birthdayDay;

    //default constructor
    protected user(){
        firstName ="NA";
        lastName = "NA";
        phoneNumber = "000-000-0000";
        email = "example@gmail.com";
        gender = "Male";
        birthdayYear = 0000;
        birthdayMonth =00;
        birthdayDay= 00;
    }

    protected user(String userFirstName, String userLastName, String userPhoneNumber, String userEmail,
                   String userGender, int userBirthdayYear, int userBirthdayMonth, int userBirthdayDay){
        firstName = userFirstName;
        lastName = userLastName;
        phoneNumber = userPhoneNumber;
        email = userEmail;
        gender = userGender;
        birthdayYear = userBirthdayYear;
        birthdayMonth = userBirthdayMonth;
        birthdayDay = userBirthdayDay;
    }


/*    May need later
public String location = "";
public String gym = "";
public String discipline = "";
public String availability = "";
public String objectives = "";
public String routine = "";
 */

/*
SET FUNCTIONS FOR ALL THE NOT COMMENTED FIELDS

 */
protected void setFirstName(String firstName){
    if(firstName != null && firstName.length() >= 2) {
        this.firstName = firstName;
    }
    else{
        return;
    }
}

protected void setLastName(String lastName){
    if (lastName != null && lastName.length() >=2){
        this.lastName = lastName;
    }
    else{
        return;
    }

}

protected void setPhoneNumber(String phoneNumber){
    if (phoneNumber.matches("\\d{9}")){
        this.phoneNumber = phoneNumber;
    }
    else if (phoneNumber.matches("\\d{3}[-\\s]\\d{3}[-\\s]\\d{4}"))
    {
        this.phoneNumber = phoneNumber;
    }
    else
    {
        return;
    }
}

protected void setEmail(String email){

    this.email = email;
}

protected void setGender(String gender){
    if (gender == "male" || gender == "female") {
        this.gender = gender;
    }
    else{
        return;
    }
}

protected void setBirthdayYear(int birthdayYear){
    if (birthdayYear >= 1920 || birthdayYear <= 2004 ) {
        this.birthdayYear = birthdayYear;
    }
    else {
        return;
    }
}

protected void setBirthdayMonth(int birthdayMonth){
    if (birthdayMonth > 0 || birthdayMonth <= 12) {
        this.birthdayMonth = birthdayMonth;
    }
    else{
        return;
    }
}

protected void setBirthdayDay(int birthdayDay){
    if (birthdayDay > 0 || birthdayDay <= 31) {
        this.birthdayDay = birthdayDay;
    }
    else {
        return;
    }
}
/*
GET FUNCTIONS FOR ALL THE NOT COMMENTED FIELDS


 */
public String getFirstName(){
    return firstName;
}

public String getLastName(){
    return lastName;
}

public String getPhoneNumber(){
    return phoneNumber;
}
public String getEmail(){
    return email;
}
public String getGender(){
    return gender;
}
public int getBirthdayYear(){
    return birthdayYear;
}
public int getBirthdayMonth(){
    return birthdayMonth;
}
public int getBirthdayDay(){
    return birthdayDay;
}
//METHOD TO DISPLAY THE USER INFORMATION WHICH WILL CALL ALL THE GETS FUNCTION

public void displayUser(user profile){
    profile.getFirstName();
    profile.getLastName();
    profile.getPhoneNumber();
    profile.getEmail();
    profile.getGender();
    profile.getBirthdayYear();
    profile.getBirthdayMonth();
    profile.getBirthdayDay();
}


//METHOD TO DELETE THE USER'S PROFILE (OBJECT)

    public void removeUser(user profile){
    profile = new user();
    profile = null;
    }

    //METHOD CALLED "MODIFY PROFILE" WHICH WILL CALL ALL THE SETS FUNCTIONS

    public void modifyProfile(user profile, String firstName, String lastName, String phoneNumber, String email, String gender,
                              int birthdayYear, int birthdayMonth, int birthdayDay){
    profile.setFirstName(firstName);
    profile.setLastName(lastName);
    profile.setPhoneNumber(phoneNumber);
    profile.setGender(gender);
    profile.setEmail(email);
    profile.setBirthdayYear(birthdayYear);
    profile.setBirthdayMonth(birthdayMonth);
    profile.setBirthdayDay(birthdayDay);

    }
    //this currently sets all of the users info whenever they want to change any detail about their profile. we may want to make it more modular later so
    //we use less processing power on changing data

}

