package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, List<String>> friendMap = new HashMap<>();

        for (List<String> list : friends) {
            makeFriendMap(friendMap, list);
        }

        return answer;
    }

    public static void makeFriendMap(HashMap<String, List<String>> friendMap, List<String> list) {
        String a = list.get(0);
        String b = list.get(1);

        if (friendMap.containsKey(a)) {
            friendMap.get(a).add(b);
        }
        else {
            List<String> newList = new ArrayList<>();
            newList.add(b);
            friendMap.put(a, newList);
        }

        if (friendMap.containsKey(b)) {
            friendMap.get(b).add(a);
        }
        else {
            List<String> newList = new ArrayList<>();
            newList.add(a);
            friendMap.put(b, newList);
        }
    }
}
