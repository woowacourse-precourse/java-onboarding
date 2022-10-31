package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void initializeTotalUserSet(List<List<String>> friends, Set<String> totalUserSet) {
        for (List<String> friend : friends) {
            totalUserSet.add(friend.get(0));
            totalUserSet.add(friend.get(1));
        }
    }

    private static void initializeEachUserFriendMap(List<List<String>> friends, Set<String> totalUserSet,
                                                    Map<String, List<String>> totalUsersFriends) {
        for (String username : totalUserSet) {
            List<String> eachUserFriends = new ArrayList<>();
            for (List<String> friend : friends) {
                if (friend.get(0).equals(username)) {
                    eachUserFriends.add(friend.get(1));
                } else if (friend.get(1).equals(username)) {
                    eachUserFriends.add(friend.get(0));
                }
            }
            totalUsersFriends.put(username, eachUserFriends);
        }
    }

    private static void calculateRelationshipScore(String user,
                                                   Map<String, List<String>> eachUserFriendMap, Map<String, Integer> userScore) {
        for (String finalUserFriend : eachUserFriendMap.get(user)) {
            for (String friend : eachUserFriendMap.get(finalUserFriend)) {
                // user 제외, user와 이미 친구인 사용자 제외
                if (!friend.equals(user) && !eachUserFriendMap.get(user).contains(friend)) {
                    // 여러 친구와 함께 아는 사용자의 경우, 기존 점수 + 10
                    if (userScore.containsKey(friend)) {
                        userScore.put(friend, userScore.get(friend) + 10);
                    } else {
                        userScore.put(friend, 10);
                    }
                }
            }
        }
    }

    private static void calculateVisitorScore(String user, List<String> visitors,
                                              Map<String, List<String>> eachUserFriendMap, Map<String, Integer> userScore) {

    }

    private static List<String> sortScoreThenName(Map<String, Integer> userScore) {
        return null;
    }

    private static void addMaximumFiveHighScore(List<String> answer, List<String> keyset) {

    }
}

