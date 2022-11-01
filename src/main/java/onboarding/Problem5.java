package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    // 2. (총 금액 / 돈 단위)의 몫 반환하기
    public static int getShare(int money, int moneyUnit) {
        return money / moneyUnit;
    }

    // 3. 현재 돈 단위를 제외한 나머지 금액 구하기
    public static int getLeftMoney(int money, int moneyUnit) {
        return money % moneyUnit;
    }
}
