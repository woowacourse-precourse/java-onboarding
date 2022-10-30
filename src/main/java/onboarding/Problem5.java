package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
*  모든 화폐 단위에 대해서, 내림차순 순서대로 반복
* 1. answer에 현재 금액을 해당 화폐단위로 나눈 몫을 추가
* 2. 현재 금액 변수에 해당 화폐단위로 나눈 나머지를 저장
* */

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int[] units = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int unit : units) {
            answer.add(money / unit);
            money %= unit;
        }

        return answer;
    }
}
