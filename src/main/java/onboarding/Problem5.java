package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    //화폐와 동전 종류
    private static int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        //큰 단위부터 나눈 몫을 차례로 리스트에 저장
        for (int i = 0; i < moneyTypes.length; i++) {
            answer.add(money / moneyTypes[i]);
            money %= moneyTypes[i];
        }
        return answer;
    }
}
