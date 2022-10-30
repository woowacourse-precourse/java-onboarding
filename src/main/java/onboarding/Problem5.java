package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer ={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        char ls = new char[9];
        for (int i = 0;answer.length;i ++){
             ls.add(money/answer[i]);
             money = money % answer[i];
        }
        for(int i = 0; i<9;i++){
            System.out.println(ls);
        }
        return answer;
    }
}
