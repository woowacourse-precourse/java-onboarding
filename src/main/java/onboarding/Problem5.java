package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<Integer>();

        int[] dividerArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int dividend = money;
        for(int i = 0; i<dividerArr.length; i++){
            int divider = dividerArr[i];
            answer.add(dividend / divider);
            int leftover = money % divider;
            dividend = leftover;
        }
        System.out.println(answer); // []

        return answer;
    }
}
