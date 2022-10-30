package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static int[] curruncyList = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int curruncy : curruncyList){
            answer.add(money/curruncy);
            money%=curruncy;
        }
        return answer;
    }

}
