package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int result;

        for (int i = 0; i < moneyList.length; i++){
            result = money / moneyList[i];
            answer.add(result);

            money %= moneyList[i];  // 나머지
        }

        return answer;
    }

}
