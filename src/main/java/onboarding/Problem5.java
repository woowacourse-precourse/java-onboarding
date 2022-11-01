package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            answer.add(0);
        }
        // While문을 돌면서 지정 화폐가치보다 크다면 무조건 해당 if문을 통해 money를 -하고, 해당 배열값에 1을 추가
        while (money > 0) {
            if (money >= 50000) {
                money -= 50000;
                answer.set(0,answer.get(0) + 1);
            } else if (money >= 10000) {
                money -= 10000;
                answer.set(1, answer.get(1) + 1);
            } else if (money >= 5000) {
                money -= 5000;
                answer.set(2, answer.get(2) + 1);
            } else if (money >= 1000) {
                money -= 1000;
                answer.set(3, answer.get(3) + 1);
            } else if (money >= 500) {
                money -= 500;
                answer.set(4, answer.get(4) + 1);
            } else if (money >= 100) {
                money -= 100;
                answer.set(5, answer.get(5) + 1);
            } else if (money >= 50) {
                money -= 50;
                answer.set(6, answer.get(6) + 1);
            } else if (money > 10) {
                money -= 10;
                answer.set(7, answer.get(7) + 1);
            } else {
                answer.set(8, money);
                money = 0;
            }
        }
        return answer;
    }
}
