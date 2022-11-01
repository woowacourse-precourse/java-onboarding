package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] answer = new int[9];
        int [] coinArr = new int []{50000,10000,5000,1000,500,100,50,10,1};

        for (int i = 0; i < 9;i++){
            if(money/coinArr[i] > 0) {
                int curr = money / coinArr[i];
                answer[i]= curr;
                System.out.print(curr);
                money = money % coinArr[i];
            }
        }

        List<Integer> result = Arrays.stream(answer).boxed().collect(Collectors.toList());
        return result;
    }
}
