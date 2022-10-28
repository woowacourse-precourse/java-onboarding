package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * 몫과 나머지를 이용한다.
 * 몫 : 사용된 지폐 혹은 동전의 개수를 나타냄
 * 나머지 : 지페의 가격을 뺀 나머지
 * 가장 큰 지폐먼저 사용
 * 1. 현 지폐로 남은 금액보다 작거나 같은 최대 금액 만들 수 있는 지폐 수를 몫으로 구한다.
 * 2. 그러고 남은 나머지는 남은 금액으로 다시 반환해서 사용
 */
public class Problem5 {
    private final static int[] bill = {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static int calculateRequiredMoneyCount(int money, int idx,
                                                   List<Integer> answer){
        answer.set(idx,money/bill[idx]);
        return money%bill[idx];
    }
}
