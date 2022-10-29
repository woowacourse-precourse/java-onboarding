package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> withdraw(int money){
        int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i<bills.length; i++){
            result.add(0);
        }

        int i = 0;
        while(money !=0){
            result.set(i, money/bills[i]);
            money = money%bills[i];
            i++;
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withdraw(money);
        return answer;
    }
}
