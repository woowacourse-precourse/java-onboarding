package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int tmpMoney = money;

        answer.add(money / 50000);
        tmpMoney -= answer.get(0) * 50000;
        answer.add(tmpMoney / 10000);
        tmpMoney -= answer.get(1) * 10000;
        answer.add(tmpMoney / 5000);
        tmpMoney -= answer.get(2) * 5000;
        answer.add(tmpMoney / 1000);
        tmpMoney -= answer.get(3) * 1000;
        answer.add(tmpMoney / 500);
        tmpMoney -= answer.get(4) * 500;
        answer.add(tmpMoney / 100);
        tmpMoney -= answer.get(5) * 100;
        answer.add(tmpMoney / 50);
        tmpMoney -= answer.get(6) * 50;
        answer.add(tmpMoney / 10);
        tmpMoney -= answer.get(7) * 10;
        answer.add(tmpMoney % 10);

        return answer;
    }
}
