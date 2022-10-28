package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * # 기능 정리
 * [O] 필요한 화폐 계산 -> 그리디
 * [X] solution 작성
 * [X] 테스트 확인
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = divideMoney(money);
        
        return answer;
    }

    private static List<Integer> divideMoney(int money) {
        int moneyType[] = {50000,10000,5000,1000,500,100, 50, 10};
        List<Integer> moneyCount = new ArrayList<>(8);
        int moneyIdx = 0;

        while(moneyIdx < moneyType.length){
            int compare = moneyType[moneyIdx];

            if(money >= moneyType[moneyIdx]){
                money -= moneyType[moneyIdx];
                moneyCount.set(moneyIdx, moneyCount.get(moneyIdx) + 1);
                continue;
            }
            moneyIdx++;
        }

        if(money > 0)
            throw new IllegalStateException("잔금을 처리할 수 없습니다.");

        return moneyCount;
    }
}
