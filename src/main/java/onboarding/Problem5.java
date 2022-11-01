package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> solution(int money) { // 그리디 알고리즘을 사용해 money를 list 겂으로 나누면서 가장 금액부터 채워나간다
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> wallet = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for(int i = 0; i < 9; i++){
            answer.add(money / wallet.get(i));
            money %= wallet.get(i); // MONEY의 나머지들을 가지고 또 원하는 금액을 찾으러 간다
        }
        return answer;
    }
}
