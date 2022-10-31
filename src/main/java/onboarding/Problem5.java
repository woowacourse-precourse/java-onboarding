package onboarding;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if(!err_check(money)) return answer;
        
        int[] moneyvalue = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};       
        for(int i=0;i<9;i++){
            answer.add(money / moneyvalue[i]);
            money %= moneyvalue[i];
        }
        return answer;
    }

    private static boolean err_check(int money){
        //first constraint
        if(money < 1 || money > 1000000) return false;
        else return true;
    }
}