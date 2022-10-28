package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer;
        ArrayList<Integer> answer1=new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            answer1.add(0);
        }
        int [] changes={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < 9; i++) {
            int cnt=money/changes[i];
            money=money%changes[i];
            answer1.set(i, cnt);
        }
        answer=new ArrayList<>(answer1);
        return answer;
    }
}
