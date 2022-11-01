package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem 5
 *
 * 기능 요구 사항
 * 1. 계좌에 들어있는 돈을 출금
 * 2. 지갑이 최대한 가볍게하기 위해 큰 금액의 화폐위주로 받는다.
 * 3. money가 주어지면, 각 화페 몇 개로 변환되는지 완성
 * 4. 단. 금액이 큰 순서대로 리스트에 담는다.
 *
 * 제한 사항
 * 1. money는 1~1,000,000 이하인 자연수
 */
public class Problem5 {
    /**
     *
     * @param money
     * @return 화폐의 개수 리스트
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withDraw(money);
        return answer;
    }

    /**
     * 은행 돈을 화폐로 인출하는 함수
     * @param money
     * @return 인출된 화폐 리스트
     */
    public static List<Integer> withDraw(int money) {
        int[] pay = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> moneyList = new ArrayList<Integer>();

        for (int i=0; i<9; i++) {
            moneyList.add(money / pay[i]);
            money %= pay[i];
        }
        return moneyList;
    }
}
