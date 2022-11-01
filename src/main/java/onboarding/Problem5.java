package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = divideMoneyToReturns(money);

        return answer;
    }

    /**
     * DESCRIPTION
     *   전달받은 돈을 내림차순으로 정렬된 Unit을 이용해 거스름돈을 판별
     *
     * Params
     *   money - 거스름돈 분류를 원하는 돈의 액수
     *
     * RETURN
     *   money를 최대한 적은 수의 Unit으로 구성한 거스름돈 List
     */
    public static List<Integer> divideMoneyToReturns(int money){
        Integer[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 지폐 종류
        Integer[] returns = new Integer[units.length]; // 계산된 거스름돈(인덱스가 각 Unit에 매칭)
        Arrays.fill(returns, 0);

        for(int idx = 0 ; money > 0; idx++){ // 내림차순으로 정렬된 Unit 조사
            returns[idx] = money / units[idx];
            money %= units[idx];
        }

        return Arrays.asList(returns);
    }
}
