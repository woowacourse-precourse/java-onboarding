package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        // 몫은 더하고 나머지로 다음 단위 계산
        answer.add(money / 50000);
        int temp = money % 50000;
        answer.add(temp / 10000);
        temp = temp % 10000;
        answer.add(temp / 5000);
        temp = temp % 5000;
        answer.add(temp / 1000);
        temp = temp % 1000;
        answer.add(temp / 500);
        temp = temp % 500;
        answer.add(temp / 100);
        temp = temp % 100;
        answer.add(temp / 50);
        temp = temp % 50;
        answer.add(temp / 10);
        answer.add(temp % 10);

        return answer;
    }
}
