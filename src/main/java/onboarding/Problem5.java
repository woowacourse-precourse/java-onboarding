package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        answer = moneyConversion(money);

        return answer;
    }

    public static List<Integer> moneyConversion(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < moneyList.length; i++) {
            int moneyNum = (money / moneyList[i]);

            answer.add(moneyNum);

            money -= moneyList[i] * moneyNum;
        }

        return answer;
    }
}
