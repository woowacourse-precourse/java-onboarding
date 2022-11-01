package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allNames = getAllNames(friends, visitors, user);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Set<String> getAllNames(List<List<String>> friends, List<String> visitor, String user) {
        Set<String> allNames = new HashSet<>();

        for (List<String> friend : friends) {
            for (String name : friend) {
                allNames.add(name);
            }
        }

        for (String name : visitor) {
            allNames.add(name);
        }

        allNames.add(user);

        return allNames;
    }
}
