package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * @Problem: 돈의 액수 money가 매개변수로 주어질 때, 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
 */
public class Problem5 {
    /**
     * @Method: getMoney
     * * 각 값이 이전 값의 2배 이상씩 증가하기 때문에 Greedy로 해결가능하다.
     * 1. 1 ~ 50,000까지 9가지 화폐를 설정한다.
     * 2. 가장 큰 화폐부터 순차적으로 각 화폐 값으로 나눈다.
     * 3. 몫은 return할 List에 추가, 나머지는 2번을 다음 화폐 값으로 반복한다.
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
