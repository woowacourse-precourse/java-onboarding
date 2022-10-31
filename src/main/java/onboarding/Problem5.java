package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        int [] cnt = new int [9];

        while(money > 0){
            if(money / 50000 > 0){
                cnt[0] = money / 50000;
                money %= 50000;
            }
            if(money / 10000 > 0){
                cnt[1] = money / 10000;
                money %= 10000;
            }
            if(money / 5000 > 0){
                cnt[2] = money / 5000;
                money %= 5000;
            }
            if(money / 1000 > 0){
                cnt[3] = money / 1000;
                money %= 1000;
            }
            if(money / 500 > 0){
                cnt[4] = money / 500;
                money %= 500;
            }
            if(money / 100 > 0){
                cnt[5] = money / 100;
                money %= 100;
            } if(money / 50 > 0){
                cnt[6] = money / 50;
                money %= 50;
            } if(money / 10 > 0){
                cnt[7] = money / 10;
                money %= 10;
            } if(money > 0){
                cnt[8] = money;
                money = 0;
            }
        }

        for(int i : cnt){
            answer.add((Integer)i);
        }

        return answer;
    }
}
