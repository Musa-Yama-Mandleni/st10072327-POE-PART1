
package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//password imports
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    static Register Reg_User = new Register();
    static List<String> User_Data = new ArrayList<String>(); 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //set username and addes it to the list
        System.out.println("Please enter user name:");
        String user_name = input.nextLine();
        isShortAndUnder(user_name);
        Reg_User.setUser_name(user_name);
        User_Data.add(Reg_User.getUser_name());
        
        //set password and addes it to the list
        System.out.println("Please enter password:");
        String password = input.nextLine();
        isValidPassword(password);
        Reg_User.setUser_name(password);
        User_Data.add(Reg_User.getPassword());
        
        //set first name and addes it to the list
        System.out.println("Please enter first name:");
        String first_name = input.nextLine();
        Reg_User.setFirst_name(first_name);
        User_Data.add(Reg_User.getFirst_name());
        
        //set last name and addes it to the list
        System.out.println("Please enter last name:");
        String last_name = input.nextLine();
        Reg_User.setLast_name(last_name);
        User_Data.add(Reg_User.getLast_name());
        
        //Login
        Login(user_name, password);
         
    }
    public static void Login(String username, String password){
        //String messege = "Welcome <user first name> ,<user last  name> it is great to see you again. ";
        
        for(String item : User_Data){
            if(item == username){
                System.out.println(username);
            }
        }
        for(String item : User_Data){
            if(item == password){
                System.out.println(password);
            }
        }
    }
    //this will check the validation of the username
    public static boolean isShortAndUnder(String username){
        boolean isValid = true;
        if(username.length() > 6 || !username.contains("_")){
            System.out.println("Username must be less than 6 characters and");
            System.out.println("Username must contain a _");
            isValid = false;
        }
        return isValid;
    }
    //this will check the validation of the password
    public static boolean isValidPassword(String password)
    {
            boolean isValid = true;
            if (password.length() > 15 || password.length() < 8)
            {
                    System.out.println("Password must be less than 20 and more than 8 characters in length.");
                    isValid = false;
            }
            String upperCaseChars = "(.*[A-Z].*)";
            if (!password.matches(upperCaseChars ))
            {
                    System.out.println("Password must have atleast one uppercase character");
                    isValid = false;
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (!password.matches(lowerCaseChars ))
            {
                    System.out.println("Password must have atleast one lowercase character");
                    isValid = false;
            }
            String numbers = "(.*[0-9].*)";
            if (!password.matches(numbers ))
            {
                    System.out.println("Password must have atleast one number");
                    isValid = false;
            }
            String specialChars = "(.*[@,#,$,%].*$)";
            if (!password.matches(specialChars ))
            {
                    System.out.println("Password must have atleast one special character among @#$%");
                    isValid = false;
            }
            return isValid; 
    }
}


  

