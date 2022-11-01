package onboarding;

import java.util.*;

/*
기능목록
1. 화폐 단위 배열 moenyList 생성
2. 단위별 화폐 개수 count
    2-1. 금액이 큰 화폐부터 나눈 몫을 answer에 저장
    2-2. 금액이 큰 화폐부터 나눈 나머지를 money에 다시 저장
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyList=new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; //화폐 단위 배열

        for(int i=0; i<moneyList.length; i++){ //단위별 화페 개수 count
            answer.add(money/moneyList[i]);
            money%=moneyList[i];
        }
        return answer;
    }
}
