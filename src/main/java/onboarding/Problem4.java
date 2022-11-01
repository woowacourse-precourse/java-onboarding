package onboarding;

import ExceptionValidation.P4ExceptionValidation;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {

        if(!(P4ExceptionValidation.p4ExceptionValidation(word))){
            return "";
        }
    }

}
