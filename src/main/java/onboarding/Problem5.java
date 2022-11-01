package onboarding;

import java.util.*;

public class Problem5 {
    /**
     * 화폐 변환
     * @param money
     * @return 개수 리스트
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = calcMoney(money);
        return answer;
    }

    /**
     * 화폐 변환 개수 함수
     * @param money
     * @return 화폐 변환 개수
     */
    public static List<Integer> calcMoney(int money) {
        int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();
        for(int bill : bills) {
            result.add(money / bill);
            money %= bill;
        }
        return result;
    }
}
