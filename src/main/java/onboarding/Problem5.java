package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();

        if (50000 <= money) {
            answer.add(money / 50000);
            money = money % 50000;
        } else {
            answer.add(0);
        }

        if (10000 <= money) {
            answer.add(money / 10000);
            money = money % 10000;
        } else {
            answer.add(0);
        }

        if (5000 <= money) {
            answer.add(money / 5000);
            money = money % 5000;
        } else {
            answer.add(0);
        }

        if (1000 <= money) {
            answer.add(money / 1000);
            money = money % 1000;
        } else {
            answer.add(0);
        }

        if (500 <= money) {
            answer.add(money / 500);
            money = money % 500;
        } else {
            answer.add(0);
        }

        if (100 <= money) {
            answer.add(money / 100);
            money = money % 100;
        } else {
            answer.add(0);
        }

        if (50 <= money) {
            answer.add(money / 50);
            money = money % 50;
        } else {
            answer.add(0);
        }

        if (10 <= money) {
            answer.add(money / 10);
            money = money % 10;
        } else {
            answer.add(0);
        }

        if (1 <= money) {
            answer.add(money / 1);
            money = money % 1;
        } else {
            answer.add(0);
        }

        return answer;
    }
}
