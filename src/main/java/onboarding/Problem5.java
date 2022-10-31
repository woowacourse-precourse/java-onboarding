package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneys = {50000,10000,5000,1000,500,100,50,10,1};

        for (int m : moneys) {
            answer.add(money / m); // 필요한 금액권 개수 구하기
            money %= m; // 남은 금액 저장
        }

        return answer;
    }
}
