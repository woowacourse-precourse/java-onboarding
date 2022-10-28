package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        answer = moneyToList(money, answer);
        return answer;
    }

    /**
     * money를 가장 큰 지폐 단위들로 바꾼 list 반환
     * @param {int} money
     * @param {List<Integer>} answer
     * @return {List<Integer>} answer
     */
    public static List<Integer> moneyToList(int money, List<Integer> answer) {
        int divide = 0;

        for (int i = 0; i < unit.length; i++) {
            divide = money / unit[i];
            answer.add(i, divide);
            money -= unit[i]*divide;
        }
        return answer;
    }

}
