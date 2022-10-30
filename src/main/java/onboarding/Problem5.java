package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
    기능 목록
    1. 주어진 금액에 대한 변수를 초기값으로 잡고, 나머지와 나누기 연산으로 반환되야 하는 금액의 수를 리턴 한다.
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] cost = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        answer = cal(cost, money);
        return answer;
    }

    // Step 1. 파라미터를 입력받아 거스름 돈의 개수를 List 형태로 반환
    // cost -> 금액권에 대한 정보
    // money -> 주어진 돈
    public static List<Integer> cal(int[] cost, int money){
        List<Integer> wallet = new LinkedList<>();

        for(int i = 0; i<9; i++){
            wallet.add(money/cost[i]);
            money %= cost[i];
        }
        return wallet;
    }
}
