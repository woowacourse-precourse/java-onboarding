package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> check(List<Integer> answer,int money){
        int[] arr = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i = 0 ;i<arr.length;i++){
            answer.add(money/arr[i]);
            money-=arr[i]*(money/arr[i]);
        }
        return answer;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        return check(answer,money);
    }
}
