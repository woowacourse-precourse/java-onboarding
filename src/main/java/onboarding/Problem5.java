package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();

        int[] arr = {50000,10000,5000,1000,500,100,50,10,1};

        int cnt = 0;

        for(int i = 0;i< arr.length;i++){
            if(money >= arr[i]){
                cnt = money / arr[i];

                money = money - cnt * arr[i];

                answer.add(cnt);
            }else{
                answer.add(0);
            }
        }

        return answer;
    }
}
