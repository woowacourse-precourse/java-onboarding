package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * user를 제외한 사용자 List를 구함
     * @param user
     * @param friends
     * @return
     */
    private static List<String> getUsersList(String user, List<List<String>> friends) {
        HashSet<String> users = new HashSet<>();

        for (List<String> next : friends) {
            if (!user.equals(next.get(0))) {
                users.add(next.get(0));
            }
            if (!user.equals(next.get(1))) {
                users.add(next.get(1));
            }
        }

        List<String> result = new ArrayList<>();
        for (String userName : users) {
            result.add(userName);
        }
        return result;
    }

    /**
     * 각 사용자별 현재 이미 친구인 사람들을 구함
     * @param userList
     * @param friends
     * @return
     */
    private static HashMap<String, HashSet<String>> getEachFriendsList(List<String> userList, List<List<String>> friends) {
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (String otherUser : userList) {
            HashSet<String> tempSet = new HashSet<>();
            result.put(otherUser, tempSet);
        }

        for(List<String> next : friends) {
            result.get(next.get(0)).add(next.get(1));
            result.get(next.get(1)).add(next.get(0));
        }
        return result;
    }

    /**
     * 친구가 아닌 사용자들 중에서 공통으로 가지는 수를 통해 점수를 구한다.
     * @param user
     * @param userList
     * @param userFriendsList
     * @return
     */
    private static HashMap<String, Integer> getFriendsScore(String user, List<String> userList, HashMap<String, HashSet<String>> userFriendsList) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String next : userList) {
            result.put(next, 0);
        }

        for (String notFriend : userList) {
            // 이미 친구인 대상에 대해서는 고려하지 않는다.
            if (userFriendsList.get(user).contains(notFriend)) {
                continue;
            }
            int friendCount = 0;
            for (String commonFriend : userList) {
                if (notFriend.equals(commonFriend)) {
                    continue;
                }
                // 만약 commonFriend가 user와 notFriend와 모두 친구라면
                if (userFriendsList.get(user).contains(commonFriend) && userFriendsList.get(notFriend).contains(commonFriend)) {
                    friendCount++;
                }
            }
            result.put(notFriend, friendCount * 10);
        }
        return result;
    }

    /**
     * 친구가 아닌 사용자들 중에서 방문한 횟수만큼 점수를 더한다.
     * @param user
     * @param userFriendsList
     * @param visitors
     * @param userScore
     * @return
     */
    private static HashMap<String, Integer> getVisitorsScore(String user, HashMap<String, HashSet<String>> userFriendsList, List<String> visitors,  HashMap<String, Integer> userScore) {

        for (String visitor : visitors) {
            if (userFriendsList.get(user).contains(visitor)) {
                continue;
            }
            userScore.put(visitor, userScore.get(visitor) + 1);
        }
        return userScore;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userList = getUsersList(user, friends);
        HashMap<String, HashSet<String>> userFriendsList = getEachFriendsList(userList, friends);

        HashMap<String, Integer> userScore = getFriendsScore(user, userList, userFriendsList);
        HashMap<String, Integer> userVisitedScore = getVisitorsScore(user, userFriendsList, visitors, userScore);
    }
}
