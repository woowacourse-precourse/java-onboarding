/*
 * 클래스명: Problem5
 *
 * 시작 날짜: 2022-10-30
 */

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

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

class LeftMoney {//거스르고 남는 돈
    public int leftMoney(int money, int won) {
        int result = money;
        result %= won;
        return result;
    }
}

class ChangeMoney {//거스른 돈의 갯수
    public int changeMoney(int money, int won) {
        int result = money;
        result /= won;
        return result;
    }
}