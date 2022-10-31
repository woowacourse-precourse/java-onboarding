package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    private static final int START_MONEY = 50_000;

    public static void main(String[] args) {
        solution(50_237);
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        int currency = START_MONEY;
        int amount = 0;
        boolean isHalf = true;

        while(currency >= 10) {
            amount = money / currency;
            answer.add(amount);
            money %= currency;

            if (isHalf) {
                currency /= 5;
            }
            else {
                currency /= 2;
            }
            isHalf = !isHalf;
        }

        answer.add(money);

        return answer;
    }
}