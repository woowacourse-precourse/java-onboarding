package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] a = {
                50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
        };
        int m = money;
        //나누고자하는 금액보다 클 경우 나눠서 몫을 answer 에 넣어주고 작을 경우에는
        //0을 넣어준 뒤 나머지 금액과 다음 금액을 비교한다.
        for(int i=0; i<9;){
            if(m >= a[i]){
                answer.add(m / a[i]);
                m %= a[i];
            }else{
                answer.add(0);
            }
            i++;
            while(i < 9 && m < a[i]){
                answer.add(0);
                i++;
            }
        }
        return answer;
    }
}
