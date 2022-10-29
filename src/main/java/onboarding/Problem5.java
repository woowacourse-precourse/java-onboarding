package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> billsAndCoins = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        // 사용된 동전뿐 아니라 사용안된 동전의 개수도 반환해야 하므로 break조건 필요없음
        for(int unit: billsAndCoins) {
            int num = (int)(money / unit);
            answer.add(num);
            money %= unit;
        }
        return answer;
    }
}
