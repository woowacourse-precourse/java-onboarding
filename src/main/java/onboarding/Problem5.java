package onboarding;

import java.util.*;

/*
 * # 기능 정리
 * [O] 필요한 화폐 계산 -> 그리디
 * [O] solution 작성
 * [O] 테스트 확인
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = divideMoney(money);
        return answer;
    }

    private static List<Integer> divideMoney(int money) {
        int moneyType[] = {50000,10000,5000,1000,500,100, 50, 10, 1};
        List<Integer> moneyCount = new ArrayList<>();
        int moneyIdx = 0;

        for(int i = 0; i < moneyType.length; i++)
            moneyCount.add(i,0);

        while(moneyIdx < moneyType.length){
            int compare = moneyType[moneyIdx];

            if(money >= compare){
                money -= compare;
                moneyCount.set(moneyIdx, moneyCount.get(moneyIdx) + 1);
                continue;
            }
            moneyIdx++;
        }

        return moneyCount;
    }
}
