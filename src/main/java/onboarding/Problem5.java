package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 반복문 안에서 화폐 단위에 대해 나누기 5와 2를 반복하는 방식 보다
        // 하드 코딩하는 편이 의도가 명확하게 드러난다고 생각했습니다.
        answer.add(money / 50000);
        money %= 50000;

        answer.add(money / 10000);
        money %= 10000;

        answer.add(money / 5000);
        money %= 5000;

        answer.add(money / 1000);
        money %= 1000;

        answer.add(money / 500);
        money %= 500;

        answer.add(money / 100);
        money %= 100;

        answer.add(money / 50);
        money %= 50;

        answer.add(money / 10);
        money %= 10;

        answer.add(money / 1);


        return answer;
    }
}
