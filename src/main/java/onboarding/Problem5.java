package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int cnt = 0;
        while (money >= 50000) {
            cnt++;
            money -= 50000;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 10000) {
            cnt++;
            money -= 10000;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 5000) {
            cnt++;
            money -= 5000;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 1000) {
            cnt++;
            money -= 1000;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 500) {
            cnt++;
            money -= 500;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 100) {
            cnt++;
            money -= 100;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 50) {
            cnt++;
            money -= 50;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 10) {
            cnt++;
            money -= 10;
        }
        answer.add(cnt);

        cnt =0;
        while (money >= 1) {
            cnt++;
            money -= 1;
        }
        answer.add(cnt);

        return answer;
    }
}
