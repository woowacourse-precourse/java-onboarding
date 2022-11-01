package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 목록
 * 1. money를 큰 금액을 우선으로 변환하는 함수
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int unit : units) {
            money = conversionMoney(money, answer, unit);
        }

        return answer;
    }

    public static int conversionMoney(int money, List<Integer> answer, int unit) {
        if (money / unit >= 1) {
            answer.add(money / unit);
            return money % unit;
        }
        answer.add(0);
        return money;
    }
}
