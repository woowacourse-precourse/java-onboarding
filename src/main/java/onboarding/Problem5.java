package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] change = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static void main(String[] args) {
        System.out.println(solution(15000));
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i =0;i<9;i++){
            answer.add(money/change[i]);
            money %= change[i];
        }
        return answer;
    }
}
