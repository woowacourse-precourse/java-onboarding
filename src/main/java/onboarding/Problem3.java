package onboarding;

import ExceptionValidation.P3ExceptionValidation;

import java.util.Scanner;

public class Problem3 {
    public static int solution(int number) {

        if (!(P3ExceptionValidation.p3ExceptionValidation(number))){
            return 0;
        }
    }
}
