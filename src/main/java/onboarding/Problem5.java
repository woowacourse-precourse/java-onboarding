package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(!checkValidation(money)){
            return null;
        }
        return answer;
    }

    private static boolean checkValidation(int money){
        if(1<=money && money<=1000000){
            return true;
        }
        return false;
    }
}
