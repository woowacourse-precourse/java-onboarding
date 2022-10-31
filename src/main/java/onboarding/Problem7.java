package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static Set<String> getCrewList(List<List<String>> friends, List<String> visitors) {
        Set<String> crewSet = new HashSet<>();
        for (List<String> friend : friends) {
            for (String name : friend) {
                crewSet.add(name);
            }
        }
        for (String visitor : visitors) {
            if (!crewSet.contains(visitor)) crewSet.add(visitor);
        }

        return crewSet;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
