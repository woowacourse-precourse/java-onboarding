package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> withdraw(int money) {
        List<Integer> withdrawList = new ArrayList<>();
        withdrawList.add(0, money / 50000); // 50,000원
        withdrawList.add(1, money % 50000 / 10000); // 10,000원
        withdrawList.add(2, money % 10000 / 5000); // 5,000원
        withdrawList.add(3, money % 5000 / 1000); // 1,000원
        withdrawList.add(4, money % 1000 / 500); // 500원
        withdrawList.add(5, money % 500 / 100); // 100월
        withdrawList.add(6, money % 100 / 50); // 50원
        withdrawList.add(7, money % 50 / 10); // 10원
        withdrawList.add(8, money % 10); // 1원

        return withdrawList;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = withdraw(money);

        return answer;
    }
}
