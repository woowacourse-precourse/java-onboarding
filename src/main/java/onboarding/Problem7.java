package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> myFriends = new HashSet<>();
        List<List<String>> recommendationsCandidates = new ArrayList<>();
        Map<String, Integer> recommendationScore = new HashMap<>();

        // 친구 집합 구하기
        for (int i = 0; i < friends.size(); i++) {
            List<String> subList = friends.get(i);
            if (subList.get(0).equals(user) && subList.get(1).equals(user)) {
                continue;
            } else if (subList.get(0).equals(user)) {
                myFriends.add(subList.get(1));
            } else if (subList.get(1).equals(user)) {
                myFriends.add(subList.get(0));
            } else {
                recommendationsCandidates.add(subList);
            }
        }

        //친구의 친구인 경우 10점을 더하기
        for (int i = 0; i < recommendationsCandidates.size(); i++) {
            List<String> relationship = recommendationsCandidates.get(i);
            String person1 = relationship.get(0);
            String person2 = relationship.get(1);

            if (myFriends.contains(person1) && !myFriends.contains(person2)) {
                recommendationScore.put(person2, recommendationScore.getOrDefault(person2, 0) + 10);
            } else if (myFriends.contains(person2) && !myFriends.contains(person1)) {
                recommendationScore.put(person1, recommendationScore.getOrDefault(person1, 0) + 10);
            }
        }

        return answer;
    }
}
