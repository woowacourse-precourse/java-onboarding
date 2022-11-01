package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList(); // 빈리스트
//        System.out.println("answer = " + Arrays.toString(answer));
        answer = new ArrayList<Integer>();

        int[] wallet = {50000,10000,5000,1000,500,100,50,10,1};


        int val = 0;
        int cnt =0;
        for (int data : wallet) {
            val = money / data;
            answer.add(val);
            money = money%data;

        }

        return answer;
    }

}
