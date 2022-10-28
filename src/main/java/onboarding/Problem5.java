package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        /*
        money는 1이상 1,000,000 이하인 자연수 이다.
        가장 적은 수의 화폐를 반환하도록 오 만원권, 만 원권, 오천 원권, 천 원권,
        오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전의 갯수를 반환하여라
         */
        List<Integer> answer = new ArrayList<>();

        int[] moneyValue = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < moneyValue.length; i++) {
            answer.add(money / moneyValue[i]);
            money%=moneyValue[i];
        }
        return answer;
    }
}
