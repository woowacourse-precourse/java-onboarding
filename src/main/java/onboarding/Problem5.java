package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        int currency = Constants.START_MONEY;
        int amount = 0;
        boolean isHalf = true;

        while(currency >= 10) {
            amount = money / currency;
            answer.add(amount);

            if (isHalf) {
                currency /= 5;
            }
            else {
                currency /= 2;
            }

            money %= currency;
            isHalf = !isHalf;
        }

        answer.add(money);

        return answer;
    }
}
