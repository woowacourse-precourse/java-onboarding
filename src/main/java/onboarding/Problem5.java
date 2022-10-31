package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 결과를 저장할 리스트
        List<Integer> answer = new ArrayList<>();
        // 화폐 금액을 담은 배열
        int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // 큰 금액의 화폐 순서대로 바꾼뒤 남는 금액을 저장할 변수
        int leftMoney = money;
        for (int i = 0; i < moneyArray.length; i++) {
            // 남은 금액이 바꾸려는 화폐의 금액이상이라면
            if(leftMoney >= moneyArray[i]) {
                // 남은 금액을 화폐의 금액으로 나눈 몫을 결과 리스트에 저장
                answer.add(leftMoney/moneyArray[i]);
                // 화폐의 금액으로 나눈뒤 나머지를 남은 금액에 저장
                leftMoney = leftMoney % moneyArray[i];
            }
            // 남은 금액이 바꾸려는 화폐의 금액보다 낮다면 0을 결과 리스트에 저장
            else answer.add(0);
        }
        return answer;
    }
}