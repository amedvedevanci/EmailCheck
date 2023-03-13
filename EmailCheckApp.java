/*
 * 
Create an application that takes in 2 pieces of information from a user; a single email address and an array of 3 character domain extensions (eg com, edu, org). 
These should be taken in as parameters into a single method. This application only needs 2 methods; 1 that sets and computes and 1 that returns information.

The method should then do the following to validate the email address:
-Check that there is an @ symbol in the email address
-Check that there is a . before the 3 character extension
-Ensure that the domain extension is one of the 3 character Strings from the array
The method should return a String that states whether or not the email address is valid, and why.

 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class EmailCheckApp {
    public static void main(String args[]){
        //vars
        String emailAddress;
        String [] extensions;
        int extensionsLength;
        String validCheck;

        //objects
        EmailCheck ec = new EmailCheck();
        Scanner sc = new Scanner(System.in);

        //input
        System.out.println("Enter the email address you want to validate");
        emailAddress=sc.next();

        //user determines length of extensions array
        System.out.println("Please indicate how many 3 character domain extensions you would like to enter.");
        extensionsLength=sc.nextInt();
        extensions=new String[extensionsLength];

        //populate extensions array
        for(int extensionsIndex=0;extensionsIndex<extensions.length;extensionsIndex++){
            System.out.println("Enter domain number "+(extensionsIndex+1));
            extensions[extensionsIndex]=sc.next();

            Pattern pattern = Pattern.compile("[^a-zA-Z]");
            Matcher matcher = pattern.matcher(extensions[extensionsIndex]);
            boolean containSpecial=matcher.find();

            //while input does not correspond to 3 characters or contains numbers or special symbols, try input again
            //re-check if it contains numbers or symbols
            while(extensions[extensionsIndex].length()!=3 || containSpecial){
                System.out.println("Please enter a 3-letter domain extension. Omit any dots or numbers");
                extensions[extensionsIndex]=sc.next();
                matcher=pattern.matcher(extensions[extensionsIndex]);
                containSpecial=matcher.find();
            }
        }

        //set & compute
        ec.checkEmail(emailAddress,extensions);
        //get
        validCheck=ec.getValidCheck();
        //output
        System.out.println(validCheck);
    }
}
