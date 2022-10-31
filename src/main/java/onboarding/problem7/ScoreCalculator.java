package onboarding.problem7;

import java.util.*;

public class ScoreCalculator {
    private final String RELATED = "related";
    private final String VISITED = "visited";
    private final int RELATED_SCORE = 10;
    private final int VISITED_SCORE = 1;

    public List<String> getHighScoreList(List<String> relatedList, List<String> visitors) {
        Map<String, Integer> relatedScoreMap = getScore(relatedList, RELATED);
        Map<String, Integer> visitedScoreMap = getScore(visitors, VISITED);
        Map<String, Integer> totalScoreMap = getTotalScore(relatedScoreMap, visitedScoreMap);

        return sortScoreMap(totalScoreMap);
    }

    private Map<String, Integer> getScore(List<String> userList, String type) {
        int score = 0;
        Map<String, Integer> scoreMap = new HashMap<>();
        if (type.equals(RELATED)) {
            score = RELATED_SCORE;
        }

        if (type.equals(VISITED)) {
            score = VISITED_SCORE;
        }

        for (String user : userList) {
            scoreMap.put(user, scoreMap.getOrDefault(user, 0) + score);
        }

        return scoreMap;
    }

    private Map<String, Integer> getTotalScore(Map<String, Integer> map1, Map<String, Integer> map2) {
        map1.forEach((key, value) -> map2.merge(key, value, (v1, v2) -> v1 + v2));
        return map2;
    }

    private List<String> sortScoreMap(Map<String, Integer> scoreMap) {
        List<String> nameList = new ArrayList<>(scoreMap.keySet());
        Collections.sort(nameList, (o1, o2) -> {
            if (scoreMap.get(o1) - scoreMap.get(o2) == 0) {
                return o1.compareTo(o2);
            }
            return scoreMap.get(o2).compareTo(scoreMap.get(o1));
        });
        return nameList;
    }
}
