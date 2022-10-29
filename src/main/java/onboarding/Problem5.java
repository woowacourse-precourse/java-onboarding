package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        int arr[]={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int cnt=0;

        for(int i = 0; i<9; i++){
            cnt = money/arr[i];
            answer.add(cnt);
            money = money % arr[i];
        }
        return answer;
    }
}
