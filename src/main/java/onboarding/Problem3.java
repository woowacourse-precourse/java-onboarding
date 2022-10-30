package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    private static final int NUMBER_OF_DIGIT_DIVISION = 10;
    private static final int MAX_INPUT_NUMBER = 10000 ;

    public static int solution(int number) {
        int answer = number;
        return answer;
    }


    private static int divideNumber(int number){
        int clap = 0;
        int dividedNumber = Integer.MIN_VALUE;
        while(number>0){
            dividedNumber = number % NUMBER_OF_DIGIT_DIVISION;
            if(confirmNumber(dividedNumber))
                clap++;
            number = number/NUMBER_OF_DIGIT_DIVISION;
        }
        return clap;
    }

    private static boolean confirmNumber(int dividedNumber){
        if(dividedNumber%3==0) return true;
        return false;
    }

}
