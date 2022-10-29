package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] temp = new int[] {50_000, 10_000, 5_000, 1_000, 500, 100, 50,10, 1};
        for(int i=0; i<temp.length; i++){
            answer.add(money/temp[i]);
            money %= temp[i];
        }
        return answer;
    }
}
