package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationAlgorithm {
    /**
     * target에게 추천할 사용자 리스트를 반환한다
     * 모든 등록된 사용자를 돌며, target과 중복되는 친구 한 명 당 10점의 가산점,
     * target의 sns에 방문한 횟수 한 번 당 1점의 가산점을 더한다
     * 가장 높은 가산점을 가진 최대 다섯명의 사용자의 이름을 리스트로 반환한다
     * @param targetName : target의 이름
     * @param visitorsNames : target의 sns에 방문한 사용자들의 이름
     * @return 최대 다섯개의 추천 계정들의 이름을 List로 반환한다
     * @throws Exception
     */
    public static List<String> recommend(String targetName, List<String> visitorsNames) {
        Map<String, Score> scores = new HashMap<>();
        List<String> allUsers = UserStore.findAll();
        List<String> relatedUsers = UserRelation.getFriends(targetName);
        relatedUsers.add(targetName);

        for(String each : allUsers) {
            if (alreadyRelated(each, relatedUsers)) {
                continue;
            }
            scores.put(each, new Score(each, findOverlappingFriendsCnt(each, relatedUsers)).multiple(10));
        }

        for(String visitorName : visitorsNames) {
            if (alreadyRelated(visitorName, relatedUsers)) {
                continue;
            }
            if(!scores.containsKey(visitorName)) {
                scores.put(visitorName, new Score(visitorName,0));
            }
            scores.put(visitorName, scores.get(visitorName).add(1));
        }
        return returnLimitedNumOfUsersToPriority(scores, 5);
    }

    private static boolean alreadyRelated(String each, List<String> relatedUser) {
        return relatedUser.contains(each);
    }

    private static List<String> returnLimitedNumOfUsersToPriority(Map<String, Score> scores, int limitNum) {
        List<String> recommendedUsersNames = scores.values().stream()
                .filter(score -> score.getScore() != 0)
                .sorted(Collections.reverseOrder())
                .map(Score::getUserName)
                .collect(Collectors.toList());
        if(recommendedUsersNames.size() > limitNum) {
            return recommendedUsersNames.subList(0, limitNum);
        }
        return recommendedUsersNames;

    }

    private static Integer findOverlappingFriendsCnt(String target, List<String> friendsNames) {
        List<String> overlappingFriends = new ArrayList<>();
        for (String friendName : friendsNames) {
            if (UserRelation.hasRelation(friendName, target)) {
                overlappingFriends.add(friendName);
            }
        }
        return overlappingFriends.size();
    }

}
