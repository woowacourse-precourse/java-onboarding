package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    public static HashMap<String, Integer> initializeScoreBoard(Set<String> crewSet) {
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        for (String crew : crewSet) {
            scoreBoard.put(crew, 0);
        }
        return scoreBoard;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
