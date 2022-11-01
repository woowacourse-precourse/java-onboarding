package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        // money는 int형으로 제공되므로 자료형에 대한 체크는 할 필요 없음
        // 입력 범위만 체크
        if(money < 1 || money > 1000000)
            return answer;

        // answer 변수에 각 화폐마다 분류를 완료한 List를 받는다.
        // classifyMoney(money)
        answer = classifyMoney(money);
        return answer;
    }

    static List<Integer> classifyMoney(int money) {
        // ArrayList로 구현( implement )
        List<Integer> answer = new ArrayList<Integer>();

        int len = 9; // 화폐 단위 개수
        // 화폐 단위 배열
        int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // 순회하면서
        for(int i = 0; i < len; ++i)
        {
            // 가장 큰 화폐단위 순으로 나눈 몫 : 해당 단위로 가져갈 수 있는 화폐량
            answer.add(money / bill[i]);
            money %= bill[i];
        }
        return answer;
    }
}
