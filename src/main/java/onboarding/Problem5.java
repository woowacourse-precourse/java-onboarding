package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*기능 요구 사항*/
/* 1. money을 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전으로 변환
 * 2. 변환하여 리스트에 포함.
 <solution>
 *  - money를 큰 돈의 단위로 나누어 나눠진 값을 리스트에 추가
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> moneyValue =  Collections.emptyList();
        answer = Arrays.asList(0,0,0,0,0,0,0,0,0);
        moneyValue = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);

        for(int i=0; i<9; i++){
            answer.set(i,money/moneyValue.get(i));
            money = money % moneyValue.get(i);
        }

        return answer;
    }
}
