package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] won = {50000,10000,5000,1000,500,100,50,10,1};
        int i = 0;

        // money가 1보다 작거나 1,000,000 보다 클 때 예외 처리
        if (money < 1 || money > 1_000_000)
            return answer;

        answer = new ArrayList<>();

        // 입력받은 돈을 오만원으로 나누고 오만원 갯수를 구하고
        // 나머지를 money 값으로 저장하고
        // 다시 만원으로 나눠서 만원 갯수를 구하고
        // 이렇게 계속 1원 단위까지 실행
        while(i != 9) {
            answer.add(money / won[i]);
            money %= won[i++];
        }
        return answer;
    }
}
