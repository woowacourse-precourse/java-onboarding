package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    private List<String> getScore(String user, List<List<String>> friends, List<String> visitors) {


    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Problem7 problem7 = new Problem7();
        answer = problem7.getScore(user, friends, visitors);


        return answer;
    }
}
