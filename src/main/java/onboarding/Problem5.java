package onboarding;

import ExceptionValidation.P5ExceptionValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        if(!(P5ExceptionValidation.p5ExceptionValidation(money))){
            return Collections.emptyList();
        }

    }

}
