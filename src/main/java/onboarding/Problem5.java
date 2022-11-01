package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 5만 -> 만 -> 오천 -> 천 -> 오백 -> 백 -> 오십 -> 십 -> 일
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        int[] arr = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i =0; i<arr.length; i++){
            if(money/arr[i] >0) {
                answer.add(i,money/arr[i]);
                money%=arr[i];
            }else answer.add(i,0);
        }




        return answer;
    }
}
