package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(checkException(money)){
            throw new IllegalArgumentException();
        }
        List<Integer> answer = Collections.emptyList();
        return getMoneyList(money);
    }
    public static List<Integer> getMoneyList(int money){
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        int[] moenyArray = new int[]{50000,10000,5000,1000,500,100,50,10,1};
        int i=0;
        while(true){
            if(money ==0){
                break;
            }
            answer.set(i,money / moenyArray[i]);
            money %= moenyArray[i];
            i++;
        }
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
