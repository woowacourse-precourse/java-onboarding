package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 기능 목록
 * solution     : 메인 작성
 * setWallet    : 지갑 잔돈 설정
 * checkValid   : 예외 처리
 */

public class Problem5 {

    private static List<Integer> wallet = Collections.emptyList();

    public static List<Integer> solution(int money) {
        if (!checkValid(money)) {
            throw new IllegalArgumentException("제한사항 위반");
        }
        List<Integer> answer = new ArrayList<>();
        setWallet();
        for (int j : wallet) {
            answer.add(money / j);
            money = money % j;
        }
        return answer;
    }

    private static void setWallet() {
        wallet = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    }

    private static boolean checkValid(int num) {
        return 1 <= num && num <= 1000000;
    }
}
