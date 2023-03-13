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


public class EmailCheck {
    //vars
    String emailAddress;
    String [] extensions;
    String validCheck;
    StringBuffer reversedAddressBuffer = new StringBuffer();
    StringBuffer reversedArrayBuffer = new StringBuffer();

    int atCount;
    String reversedAddress;
    String reversedArray;

    //constructor
    public EmailCheck(){
        atCount=0;
        validCheck="";
    }
    //set & compute
    public void checkEmail(String emailAddress, String [] extensions){
        //set
        this.emailAddress=emailAddress;
        this.extensions=extensions;
        
        //iterate through string, count number of @ symbols
        for(int i=0;i<emailAddress.length();i++){
            if(emailAddress.charAt(i)=='@'){
                atCount++;
            }
        }

        //if there is one @ symbol in the address - email is valid, otherwise either too many or not enough @ symbols
        if(atCount==1){
            validCheck="Correct number of @ symbols";
        }
        else if(atCount>1){
            validCheck="INVALID: Too many @ symbols";
        }
        else{
            validCheck="INVALID: Email address contains no @ symbol";
        }

        //reverse email address string
        for(int i=emailAddress.length()-1;i>=0;i--){
            reversedAddressBuffer.append(emailAddress.charAt(i));
        }
        reversedAddress=reversedAddressBuffer.toString();

        //reverse extensions array
        for(int i=extensions.length-1;i>=0;i--){
            for(int j=extensions[i].length()-1;j>=0;j--){
                reversedArrayBuffer.append(extensions[i].charAt(j));
            }
        }
        reversedArray=reversedArrayBuffer.toString();

        //check if the first 3 characters in the reversed address correspond to one of the domain names in the reversed array
        if(reversedArray.contains(reversedAddress.substring(0,2))){
            validCheck=validCheck+"\nDomain extension is among those listed in the array";
        }
        else{
            validCheck=validCheck+"\nINVALID: Domain extension was not found in the array provided";
        }

        //check if there is a dot behind the domain extension in the reversed address
        if(reversedAddress.charAt(3)=='.'){
            validCheck=validCheck+"\nDot is in the correct place";
        }
        else{
            validCheck=validCheck+"\nINVALID: No dot before the 3-character domain extension";
        }

        //finally, check if one of the parameters in String validCheck contains INVALID and return a final verdict
        if(validCheck.contains("INVALID")){
            validCheck=validCheck+"\n\nThe email address is invalid. Try again!";
        }
        else{
            validCheck=validCheck+"\n\nThe email address is valid!";
        }
        
    }
    //get
    public String getValidCheck(){
        return validCheck;
    }
}