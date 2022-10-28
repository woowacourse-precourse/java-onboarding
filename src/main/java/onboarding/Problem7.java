package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static String user;
    private static List<String> visitors;
    private static Map<String, Integer> userScore;
    private static Set<String> friendsOfUser;
    private static List<List<String>> friends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        initializeProblem(user, friends, visitors);
        calculateCommonFriends();
        calculateVisitors();
        removeFriendsOfUserAndUser();
        userScore.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> answer.add(entry.getKey()));
        return answer;
    }

    private static void initializeProblem(String user, List<List<String>> friends, List<String> visitors) {
        Problem7.user = user;
        Problem7.visitors = visitors;
        Problem7.friends = friends;
        Problem7.userScore = initializeUserScore();
        Problem7.friendsOfUser = getUserFriends();
    }

    private static Map<String, Integer> initializeUserScore() {
        Map<String, Integer> result = new HashMap<>();
        for (List<String> pairOfFriends : friends) {
            pairOfFriends.forEach(s -> result.put(s, 0));
        }
        for (String visitor : visitors) {
            result.put(visitor, 0);
        }
        return result;
    }

    private static Set<String> getUserFriends() {
        Set<String> result = new HashSet<>();
        for (List<String> pairOfFriends : friends) {
            if (pairOfFriends.get(0).equals(user))
                result.add(pairOfFriends.get(1));
            if (pairOfFriends.get(1).equals(user))
                result.add(pairOfFriends.get(0));
        }
        return result;
    }

    private static void calculateCommonFriends() {
        // ["A","B"] 형식으로 서로 친구인 상태로 들어있습니다.
        for (List<String> pairOfFriends : friends) {
            // 둘 중 하나라도 유저의 친구의 친구이면 10을 더해줍니다.
            if (friendsOfUser.contains(pairOfFriends.get(0)))
                userScore.put(pairOfFriends.get(1), userScore.get(pairOfFriends.get(1)) + 10);
            if (friendsOfUser.contains(pairOfFriends.get(1)))
                userScore.put(pairOfFriends.get(0), userScore.get(pairOfFriends.get(0)) + 10);
        }
    }

    private static void calculateVisitors() {
        for (String visitor : visitors) {
            userScore.put(visitor, userScore.get(visitor) + 1);
        }
    }

    private static void removeFriendsOfUserAndUser() {
        for (String friend : friendsOfUser) {
            userScore.remove(friend);
        }
        userScore.remove(user);
    }
}
