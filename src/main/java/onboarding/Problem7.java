package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Recommendation recommend = new Recommendation(user, friends, visitors);

        if(recommend.exception() == -1) {
            answer.add("***** Error *****");
        } else {
            answer = recommend.recommend();
        }

        return answer;
    }
}
