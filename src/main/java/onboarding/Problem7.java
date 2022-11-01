package onboarding;

import java.util.*;

public class Problem7 {

    private static final int DUPLICATED_FRIENDS_SCORE = 10;
    private static final int VISITOR_SCORE = 1;
    private static final int MAX_SUGGESTION = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> nameAndScoreMap = new HashMap<>();

        List<String> friendsOfUser = getFriendsFrom(user, friends);

        // user, user의 친구는 제외
        List<String> excludes = new ArrayList<>();
        excludeUserAndFriendsOfUser(excludes, user, friendsOfUser);

        for (String friendOfUser : friendsOfUser) {
            //user의 친구의 친구
            List<String> friendsOfFriendsOfUser = getFriendsFrom(friendOfUser, friends);


        }

        List<String> answer = Collections.emptyList();;

        return answer;
    }

    private static void excludeUserAndFriendsOfUser(List<String> excludes, String user, List<String> friendsOfUser) {
        excludes.add(user);
        excludes.addAll(friendsOfUser);
    }

    // 첫 파라미터의 친구를 찾는 메서드
    private static List<String> getFriendsFrom(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            if (userA.equals(user)) {
                userFriends.add(userB);
            }
            if (userB.equals(user)) {
                userFriends.add(userA);
            }
        }

        return userFriends;
    }

}
