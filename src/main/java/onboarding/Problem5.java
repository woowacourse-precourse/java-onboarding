package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 각 단위로 나누어서 몇 개로 변환되는지 구해준다.
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] coin = {50000 , 10000 , 5000 , 1000 , 500 ,100 , 50, 10 ,1};

        for(int i = 0 ; i < coin.length ; i++){
            answer.add(money/coin[i]);
            money %= coin[i];
        }

        return answer;
    }
}
