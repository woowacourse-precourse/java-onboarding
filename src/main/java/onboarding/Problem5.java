package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
        기능목록 :
        1. 화폐 단위를 ArrayList로 선언. (List.of 사용 이유는 단위는 불변이기때문)
        2. 반복문을 돌며 매개변수 money를 나눈 값을 answer에 넣어준다.
        3. 이후 % 연산을 통해 1의자리까지 반복한다.
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyKind = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for(int moneyKindIdx : moneyKind) {
            answer.add(money / moneyKindIdx);
            money %= moneyKindIdx;
        }

        return answer;
    }
}
