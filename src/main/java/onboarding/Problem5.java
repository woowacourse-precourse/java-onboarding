package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 사항
 * 1. 돈의 단위를 배열로 저장
 * 2. 금액을 배열로 나눠 리스트에 저장하는 함수
 */
public class Problem5 {
    /**
     * 돈의 단위를 배열로 저장
     */
    static int[] amount = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    /**
     * 금액을 배열로 나눠 리스트에 저장하는 함수
     * 나눌수 있다면 몫을 저장 없다면 0을 저장
     * 나머지는 다시 변수로 재선언
     */
    public static List<Integer> count(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<amount.length; i++){
            if(n >= amount[i]){
                result.add(n/amount[i]);
                n = n%amount[i];
            } else{
                result.add(0);
            }
        }

        return result;
    }
    
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
