package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int leftMoney = money;
        for (int i = 0; i < moneyArray.length; i++) {

            if(leftMoney >= moneyArray[i]) {

                answer.add(leftMoney/moneyArray[i]);

                leftMoney = leftMoney % moneyArray[i];
            }

            else answer.add(0);
        }
        return answer;
    }
}
