public interface user {

    void workoutRoutine();
    void userInfo(String userFirstName, String userLastName, String userPhoneNumber, String userEmail,
                  String userGender, int userBirthdayYear, int userBirthdayMonth, int userBirthdayDay);
}


public class runner implements user {

    String doesCompete;
    String inOrOut;
    String distanceOrSprint;
    float distance;
    
    
    public String firstName ="NA", lastName = "NA";
    public String  phoneNumber = "000-000-0000"; //most convenient data type IMO if you're wondering
    public String email = "example@gmail.com";
    public String gender = "Male";
    public int birthdayYear = 0000, birthdayMonth =00, birthdayDay= 00;


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
        System.out.println("Do I prefer to run indoors or outdoors? " + inOrOut);
        System.out.println("Do I run distance or sprints" + distanceOrSprint);
        System.out.println("How far do I run " + distance);
    }

    runner(){
        inOrOut = "";
        doesCompete = "";
        distance = 0;
        distanceOrSprint = "";
    }

    runner(String inOrOut, String doesCompete, String distanceOrSprint, float distance){
        this.doesCompete = doesCompete;
        this.inOrOut = inOrOut;
        this.distanceOrSprint = distanceOrSprint;
        this.distance = distance;

    }
}

public class powerlifter implements user {
    String doesCompete;
    int maxDeadlift;
    int maxSquat;
    int maxBench;
    String Natty;
    String thousandPoundClub;

    public String firstName ="NA", lastName = "NA";
    public String  phoneNumber = "000-000-0000"; //most convenient data type IMO if you're wondering
    public String email = "example@gmail.com";
    public String gender = "Male";
    public int birthdayYear = 0000, birthdayMonth =00, birthdayDay= 00;


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
        System.out.println("My max bench is: " + maxBench);
        System.out.println("My max squat is: " + maxSquat);
        System.out.println("My max deadlift is: " + maxDeadlift);
        System.out.println("Is this user in the 1000 pound club?" + thousandPoundClub);
    }

    powerlifter(){
        thousandPoundClub = "";
        doesCompete = "";
        Natty = "";
        maxDeadlift = 0;
        maxSquat = 0;
        maxBench = 0;
    }

    powerlifter(String thousandPoundClub, String doesCompete, int maxBench, int maxDeadlift, int maxSquat, String Natty){
        this.Natty = Natty;
        this.doesCompete = doesCompete;
        this.thousandPoundClub = thousandPoundClub;
        this.maxBench = maxBench;
        this.maxSquat = maxSquat;
        this.maxDeadlift = maxDeadlift;
    }
}

public class bodybuilder implements user {

    String bulkOrCut;
    String doesCompete;
    String Natty;
    String stageWeight;
    String CurrWeight;

    public String firstName ="NA", lastName = "NA";
    public String  phoneNumber = "000-000-0000"; //most convenient data type IMO if you're wondering
    public String email = "example@gmail.com";
    public String gender = "Male";
    public int birthdayYear = 0000, birthdayMonth =00, birthdayDay= 00;


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
        stageWeight = "";
        CurrWeight = "";
        Natty = "";
    }

    bodybuilder(String bulkOrCut, String doesCompete, String stageWeight, String CurrWeight, String Natty){
        this.bulkOrCut = bulkOrCut;
        this.Natty = Natty;
        this.stageWeight = stageWeight;
        this.doesCompete = doesCompete;
        this.CurrWeight = CurrWeight;

    }
}

