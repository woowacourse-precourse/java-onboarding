package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
    1. 큰 단위부터 검사
    2. 해당 금액의 화폐로 변환 가능한지 확인
    3. 변환 가능하면 화폐로 변환 후 남은 금액 갱신
    4. 변환 가능하지 않으면 더 작은 단위로 넘어감
     */

    // 화폐 단위를 저장하고 있는 배열 billUnit[]
    private static int billUnit[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < billUnit.length; i++) {
            int cnt = moneyToBill(money, billUnit[i]);
            answer.add(cnt);
            money -= (billUnit[i] * cnt);
        }
        return answer;
    }

    // 남은 금액을 해당 단위의 화폐 몇 장으로 변환 가능한지를 판단하는 함수 moneyToBill()
    private static int moneyToBill(int money, int bill) {
        int cnt = money / bill;
        return cnt;
    }
}
