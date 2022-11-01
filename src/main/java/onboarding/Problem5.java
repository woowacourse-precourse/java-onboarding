package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {


        List<Integer> answer = new ArrayList<>();

        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i =0; i < 9; i++)
        {
            int coinCnt = money / coin[i];
            answer.add(i,coinCnt);
            money %= coin[i];
        }

        return answer;
    }
}
