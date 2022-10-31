package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));

        answer.set(0, (money / 50000)); money %= 50000;
        answer.set(1, (money / 10000)); money %= 10000;
        answer.set(2, (money / 5000));  money %= 5000;
        answer.set(3, (money / 1000));  money %= 1000;
        answer.set(4, (money / 500));   money %= 500;
        answer.set(5, (money / 100));   money %= 100;
        answer.set(6, (money / 50));    money %= 50;
        answer.set(7, (money / 10));    money %= 10;
        answer.set(8, (money));

        return answer;
    }
}
