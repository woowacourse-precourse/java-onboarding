package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    요구사항 분석
    최소한의 화폐 개수를 받아 은행에서 돈을 출금한다
    50,000  10,000  5,000   1,000   500     100     50      10  1 -> 총9가지 종류의 화폐
    9칸 짜리 배열을 만들어 화폐 개수 기록하여 리턴할것

    제한사항
    money는 1 이상 1,000,000 이하인 자연수이다. (예외처리 할 필요없음)

    기능 구현 목록
    Step1. 화폐단위가 큰 값부터 나눠 몫을 answer에 기록한다
    Step2. 기록 된 값 만큼 answer에서 값을 뺀다
    Step3. 다음 화폐단위로 1~2를 반복하여 0을 만든다
 */
public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();
        int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100 ,50 , 10 , 1};
        int moneyCount;

        for (int i = 0; i < monetaryUnit.length; i++) {
            moneyCount = money / monetaryUnit[i];
            answer.add(moneyCount);
            money -= moneyCount * monetaryUnit[i];
        }
        return answer;
    }
}
