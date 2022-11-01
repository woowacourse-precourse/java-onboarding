package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> friendSetMap = mapFriendSet(friends);

        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static HashMap<String, HashSet<String>> mapFriendSet(List<List<String>> friends) {
        HashMap<String, HashSet<String>> ret = new HashMap<>();
        for (List<String> list : friends) {

            ret.putIfAbsent(list.get(0), new HashSet<>());
            ret.putIfAbsent(list.get(1), new HashSet<>());

            ret.get(list.get(0)).add(list.get(1));
            ret.get(list.get(1)).add(list.get(0));
        }

        return ret;
    }

}
