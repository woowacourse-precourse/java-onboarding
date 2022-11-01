package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> changeMoney(int money) {
        List<Integer> change_money = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        List<Integer> res = Arrays.asList(0,0,0,0,0,0,0,0,0);

        for(int change: change_money) {
            if(money < change) { continue; }
            else {
                int count = (int)(money/change);
                money -= count * change;
                res.set(change_money.indexOf(change),count);
            }
        }
        return res;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = changeMoney(money);
        return answer;
    }
}
