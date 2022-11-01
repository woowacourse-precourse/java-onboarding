package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(9);
        int[] notes = new int[]{50_000,10_000,5_000,1_000,500,100,50,10,1};
        for (int i = 0; i < notes.length; i++) {
            int note = notes[i];
            answer.add(money/note);
            money %= note;
        }
        return answer;
    }
}
