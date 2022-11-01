package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 처음 아이디어
    // (제시된 금액 / 화폐의 단위)와 0 중 더 큰 값을 반환하는 함수 생성
    // -> 위의 값이 0보다 작으면 단위보다도 제시된 금액이 작기 때문에, 그 단위는 0개가 사용됨
    // 높은 단위부터 시작하여 개수가 구해지면 (원래 금액)-(화폐 단위*사용된 단위 개수)로 금액을 재설정하여
    // 단위별로 쓰인 개수를 리스트에 넣고 반환하는 함수 생성
    // 솔루션 함수에서는 이 함수를 이용해 답을 반환

    public static int[] unit_money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static int getMoneyList(int money, int index) {
        return Math.max(money / unit_money[index], 0);
    }

    public static List<Integer> unitMoneyNumber(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < unit_money.length; i++) {
            answer.add(getMoneyList(money, i));
            money -= getMoneyList(money, i) * unit_money[i];
        }
        return answer;
    }

    public static List<Integer> solution(int money) {
        return unitMoneyNumber(money);
    }
}
