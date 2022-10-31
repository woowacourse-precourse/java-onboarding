package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전

/**
 * 기능 목록
 * 주어진 금액 에서
 * 1. 오만원 권, 금액 최신화
 * 2. 만원 권, 금액 최신화
 * 3. 오천 원권, 금액 최신화
 * 4. 천 원권, 금액 최신화
 * 5. 오백원 동전, 금액 최신화
 * 6. 백원 동전, 금액 최신화
 * 7. 오십원 동전, 금액 최신화
 * 8. 십원 동전, 금액 최신화
 * 9. 일원 동전, 금액 최신화
 */
public class Problem5 {

    public static int[] standardArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        Problem5 p5 = new Problem5();
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> answer = p5.exchangeMoney(emptyList, money);
        return answer;
    }

    public List<Integer> exchangeMoney(List<Integer> list, int money) {
        for (int i = 0; i < standardArr.length; i++) {
            list.add(money / standardArr[i]);
            // 나머지 활용.
            // money -= (standardArr[i] * quotient);
            money = money % standardArr[i];
        }
        return list;
    }
}
