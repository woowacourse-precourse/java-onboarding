package onboarding;

import java.util.*;

public class Problem7 {
    Map<String, Integer> score = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFridens = new ArrayList<>();

        for(List<String> name : friends){
            if(name.get(0) == user)
                userFridens.add(name.get(1));
            else if (name.get(1) == user) {
                userFridens.add(name.get(0));
            }
        }




        List<String> answer = Collections.emptyList();
        return answer;
    }
}
