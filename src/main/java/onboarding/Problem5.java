package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {

    static List<Integer> answer = new ArrayList<Integer>();

    public static List<Integer> solution(int money) {
        moneyConversion(money);

        return answer;
    }

    public static void moneyConversion(int money) {
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < moneyList.length; i++) {
            int moneyNum = (money / moneyList[i]);

            answer.add(moneyNum);

            money -= moneyList[i] * moneyNum;
        }

    }
}
