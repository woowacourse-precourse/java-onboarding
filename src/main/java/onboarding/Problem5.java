package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        if(money >= 50000) {
            int element = money / 50000;
            answer.add(element);
            money = money % 50000;
        }

        if(answer.size() < 1) {
            answer.add(0);
        }

        if(money >= 10000) {
            int element = money / 10000;
            answer.add(element);
            money = money % 10000;
        }

        if(answer.size() < 2) {
            answer.add(0);
        }

        if(money >= 5000) {
            int element = money / 5000;
            answer.add(element);
            money = money % 5000;
        }

        if(answer.size() < 3) {
            answer.add(0);
        }

        if(money >= 1000) {
            int element = money / 1000;
            answer.add(element);
            money = money % 1000;
        }

        if(answer.size() < 4) {
            answer.add(0);
        }

        if(money >= 500) {
            int element = money / 500;
            answer.add(element);
            money = money % 500;
        }

        if(answer.size() < 5) {
            answer.add(0);
        }

        if(money >= 100) {
            int element = money / 100;
            answer.add(element);
            money = money % 100;
        }

        if(answer.size() < 6) {
            answer.add(0);
        }

        if(money >= 50) {
            int element = money / 50;
            answer.add(element);
            money = money % 50;
        }

        if(answer.size() < 7) {
            answer.add(0);
        }

        if(money >= 10) {
            int element = money / 10;
            answer.add(element);
            money = money % 10;
        }

        if(answer.size() < 8) {
            answer.add(0);
        }

        if(money >= 1) {
            answer.add(money);
        }

        if(answer.size() < 9) {
            answer.add(0);
        }

        return answer;
    }
}
