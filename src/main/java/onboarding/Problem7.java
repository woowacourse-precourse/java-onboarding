package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> near = new ArrayList<>();
        List<String> far = new ArrayList<>();
        Map<String, Integer> result = new HashMap<>();

        for (List<String> AB : friends) {
            if (AB.contains(user)) {
                int index = 1 - AB.indexOf(user);
                near.add(AB.get(index));
            }
        }

        for (List<String> AB : friends) {
            for (String name : AB) {
                if(near.contains(name) && !AB.contains(user)){
                    far.addAll(AB);
                }
            }
        }

        for (int i = far.size() - 1; i >= 0; i--) {
            if (near.contains(far.get(i))) {
                far.remove(i);
            }
        }

//        for (String name : near) {
//            for (List<String> AB : friends) {
//                int point = 10;
//                int index = 1 - AB.indexOf(name);
//                if (!AB.contains(user) && AB.contains(name) && !near.contains(AB.get(index))) {
//                    far.add(AB.get(index));
//                    if (result.get(AB.get(index)) != null) {
//                        point += (result.get(AB.get(index)));
//                    }
//                    result.put(AB.get(index), point);
//                }
//            }
//        }
//
        for (String name : visitors) {
            if (near.contains(name)) continue;
            int point = 1;
            if (result.get(name) != null) {
                point += (result.get(name));
            }
            result.put(name, point);
        }

        answer = sortedAnswer(answer, result);
        return answer;
    }

    private static List<String> sortedAnswer(List<String> answer, Map<String, Integer> result) {
        int count = 0;

        List<Map.Entry<String, Integer>> entries = result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : entries) {
            if (count > 4) return answer;
            answer.add(entry.getKey());
            count++;
        }
        return answer;
    }
}
