package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));

        for(int i=0; i<8; i++)
        {
            int value = answer.get(i);
            answer.set(i, money / value);
            money = money % value;
        }
        answer.set(8, money); // 마지막을 남은 돈으로

        return answer;
    }
}