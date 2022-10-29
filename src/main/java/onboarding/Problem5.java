package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = getMoney(money);
        return answer;
    }

    //금액 리스트 반환 함수
    public static List<Integer> getMoney(int money) {
        List<Integer> answer = new ArrayList<>();
        while (money > 0) {
            money = divideMoney(money, answer);
        }
        return answer;
    }

    //큰 단위의 돈 순서로 금액을 변환하는 함수
    public static int divideMoney(int money, List<Integer> answer) {
        int count;
        if (money >= 50000) {
            count = money / 50000;
            answer.add(count);
            money -= 50000 * count;
            return money;
        }
        if (money >= 10000) {
            count = money / 10000;
            answer.add(count);
            money -= 10000 * count;
            return money;
        }
        if (money >= 5000) {
            answer.add(1);
            money -= 5000;
            return money;
        }
        if (money >= 1000) {
            count = money / 1000;
            answer.add(count);
            money -= 1000 * count;
            return money;
        }
        if (money >= 500) {
            answer.add(1);
            money -= 500;
            return money;
        }
        if (money >= 100) {
            count = money / 100;
            answer.add(count);
            money -= 100 * count;
            return money;
        }
        if (money >= 50) {
            answer.add(1);
            money -= 50;
            return money;
        }
        if (money >= 10) {
            count = money / 10;
            answer.add(count);
            money -= 10 * count;
            return money;
        }

        answer.add(money);
        money -= money;
        return money;

    }
}
