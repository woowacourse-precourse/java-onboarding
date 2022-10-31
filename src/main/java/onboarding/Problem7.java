package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> scoreMap = new HashMap<>();

        for (List<String> list :friends) {

            for (int i = 0; i < 2; i++) {
                String name= list.get(i);
                if(!scoreMap.containsKey(name)){
                    scoreMap.put(name,0);
                }
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
