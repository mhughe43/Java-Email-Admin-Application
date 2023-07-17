import java.util.Locale;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private Integer defaultPasswordLength = 8;
    private String department;

    private String email;
    private Integer mailboxCapacity = 500;
    private String alternateEmail;
    private String companyName = "abcCompany";

    //constructor to receive first name and last name

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("email created: " + this.firstName + " " + this.lastName);

        //Call a method asking for a department - return department

        this.department = setDepartment();
        //System.out.println("Department you selected: " + this.department);

        //Call a method that generated a random password
        this.password = randomPassword(defaultPasswordLength);
        //System.out.println("Your temporary password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ department+"@"+companyName+".com";
        //System.out.println(email);
    }

    //ask for department
    private String setDepartment(){
        System.out.print("Hello " + firstName + "! Welcome to the team!\n Please enter your department code\n1 for Sales\n2 for Development\n3 for Accounting \n0 for none\n Enter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){return "Sales";}
        else if (depChoice == 2) { return "Development";}
        else if (depChoice == 3) { return "Accounting";}
        else {return "";}
    }

    //generate a random password

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        char[] password = new char[length];
        for (int i =0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox cap
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //change the password
    public void changePassword(String password){
        this.password = password;

    }

    //Getters
    public Integer getMailboxCapacity(){ return mailboxCapacity; }
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "-----Your Employee information is below----- \n" +
                "Emplopyee name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }


}
