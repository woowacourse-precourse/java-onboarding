package onboarding;

import ExceptionValidation.P1ExceptionValidation;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!(P1ExceptionValidation.p1ExceptionValidation(pobi)
        && P1ExceptionValidation.p1ExceptionValidation(crong))){
            return -1;
        }
    }

}