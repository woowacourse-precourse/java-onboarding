package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(vaildateCheck(money)){
            answer = findMoneyCnt(money);
        }
        return answer;
    }
    private static boolean vaildateCheck(int money){
        if(money < 1 || money > 1000000){
            return false;
        }
        else {
            return true;
        }
    }
    private static List<Integer> findMoneyCnt(int money){
        List<Integer> cntMoney = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        List<Integer> answer = new ArrayList<>();
        for(int cmp : cntMoney){
            answer.add(money/cmp);
            money %= cmp;
        }
        return answer;
    }
}
