package problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private static Map<String, Integer> score = new HashMap<>();

    public static void scoring(String user, Map<String, List<String>> adjacentList, List<String> visitors, List<String> answer) {
        addRelativeScore(user, adjacentList);
    }

    private static void addRelativeScore(String user, Map<String, List<String>> adjacentList) {
        for (String userFriend : adjacentList.get(user)) {
            for (String userFriendFriend : adjacentList.get(userFriend)) {
                addScore(userFriendFriend, 10);
            }
        }
    }

    private static void addScore(String userFriendFriend, int point) {
        if (score.containsKey(userFriendFriend)) score.put(userFriendFriend, score.get(userFriendFriend) + 10);
        else score.put(userFriendFriend, point);
    }
}
