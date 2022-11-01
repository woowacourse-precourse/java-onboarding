package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        int n = money;
        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i  = 0; i < coin.length; i++) {
            if(n>=coin[i]) {
                answer.add(n/coin[i]);
                n = n % coin[i];
            }
            else answer.add(0);
        }

        return answer;


    }

}