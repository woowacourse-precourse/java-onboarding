package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] moneycount = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int i = 0;
        int count = 0;
        while(money >= 0 && i < moneycount.length){
            count = 0;
            while(money-moneycount[i] >= 0){
                if(money - moneycount[i] >= 0) {
                    money -= moneycount[i];
                    count++;
                }
            }
            answer.add(count);
            i++;
        }
        return answer;
    }
}
