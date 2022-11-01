package onboarding;

/**
 * 기능 요구 사항
 * 1. 큰 금액의 화폐 위주로 받는다.
 * 2. 돈의 액수 money 각 몇개로 반환되는지 solution 메서드 완성
 */

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int[] result = calculateMoney(money);
        return answer;
    }
    public static int[] calculateMoney(int money) {
        int[] wont = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] result = new int[9];
        while(money != 0) {
            for(int i = 0; i < wont.length; i++) {
                if(money < wont[i])
                    continue;
                result[i] += (money / wont[i]);
                money = money % wont[i];
            }
        }
        return result;
    }
}
