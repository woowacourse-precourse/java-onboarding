package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(checkException(money)){
            throw new IllegalArgumentException();
        }
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    public static boolean checkException(int money){
        if(chenckRange(money) || !checkNumber(money)){
            return true;
        }
        return false;
    }
    public static boolean chenckRange(int money){
        return money < 1 || money >1000000;
    }
    public static  boolean checkNumber(int money){
        return String.valueOf(money).chars().allMatch(Character::isDigit);
        
    }
}
