package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
    * 기능 목록
    * 1. 50000~1까지 각 단위별로 몇개가 있는지 세주는 기능.
    * 2. 만약, 1원전에 나누어떨어지는 경우, 1원까지 0으로 채워주는 기능.
    * */

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] arr = {50000,10000,5000,1000,500,100,50,10,1};

        int idx = 0;
        while (money != 0){
            if (money < arr[idx]){
                idx+=1;
                answer.add(0);
                continue;
            }

            int number = money/arr[idx];
            answer.add(number);
            money -= arr[idx]*number;
            idx+=1;
        }

        while (answer.size()<9){
            answer.add(0);
        }

        return answer;
    }
}
