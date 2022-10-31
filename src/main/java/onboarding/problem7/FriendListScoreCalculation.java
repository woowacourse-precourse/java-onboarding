package onboarding.problem7;

import java.util.HashMap;
import java.util.List;

public class FriendListScoreCalculation {

    public HashMap<String, Integer> scoreCalculations(String user,
                                                      List<List<String>> friends,
                                                      List<String> visitors) {

        HashMap<String, Integer> scoreMap = new HashMap<>();

        FriendMap friendMap = new FriendMap();
        HashMap<String, List<String>> friendList = friendMap.createFriendList(friends);

        List<String> userFriends = friendList.remove(user);

        calculations(visitors, scoreMap, friendList, userFriends);

        return scoreMap;
    }

    public void calculations(List<String> visitors,
                             HashMap<String, Integer> scoreMap,
                             HashMap<String, List<String>> relationships,
                             List<String> userFriends) {

        for (String nickname : relationships.keySet()) {

            List<String> otherFriends = relationships.get(nickname);
            int score = scoreMap.getOrDefault(nickname, 0);

            for (String friendId : otherFriends) {
                if (userFriends.contains(friendId)) {
                  score += 10;
                }
            }

            scoreMap.put(nickname, score);
        }

        for (String nickname : visitors) {
            if (!userFriends.contains(nickname)) {
                int score = scoreMap.getOrDefault(nickname, 0);
                scoreMap.put(nickname, score + 1);
            }
        }

    }
}
