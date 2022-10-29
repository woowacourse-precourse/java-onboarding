package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static void isCheck(int money) {
        if(money < 1 || money > 1000000) {
            System.out.println("입력이 잘못되었습니다.");
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        isCheck(money);

        return answer;
    }
}
