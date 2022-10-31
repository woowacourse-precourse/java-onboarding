package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //큰 화폐를 작은 화폐로 나누어 떨어지기 때문에 탐욕법 실행
        List<Integer> answer = new ArrayList<>();
        int[] currency_unit_arr = {50000,10000,5000,1000,500,100,50,10,1};
        for (int i = 0; i < currency_unit_arr.length; i++){
            answer.add(money/currency_unit_arr[i]);
            money %= currency_unit_arr[i];
        }
        return answer;
    }
}
