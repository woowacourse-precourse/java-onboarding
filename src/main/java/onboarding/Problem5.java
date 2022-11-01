package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
 1. 금액 별 리스트 생성
 2. money / 리스트
    - 몫을 answer에 저장
    - 나머지를 money에 저장하고 반복
* */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] wonList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int won : wonList){
            answer.add(money/won);
            money %= won;
        }

        return answer;
    }
}
