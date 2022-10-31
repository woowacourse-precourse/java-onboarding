package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private final static int[] bills= {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(!isValidInput(money)){
            return answer;
        }

        answer = new ArrayList<Integer>();
        for(int bill: bills){
            int count = money/bill;
            answer.add(count);
            money -= count * bill;
        }
        return answer;
    }

    private static boolean isValidInput(int input){
        return input >= 1 && input <= 1000000;
    }


}
