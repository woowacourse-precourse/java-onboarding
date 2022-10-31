package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(hasException(money)){
            return null;
        }
        return getChangedByAmount(money);
    }

    public static List<Integer> getChangedByAmount(int money){
        int number = 0;
        List<Integer> result = new ArrayList<>();
        int[] amount = {50000,10000,5000,1000,500,100,50,10,1};
        for(int bill : amount){
            number = (money/bill>0)?money/bill:0;
            result.add(number);
            money -= bill*number;
        }  
        return result;
    }

    public static boolean hasException(int money){
        if(money < 1 || money > 1000000)
            return true;
        return false;
    }
}
