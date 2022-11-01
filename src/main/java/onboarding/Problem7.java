package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, HashSet<String>> userInfo = createUserInfo(friends);

        return answer;
    }

    private static HashMap<String, HashSet<String>> createUserInfo(List<List<String>> friends) {
        HashMap<String, HashSet<String>> userInfo = new HashMap<String, HashSet<String>>();
        for (List<String> pair : friends) {
            String people0 = pair.get(0);
            String people1 = pair.get(1);
            if (userInfo.containsKey(people0)){
                userInfo.get(people0).add(people1);
            }
            else {
                HashSet<String> temp = new HashSet<String>();
                temp.add(people1);
                userInfo.put(people0,temp);
            }
            if (userInfo.containsKey(people1)){
                userInfo.get(people1).add(people0);
            }
            else {
                HashSet<String> temp = new HashSet<String>();
                temp.add(people0);
                userInfo.put(people1,temp);
            }
        }
        return userInfo;
    }
}
