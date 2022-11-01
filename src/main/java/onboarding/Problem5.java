package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /*
        기능 요구 사항 목록
        1. 변환할 돈의 개수 반환 함수
        2. 변환하고 남은 돈 반환 함수
        3. 변환되는 돈의 개수를 리스트로 반환하는 함수
        4. solution 함수
    */

    static int[] BILLS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    // 변환할 돈의 개수 반환 함수
    private static int countMoney(int money, int bill) {
        return money / bill;
    }

    // 변환하고 남은 돈 반환 함수
    private static int leftMoney(int money, int bill) {
        return money % bill;
    }

    // 변환되는 돈의 개수를 리스트로 반환하는 함수
    private static List<Integer> changeMoney(int money) {
        List<Integer> changeCount = new ArrayList<>();
        for (int bill : BILLS) {
            int count = countMoney(money, bill);
            money = leftMoney(money, bill);

            changeCount.add(count);
        }
        return changeCount;
    }

    public static List<Integer> solution(int money) {
        return changeMoney(money);
    }
}
