package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        try{check(money);}
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return answer;
        }
        return answer;
    }

    private static void check(int money) {
        if(money < 1 || money > 1000000)
            throw new IllegalArgumentException("입력값이 범위 밖입니다.");
    }
}
