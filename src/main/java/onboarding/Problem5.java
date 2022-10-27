package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 처음 아이디어
    // 금액/단위>0이라면 이 몫이 변환되는 함수 (0이라면 0을 반환하는 함수)
    // 높은 단위부터 시작하여 개수가 구해지면 그 개수*금액만큼 빼서 계산을 돌릴 것!
    public static int[] unit_money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static int getMoneyList(int money, int index) {
        return Math.max(money / unit_money[index], 0);
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        for(int i = 0; i < unit_money.length; i++) {
            answer.add(getMoneyList(money, i));
            money -= getMoneyList(money, i)*unit_money[i];
        }
        return answer;
    }
}
