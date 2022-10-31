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
        CrewId userId = new CrewId(userStr);

        List<List<CrewId>> crewRelations = cast2DListStrToCrewId(friendsStr);
        List<CrewId> crewVisitors = castListStrToCrewId(visitorsStr);

        RecommendManager recommendManager = new RecommendManager(crewRelations, crewVisitors, userId);

        List<CrewId> recommendCrews = recommendManager.getRecommendCrews();

        return recommendCrews.stream()
                .map(CrewId::getId)
                .collect(Collectors.toList());
    }
}
