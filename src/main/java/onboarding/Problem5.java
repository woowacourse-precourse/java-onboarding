package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 돈의 단위는 주어졌으므로 50000 ~ 1 까지의 정수의 리스트를 만든다.
 * 최종 리턴하게되는 answer라는 리스트또한 만든다.
 * 반복문을 만들고 50000부터 시작해서 주어진 매개변수를 나눈다.
 * 만약 값이 0일 경우 answer에 0을 add한다.
 * 만약 값이 0이 아닐 경우 나눗셈 값을 answer에 add하고 주어진 매개변수는 나눗셈의 값과 돈의 단위를 곱한 값을 뺀다.
 * 마지막에 answer list를 리턴한다.
 *
 * @author heeyoung lee
 * @date 2022.10.30
 */

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> intArr = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<intArr.size(); i++){
            int result = money/intArr.get(i);
            if( result!=0 ){
                answer.add(result);
                money -= result*(intArr.get(i));
            } else{
                answer.add(0);
            }
        }
        return answer;
    }
}
