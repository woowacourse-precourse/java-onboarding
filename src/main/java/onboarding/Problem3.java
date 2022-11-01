package onboarding;

import ExceptionValidation.P3ExceptionValidation;

import java.util.Scanner;

public class Problem3 {
    public static int solution(int number) {

        if (!(P3ExceptionValidation.p3ExceptionValidation(number))){
            return 0;
        }

        int clabNumber = 0;

        for (int i = 1; i <= number; i++){
            clabNumber += findNumberOfClab(i);
        }

        return clabNumber;
    }

    public static int findNumberOfClab(int number){

        int clabNumber = 0;
        String s = Integer.toString(number);

        for(int i = 0 ; i < s.length() ; i++) {
            String subString = s.substring(i, i+1);

            if (subString.equals("3") || subString.equals("6") || subString.equals("9")){
                clabNumber += 1;
            }
        }

        return clabNumber;
    }

}
