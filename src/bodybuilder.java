import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class bodybuilder implements user {

    String bulkOrCut;
    String doesCompete;
    String Natty;
    float stageWeight;
    float CurrWeight;

    public String firstName ="NA", lastName = "NA";
    public String  phoneNumber = "000-000-0000"; //most convenient data type IMO if you're wondering
    public String email = "example@gmail.com";
    public String gender = "Male";
    public int birthdayYear = 0000, birthdayMonth =00, birthdayDay= 00;


    public void setBulkOrCut(String bulkOrCut) {
        this.bulkOrCut = bulkOrCut;
    }

    public float getCurrWeight() {
        return CurrWeight;
    }

    public float getStageWeight() {
        return stageWeight;
    }

    public String getBulkOrCut() {
        return bulkOrCut;
    }

    public String getDoesCompete() {
        return doesCompete;
    }

    public String getNatty() {
        return Natty;
    }

    public void setCurrWeight(float currWeight) {
        CurrWeight = currWeight;
    }

    public void setDoesCompete(String doesCompete) {
        this.doesCompete = doesCompete;
    }

    public void setNatty(String natty) {
        Natty = natty;
    }

    public void setStageWeight(float stageWeight) {
        this.stageWeight = stageWeight;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthdayYear(){
        return birthdayYear;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public int getBirthdayMonth(){
        return birthdayMonth;
    }

    public void setBirthdayMonth(int birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public int getBirthdayDay(){
        return birthdayDay;
    }

    public void setBirthdayDay(int birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public void userInfo(String userFirstName, String userLastName, String userPhoneNumber, String userEmail,
                         String userGender, int userBirthdayYear, int userBirthdayMonth, int userBirthdayDay){
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.phoneNumber = userPhoneNumber;
        this.email = userEmail;
        this.gender = userGender;
        this.birthdayYear = userBirthdayYear;
        this.birthdayMonth = userBirthdayMonth;
        this.birthdayDay = userBirthdayDay;
    }

    public void workoutRoutine(){
        System.out.println("I am ready to compete? " + doesCompete);
        System.out.println("Am I using Anabolics? " + Natty);
        System.out.println("I am current in a " + bulkOrCut);
        System.out.println("I am currently " + CurrWeight);
        System.out.println("I want to walk on stage at" + stageWeight);
    }

    bodybuilder(){
        bulkOrCut = "";
        doesCompete = "";
        stageWeight = 0;
        CurrWeight = 0;
        Natty = "";
    }

    bodybuilder(String bulkOrCut, String doesCompete, float stageWeight, float CurrWeight, String Natty){
        this.bulkOrCut = bulkOrCut;
        this.Natty = Natty;
        this.stageWeight = stageWeight;
        this.doesCompete = doesCompete;
        this.CurrWeight = CurrWeight;

    }
}
