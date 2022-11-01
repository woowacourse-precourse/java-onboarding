package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Problem5 pro = new Problem5();

        // 계산할 화폐 종류를 배열로 선언
        int[] moneyType = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

        // money 가 0보다 크면 계산을 실행한다.
        if (money > 0) {
            answer = pro.ATM(money, moneyType);
        }

        return answer;
    }

    public List<Integer> ATM(int money, int[] moneyType) {
        // 값을 담을 Array 배열 선언
        List<Integer> result = new ArrayList<>();

        // 매개변수로 받은 money 를 moneyType 의 순서대로 계산하여 배열에 담는다.
        for (int i = 0; i < moneyType.length; i++) {
            result.add(money / moneyType[i]);
            money %= moneyType[i]; // 화폐 단위로 나눈 값의 나머지
        }
        return result;
    }
}
