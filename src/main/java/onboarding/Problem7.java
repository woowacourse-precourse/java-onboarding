package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static int friendScore = 10;
    private static int visitScore = 1;

    public static boolean isUserFriends(
            HashMap<String, HashSet<String>> friendList, String user, String friend
    ) {

    }

    public static HashMap<String, Integer> scoreVisitors(
            HashMap<String, HashSet<String>> friendList,
            HashMap<String, Integer> recommendedFriends,
            List<String> visitors,
            String user
    ) {

    }

    public static HashMap<String, HashSet<String>> createFriendList(List<List<String>> friends) {
        HashMap<String, HashSet<String>> friendListByUser = new HashMap<>();

    }

    public static HashMap<String, Integer> findRecommendedFriend(
            HashMap<String, HashSet<String>> friendList, String user
    ) {
        HashMap<String, Integer> recommendedFriends = new HashMap<>();
        HashSet<String> friends = friendList.get(user);

    }

    public static List<String> getRecommendedUsers(HashMap<String, Integer> recommendedFriends, int number) {
        
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> friendList = createFriendList(friends);
        HashMap<String, Integer> recommendedFriends =  findRecommendedFriend(friendList, user);
        List<String> answer = getRecommendedUsers(
                scoreVisitors(friendList, recommendedFriends, visitors, user), 5
        );

        return answer;
    }
}
