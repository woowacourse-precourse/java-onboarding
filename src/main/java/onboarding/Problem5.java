/*
 * 클래스명: Problem3
 *
 * 시작 날짜: 2022-10-30
 */

package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 현재 거스를 돈 단위 파악후 남은 돈 리턴 해주는 함수 구현
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}

class ChangeMoney {
    public int changeMoney(int money, int won) {
        int result = money;
        result %= won;
        return result;
    }
}

class LeftMoney {
    public int leftMoney(int money, int won) {
        int result = money;
        result /= won;
        return result;
    }
}