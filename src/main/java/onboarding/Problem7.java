package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user,
                                        List<List<String>> friends,
                                        List<String> visitors) {
        Map<String, Integer> scoreBoard = new HashMap<>();

        Map<String, List<String>> relationMap = createRelation(friends);
        List<String> userRelations = relationMap.get(user);
        userRelations.add(user);

        addRelateScore(relationMap, userRelations, scoreBoard);
        addScore(scoreBoard, userRelations, visitors, 1);

        List<String> result = new ArrayList<>(scoreBoard.keySet());
        result.sort((x, y) -> scoreBoard.get(y) - scoreBoard.get(x));

        if (result.size() > 5) {
            result.subList(0, 5);
        }
        return result;
    }

    private static void addRelateScore(Map<String, List<String>> relationMap,
                                       List<String> userRelations,
                                       Map<String, Integer> scoreBoard) {
        for (String relation : userRelations) {
            List<String> fof = relationMap.get(relation);
            addScore(scoreBoard, userRelations, fof, 10);
        }
    }

    private static void addScore(Map<String, Integer> scoreBoard,
                                 List<String> banList, List<String> targets,
                                 int score) {
        for (String target : targets) {
            if (banList.contains(target)) {
                continue;
            }
            if (scoreBoard.containsKey(target)) {
                scoreBoard.replace(target, scoreBoard.get(target) + score);
            } else {
                scoreBoard.put(target, score);
            }
        }
    }

    private static Map<String, List<String>> createRelation(List<List<String>> friends) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> friend : friends) {
            addToMap(map, friend.get(0), friend.get(1));
            addToMap(map, friend.get(1), friend.get(0));
        }
        return map;
    }

    private static void addToMap(Map<String, List<String>> map, String key,
                                 String value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

}
