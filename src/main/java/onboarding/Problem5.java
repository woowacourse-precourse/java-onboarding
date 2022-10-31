package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int amountOfMoney[] = {
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    };

    static List<Integer> getCountList(int money){
        List<Integer> res = new ArrayList<Integer>(9);
        for(int i = 0; i < 9; i++)
            res.add(0);

        int amountIdx = 0;
        while(money > 0){
            int cnt = money / amountOfMoney[amountIdx];
            res.set(amountIdx, cnt);
            money -= amountOfMoney[amountIdx]*cnt;
            System.out.println("money = " + money);
            amountIdx++;
        }

        return res;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getCountList(money);
        return answer;
    }
}
