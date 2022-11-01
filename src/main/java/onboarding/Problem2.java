package onboarding;

import ExceptionValidation.P2ExceptionValidation;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {

        if(!(P2ExceptionValidation.p2ExceptionValidation(cryptogram))){
            return "";
        }

}