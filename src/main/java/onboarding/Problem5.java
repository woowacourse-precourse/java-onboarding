package onboarding;
/***
 * 기능목록
 * 1. 입력값을 변환하는 기능
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getCash(money);
        return answer;
    }

    public static List<Integer> getCash(int money) {
        int change = money;
        int quotient = 0;
        List<Integer> cash = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
        while (change > 0) {
            if (change / 50000 >= 1) {
                quotient = change / 50000;
                cash.set(0, quotient);
                change %= 50000;
            } else if (change / 10000 >= 1) {
                quotient = change / 10000;
                cash.set(1, quotient);
                change %= 10000;
            } else if (change / 5000 >= 1) {
                quotient = change / 5000;
                cash.set(2, quotient);
                change %= 1000;
            } else if (change / 1000 >= 1) {
                quotient = change / 1000;
                cash.set(3, quotient);
                change %= 1000;
            } else if (change / 500 >= 1) {
                quotient = change / 500;
                cash.set(4, quotient);
                change %= 500;
            } else if (change / 100 >= 1) {
                quotient = change / 100;
                cash.set(5, quotient);
                change %= 100;
            } else if (change / 50 >= 1) {
                quotient = change / 50;
                cash.set(6, quotient);
                change %= 50;
            } else if (change / 10 >= 1) {
                quotient = change / 10;
                cash.set(7, quotient);
                change %= 10;
            } else if (change >= 1) {
                quotient = change;
                cash.set(8, quotient);
                change = 0;
            }
        }
        return cash;
    }
}
