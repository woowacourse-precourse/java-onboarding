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
        int[] wonList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int putMoney;
        LeftMoney leftmoney = new LeftMoney();
        ChangeMoney changemoney = new ChangeMoney();

        for (int i=0; i<9; i++) {
            putMoney = changemoney.changeMoney(money, wonList[i]);
            answer.add(putMoney);
            money = leftmoney.leftMoney(money, wonList[i]);
        }
        return answer;
    }
}

class LeftMoney {
    public int leftMoney(int money, int won) {
        int result = money;
        result %= won;
        return result;
    }
}

class ChangeMoney {
    public int changeMoney(int money, int won) {
        int result = money;
        result /= won;
        return result;
    }
}