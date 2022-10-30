package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        //화폐 단위 배열(일원 제외)
        int[] moneyUnit = {50000,10000,5000,1000,500,100,50,10};
        for(int i = 0 ; i < moneyUnit.length ; i++){
            //화폐 단위별 사용량 리스트에 추가
            answer.add(money/moneyUnit[i]);
            //화폐 단위별 사용 후 남은 금액 업데이트
            money%=moneyUnit[i];
        }
        //일원 사용량
        answer.add(money);
        return answer;
    }
}
