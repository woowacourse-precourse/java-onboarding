package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int share = 0;      // 몫
        int reminder = 0;   // 나머지

        int[] pocket = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 9개

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < pocket.length; i++) {
            share = money / pocket[i];          // 몫 1
            if(share > 0) {                     // 몫이 0보다 크면 계속 진행
                reminder = money % pocket[i];       // 나머지 237
                answer.add(share);
                money = reminder;
            } else {
                answer.add(0);
            }
        }
        return answer;
    }
}
