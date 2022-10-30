package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        System.out.println(Problem7.solution(user, friends, visitors));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> alreadyFriends = getAlreadyFriends(friends);
        Map<String, Integer> recommendPoint = getRecommendPoint(friends, user);
        recommendPoint = addRecommendPointByVisit(alreadyFriends, recommendPoint, visitors);

        return Arrays.asList("", "");
    }

    private static Set<String> getAlreadyFriends(List<List<String>> friends) {
        Set<String> alreadyFriends = new HashSet<>();

        for (List<String> friend : friends) {
            alreadyFriends.add(friend.get(0));
        }

        return alreadyFriends;
    }


    private static Map<String, Integer> getRecommendPoint(List<List<String>> friends, String user) {
        Map<String, Integer> recommendPoint = new HashMap<>();

        for (List<String> friend : friends) {
            String newFriend = friend.get(1);

            if (!user.equals(newFriend)) {
                recommendPoint.put(newFriend, recommendPoint.getOrDefault(newFriend, 0) + 10);
            }
        }

        return recommendPoint;
    }

    private static Map<String, Integer> addRecommendPointByVisit(Set<String> alreadyFriends, Map<String, Integer> recommendPoint, List<String> visitors) {
        for (String visitor : visitors) {
            if (isNewFriendVisiting(visitor, alreadyFriends)) {
                recommendPoint.put(visitor, recommendPoint.getOrDefault(visitor, 0) + 1);
            }
        }

        return recommendPoint;
    }

    private static boolean isNewFriendVisiting(String visitor, Set<String> alreadyFriends) {
        return !alreadyFriends.contains(visitor);
    }

}
