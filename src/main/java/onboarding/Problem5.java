package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<9; i++) {
            answer.add(0);
        }

        while (money > 0) {
            if (money >= 50000) {
                answer.set(0, answer.get(0) + 1);
                money -= 50000;
            } else if (money >= 10000) {
                answer.set(1, answer.get(1) + 1);
                money -= 10000;
            } else if (money >= 5000) {
                answer.set(2, answer.get(2) + 1);
                money -= 5000;

            } else if (money >= 1000) {
                answer.set(3, answer.get(3) + 1);
                money -= 1000;

            } else if (money >= 500) {
                answer.set(4, answer.get(4) + 1);
                money -= 500;

            } else if (money >= 100) {
                answer.set(5, answer.get(5) + 1);
                money -= 100;

            } else if (money >= 50) {
                answer.set(6, answer.get(6) + 1);
                money -= 50;

            } else if (money >= 10) {
                answer.set(7, answer.get(7) + 1);
                money -= 10;

            } else {
                answer.set(8, answer.get(8) + 1);
                money -= 1;
            }
        }
        return answer;
    }
}
