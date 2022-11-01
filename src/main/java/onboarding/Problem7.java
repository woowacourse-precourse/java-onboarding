package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> peopleSet = getPeopleSet(friends, visitors);
        return answer;
    }

    public static Set<String> getPeopleSet(List<List<String>> friends, List<String> visitors) {
        Set<String> set = new HashSet<>();
        for(List<String> l : friends) {
            set.addAll(l);
        }
        set.addAll(visitors);
        return set;
    }
}
