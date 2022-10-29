package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int coin[] = {1, 10, 50, 100, 500, 1000, 5000, 10000, 50000};
        int idx = coin.length -1;
        while (money > 0){
            answer.add(money / coin[idx]);
            money %= coin[idx];
            idx -= 1;
        }
        return answer;
    }

    public static boolean NumberCheck(int money){
        if(1 <= money & money <= 1000000){
            return true;
        }else{
            return false;
        }

    }

}

