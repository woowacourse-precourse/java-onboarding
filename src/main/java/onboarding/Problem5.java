package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 잔돈 목록
        int[] change_types = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        while(money > 0){
            // 잔돈 목록에서 하나씩 탐색 (5만원부터 1원까지)
            for(int change : change_types){
                // 현재 돈이 잔돈보다 크다면
                if(money >= change) {
                    // 몇 장을 거스를 수 있는 지를 계산
                    int change_count = money / change;
                    answer.add(change_count);
                    // 계산한 지폐만큼 현재 돈에서 가감
                    money -= (change * change_count);
                }
                // 현재 돈이 잔돈보다 작으면 없음을 나타내고, 다음으로 넘어감
                else answer.add(0);
            }
        }
        return answer;
    }
}
