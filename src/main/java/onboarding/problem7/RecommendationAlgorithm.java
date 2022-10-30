package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationAlgorithm {
    public static List<String> recommend(String targetName, List<String> visitorsNames) {
        Map<String, Score> scores = new HashMap<>();

        // UserRelation과 visitors에 따라 추천을 넣는다
        List<String> friendsNames = UserRelation.getFriends(targetName);
        List<String> allUsersNames = UserStore.findAll();
        for(String eachName : allUsersNames) {
            if (eachName.equals(targetName) || friendsNames.contains(eachName)) {
                continue;
            }
            // 친구가 겹치는지 비교
            for (String friendName : friendsNames) {
                if (UserRelation.hasRelation(friendName, eachName)) {
                    if(!scores.containsKey(eachName)) {
                        scores.put(eachName, new Score(eachName));
                    }
                    scores.put(eachName, scores.get(eachName).add(10));
                }
            }
        }
        for(String visitorName : visitorsNames) {
            if (visitorName.equals(targetName) || friendsNames.contains(visitorName)) {
                continue;
            }
            if(!scores.containsKey(visitorName)) {
                scores.put(visitorName, new Score(visitorName));
            }
            scores.put(visitorName, scores.get(visitorName).add(1));
        }
        List<Score> collect = scores.values().stream().collect(Collectors.toList());
        Collections.sort(collect);
        List<String> answer = collect.stream().map(score -> score.getUserName()).collect(Collectors.toList());
        if(answer.size() > 5) {
            return answer.subList(0, 5);
        }
        return answer;
    }

}
