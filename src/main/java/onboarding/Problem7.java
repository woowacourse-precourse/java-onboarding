package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> nameSetCreator(String user ,List<List<String>> friends) {
        Set<String> names = new HashSet<String>();
        for (List<String> friend : friends) {
            names.add(friend.get(0));
            names.add(friend.get(1));
        }
        names.add(user);

        List<String> result = new ArrayList<>(names);
        Collections.sort(result);
        return result;
    }
}
