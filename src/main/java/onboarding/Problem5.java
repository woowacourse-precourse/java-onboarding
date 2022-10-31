package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int coins[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
        int coinsCount[] = {0};

        int a = 0;
        int count =0;
        while(true){
            if(money == 0) break;

            if(money < coins[a] * count) {
                coinsCount[a] = count - 1;
                money -= coins[a] * (count - 1);

                a++;
                count = 0;
            }
        }

        for(int i = 0; i < 10; i++) {
            answer.get(coinsCount[i]);
        }

        return answer;
    }
}
