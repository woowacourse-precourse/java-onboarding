package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] charges = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        getCharges(money, answer, charges);

        return answer;
    }

    public static void getCharges(int money, List<Integer> answer, int[] charges) {
        for(int i = 0; i < charges.length; i++){

            int cnt = money / charges[i];
            if(cnt == 0) {
                answer.add(0);
            } else {
                answer.add(cnt);
            }
            int remainder = money % charges[i];

            money = remainder;
        }
    }
}
