package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> currency = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);

        //1. 가장 높은 금액의 화폐부터 선택하여, 입력받은 액수에서 반복적으로 뺀다.
        for(int i = 0; i < currency.size(); i++) {
            //2. (액수 - 화폐)가 0이 되기 전까지 빼고, 0이 되기 직전에 반복을 종료하고 다음 화폐를 선택한다.
            while ((money - currency.get(i)) > 0){
                money = money - currency.get(i);
            }

            //3. 다음 화폐의 금액도 잔여 액수에서 반복적으로 뺀다. 마찬가지로 해당 화폐의 개수를 증가시킨다.
        }
        //4. (액수 - 화폐)가 정확히 0이 된다면 반복을 종료하고 정답 리스트를 반환한다.

        return answer;
    }
}
