package onboarding;

import onboarding.problem7.CrewId;
import onboarding.problem7.RecommendManager;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<List<CrewId>> cast2DListStrToCrewId(List<List<String>> friendIdRelations) {
        return friendIdRelations.stream()
                .map(Problem7::castListStrToCrewId)
                .collect(Collectors.toList());
    }

    public static List<CrewId> castListStrToCrewId(List<String> ids) {
        return ids.stream()
                .map(CrewId::new)
                .collect(Collectors.toList());
    }

    public static List<String> solution(String userStr, List<List<String>> friendsStr, List<String> visitorsStr) {
        validateFriendsRange(friendsStr);
        assertFriendsIsDistinct(friendsStr);
        validateVisitorsRange(visitorsStr);

        CrewId userId = new CrewId(userStr);

        List<List<CrewId>> crewRelations = cast2DListStrToCrewId(friendsStr);
        List<CrewId> crewVisitors = castListStrToCrewId(visitorsStr);

        RecommendManager recommendManager = new RecommendManager(crewRelations, crewVisitors, userId);

        List<CrewId> recommendCrews = recommendManager.getRecommendCrews();

        return recommendCrews.stream()
                .map(CrewId::getId)
                .collect(Collectors.toList());
    }

    private static void validateFriendsRange(List<List<String>> friends) throws IllegalArgumentException {
        if (!(1<=friends.size() && friends.size()<=10000)) {
            throw new IllegalArgumentException("friends의 길이는 1이상 10,000이하여야 합니다.");
        }

        if (!friends.stream().allMatch(friendRel -> friendRel.size() == 2)) {
            throw new IllegalArgumentException("friends안 배열의 길이는 항상 2여야 합니다.");
        }
    }

    private static void assertFriendsIsDistinct(List<List<String>> friends) throws IllegalArgumentException {
        int originSize = friends.size();
        int distinctSize = (int)friends.stream().map(HashSet::new).distinct().count();

        if (originSize != distinctSize) {
            throw new IllegalArgumentException("friends의 친구관계 중 중복된 값이 있으면 안됩니다.");
        }
    }

    private static void validateVisitorsRange(List<String> visitors) throws IllegalArgumentException {
        if (!(visitors.size()<=10000)) {
            throw new IllegalArgumentException("visitors의 길이는 10,000이하여야 합니다.");
        }
    }
}
