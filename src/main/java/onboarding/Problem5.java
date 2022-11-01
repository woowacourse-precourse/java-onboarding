package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] moneyUnit = {50000,10000,5000,1000,500,100,50,10,1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(0,0,0,0,0,0,0,0,0);
        for (int i = 0; i < 9; i++)
        {
            answer.set(i, money / moneyUnit[i]);
            money %= moneyUnit[i];
        }
        return answer;
    }
}
