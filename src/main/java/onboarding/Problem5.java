package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> currency = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int i = 0; i < currency.size(); i++) {
            // 돈을 화폐의 단위로 나눈 몫을 구한다.
            int num = money / currency.get(i);

            // answer에 몫을 add한다.
            answer.add(num);

            // money를 화폐의 단위로 나눈 나머지를 대입한다.
            money %= currency.get(i);
        }
        return answer;
    }
}
