package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap hashMap = new HashMap<>();

        for(int i=0; i<friends.size();i++){
            hashMap.put(friends.get(i).get(0),friends.get(i).get(1));
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
