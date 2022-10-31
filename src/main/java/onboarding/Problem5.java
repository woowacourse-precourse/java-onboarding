package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  구현할 기능 목록
 *      1. 화폐단위에 맞게 개수 카운트하는 기능
 *          1.1. 가장 높은 화페단위부터 나누어 계산
 *
 *
 */
public class Problem5 {

    static final List<Integer> MONEY_UNIT = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);   // 화페 단위

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 가장 높은 화폐단위부터 나누어 계산
        for (Integer money_unit : MONEY_UNIT) {
            answer.add(money / money_unit);
            money %= money_unit;
        }

        return answer;
    }
}
