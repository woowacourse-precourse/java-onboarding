package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static int MAX = 1000000;
    private final static int MIN = 0;
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        checkValidateRange(money);
        answer = exchangeMoney(money);

        return answer;
    }

    private static List<Integer> exchangeMoney(int money) {
        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int len = moneyArr.length;
        int count;
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < len; i++) {
            if(money >= moneyArr[i]) {
                count = money / moneyArr[i];
                money -= count * moneyArr[i];
                answer.add(count);
            }else {
                answer.add(0);
            }
        }
        return answer;
    }

    private static void checkValidateRange(int money) {
        if(money >= MAX || money <= MIN) {
            throw new RuntimeException("잘못된 숫자를 입력했습니다.");
        }
    }



}
