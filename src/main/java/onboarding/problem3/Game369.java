package onboarding.problem3;

import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Clap{

    public static boolean checkNumberIs369(int number){
        return (number == 3 || number == 6 || number == 9);
    }

    public static int getClapTimeOfNumber(int number){
        int clapTimeOfNumber = 0;

        String digitsOfNumber = String.valueOf(number);


        for(char digit : digitsOfNumber.toCharArray()){
            if(checkNumberIs369(Character.digit(digit,Character.DECIMAL_DIGIT_NUMBER))){
                clapTimeOfNumber += 1;
            }
        }
        return clapTimeOfNumber;
    }

    @Test
    @DisplayName("Config")
    void test(){
        System.out.println(getClapTimeOfNumber(933256155));
        System.out.println(getClapTimeOfNumber(3613622));
        System.out.println(getClapTimeOfNumber(6131355));
    }
}
