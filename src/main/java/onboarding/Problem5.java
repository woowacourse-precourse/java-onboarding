package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
동전의 금액 단위가 배수 관계이므로, 그리디 알고리즘을 사용 가능함
1. 금액이 큰 지폐부터 가능한만큼 계속 가져간다.
2. 만약 큰 금액에서 이미 나눠 떨어졌을 경우, 존재하는 금액단위의 갯수만큼 0을 추가해줘서 size를 같게함
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int i =0;
        while(money!=0){
            answer.add(money/moneyArr[i]);
            money = money%moneyArr[i];
            i++;
        }
        while(moneyArr.length!=answer.size()){
            answer.add(0);
        }
        return answer;
    }
}
