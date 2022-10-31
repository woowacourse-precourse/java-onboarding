package onboarding;

import java.util.*;

/**
 * 구현 기능 목록
 * 1. greedy를 이용해 최적의 해를 찾도록 함
 * 2. 돈의 액수를 나열한 배열을 생성한다. {50000, 10000 … 10, 1}
 * 3. 돈의 액수를 담은 배열을 순회하면서, 변환된 개수를 list에 담는다.
 * 4. list를 반환한다.
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List <Integer> result = new ArrayList<>();
        List <Integer> amount = List.of(50000, 10000, 5000, 1000, 500, 100 ,50, 10, 1);

        for(int i=0; i<amount.size(); i++){
            result.add(money / amount.get(i));
            money = money%amount.get(i);
        }
        return result;
    }
}
