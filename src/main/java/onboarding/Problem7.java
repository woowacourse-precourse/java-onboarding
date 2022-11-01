package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, List<String>> friendList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getRecommendFriendList(String user,
                                                      List<List<String>> friends, List<String> visitiors) {
        Map<String, Integer> score = new HashMap<>();
        List<String> resList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {

        }

        for (int i = 0; i < visitiors.size(); i++) {

        }

        return null;
    }

    public static void initFriendList(List<List<String>> friends) {
        Set<String> userSet = new HashSet<>();
        List<String> userList;

        for (int i = 0; i < friends.size(); i++) {
//            for (int j = 0; j < friends.get(i).size(); j++) {
//                userSet.add(friends.get(i).get(0));
//                userSet.add(friends.get(i).get(1));
//            }
            userSet.add(friends.get(i).toArray())
        }

        userList = new ArrayList<>(userSet);

        for (int i = 0; i < userList.size(); i++) {
            List<String> friendsList = new ArrayList<>();

            friendsList = friends.contain
        }
    }

    public static int visitScore(String user, List<String> visitors) {

    }

    public static int knownFriendScore(String user, List<List<String>> friends) {

    }

    public static boolean isFriend(String user, String target) {
        if (friendList.containsKey(user)) {

        }
        else if (friendList.values().contains(user)) {

        }


    }
}
