package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer=new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            answer.add(0);
        }
        int [] changes={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < 9; i++) {
            int cnt=money/changes[i];
            money=money%changes[i];
            answer.set(i, cnt);
        }
        return answer;
    }
}
