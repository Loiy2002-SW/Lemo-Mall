package com.loiy.lemomall.data;


import java.util.regex.Pattern;

public class CheckInputs {

    //declaring an instance of CheckInputs class
    public static CheckInputs instance = null;

    //set the constructor to private so it can't be called directly
    private CheckInputs(){}

    //check if a field is empty
    public boolean checkEmpty(String string) {
        return string.isEmpty();
    }

    //check the format of the email using regular expression such that: (example@gmail.com)
    public boolean checkEmailFormat(String email) {

        String regEx = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern emailPattern = Pattern.compile(regEx);

        if(emailPattern.matcher(email).matches())
            return true;
        else
            return false;
    }

    //check the length of the password (should be 8)
    public boolean checkPassLength(String pass) {
        return pass.length() == 8;
    }

    //check if the password and the re-entered one is matched
    public boolean checkPassMatchesReEnteredPass(String pass, String reEnteredPass){

        return pass.equals(reEnteredPass);
    }

    //check the length of the phone number (should be 10)
    public boolean checkPhoneLength(String phone) {
        return phone.length() == 10;
    }

    //check the format of the phone number (should start with 77 or 78 or 79)
    public boolean checkPhoneFormat(String phone){

        return phone.charAt(0) == '0' && (phone.charAt(1) == '7' || phone.charAt(1) == '8' || phone.charAt(1) == '9')
                && (phone.charAt(2) == '7' || phone.charAt(2) == '8' || phone.charAt(2) == '9');

    }


    //applying the singleton pattern to reduce the used space (by reducing the number of created object to one object only)
    public static synchronized CheckInputs getInstance() {
        if (instance == null) {
            instance = new CheckInputs();
        }
        return instance;
    }

    public boolean checkPassFormat(String password) {
        byte NumOfLetters = 0, NumOfNumbers = 0;

        for (int i = 0; i < password.length(); i++) {

            if(Character.isDigit(password.charAt(i)))
                NumOfNumbers++;
            else if(Character.isLetter(password.charAt(i)))
                NumOfLetters++;



        }

        return NumOfLetters > 0 && NumOfNumbers > 0;
    }

    public boolean checkDOBFormat(String dob) {

        int numberOfDashes = 0;

        for (int i = 0; i < dob.length(); i++) {
            if(dob.charAt(i) == '-')
                numberOfDashes++;

        }
        return numberOfDashes == 2;
    }
}
