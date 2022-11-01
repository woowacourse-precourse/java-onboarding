package onboarding;

import java.util.*;
import onboarding.domain.Score;
import static onboarding.validation.NumberValidate.rangeValidate;

public class Problem7 {

    public static Map<String, Set<String>> createMap(List<List<String>> friends) {

        Map<String, Set<String>> answer = new HashMap<>();
        String f1, f2;

        for (List<String> friend : friends) {

            f1 = friend.get(0);
            f2 = friend.get(1);


            if (answer.containsKey(f1)) {
                answer.get(f1).add(f2);
            } else {
                answer.put(f1, new HashSet<>(List.of(f2)));
            }

            if (answer.containsKey(f2)) {
                answer.get(f2).add(f1);
            } else {
                answer.put(f2, new HashSet<>(List.of(f1)));
            }

        }

        return answer;

    }

    private static boolean problemValidate(String user, List<List<String>> friends, List<String> visitors) {
        if(!rangeValidate(1, user.length(), 30)) return false;
        if(!rangeValidate(1, friends.size(), 10000)) return false;
        for(List<String> lst : friends) {
            if(!rangeValidate(1, lst.size(), 2)) return false;
            if(!rangeValidate(1, lst.get(0).length(), 30)) return false;
            if(!rangeValidate(1, lst.get(1).length(), 30)) return false;
        }
        if(!rangeValidate(0, visitors.size(), 10000)) return false;
        return true;
    }


    private static void addingScore(String user, Map<String, Set<String>> graph, Map<String, Integer> score, List<String> visitors) {
        for(String i : graph.get(user)){
            for(String j : graph.get(i)) {
                if (j.compareTo(user) == 0) {
                    continue;
                }
                if (score.containsKey(j)) {
                    score.replace(j, score.get(j)+10);
                } else {
                    score.put(j, 10);
                }
            }
        }

        for(String i : visitors){
            if(score.containsKey(i)) {
                score.replace(i, score.get(i) +1);
            } else {
                score.put(i, 1);
            }
        }
        for(String i : graph.get(user)) score.remove(i);
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        if(!problemValidate(user, friends, visitors)) return null;

        Map<String, Set<String>> graph = createMap(friends);
        Map<String, Integer> score = new HashMap<>();

        addingScore(user, graph, score, visitors);

        List<Score> lst = new ArrayList<>();

        for(String i : score.keySet()) lst.add(new Score(score.get(i), i));

        Collections.sort(lst, Score.comparator);

        List<String> answer = new ArrayList<>();
        for (Score i : lst) answer.add(i.name);

        return answer;
    }
}
