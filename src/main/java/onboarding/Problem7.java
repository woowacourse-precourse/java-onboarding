package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendInfo = new HashMap<>();

        Map<String, Integer> score = new HashMap<>();

        for(List<String> relation : friends) {
            if(friendInfo.containsKey(relation.get(0))) {
                friendInfo.get(relation.get(0)).add(relation.get(1));
            } else {
                friendInfo.put(relation.get(0), new ArrayList<>(List.of(relation.get(1))));
            }
            if(friendInfo.containsKey(relation.get(1))) {
                friendInfo.get(relation.get(1)).add(relation.get(0));
            } else {
                friendInfo.put(relation.get(1), new ArrayList<>(List.of(relation.get(0))));
            }
        }

        // 사용자의 친구와 친구인 사람 +50점
        for (String friendName : friendInfo.get(user)) {
            for(String candidate : friendInfo.get(friendName)) {
                if (candidate.equals(user)) continue;
                if (friendInfo.get(user).contains(candidate)) continue;

                if (score.containsKey(candidate)) {
                    score.put(candidate, score.get(candidate)+50);
                } else {
                    score.put(candidate, 50);
                }
            }
        }

        // 방문 +10점
        for(String candidate : visitors) {
            if (candidate.equals(user)) continue;
            if (friendInfo.get(user).contains(candidate)) continue;

            if (score.containsKey(candidate)) {
                score.put(candidate, score.get(candidate)+10);
            } else {
                score.put(candidate, 10);
            }
        }

        return score.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (Objects.equals(o1.getValue(), o2.getValue()))
                        return o1.getKey().compareTo(o2.getKey());
                    return o2.getValue() - o1.getValue();
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
