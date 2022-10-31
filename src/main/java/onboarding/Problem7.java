package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendsList = makeFriendsList(user, friends);
        LinkedHashMap<String, Integer> scoreMap = makeScoreMap(friends, friendsList, visitors, user);
        List<String> ans = sortRecommendations(scoreMap);
        return ans;
    }


    public static String returnFriendName(List<String> friend, String myName) {

        for (int i = 0; i < 2; i++) {
            if (!(friend.get(i).equals(myName))) {
                return friend.get(i);
            }
        }

        throw new RuntimeException("본인 이름 없음");
    }

    public static List<String> makeFriendsList(String user, List<List<String>> friends) {
        ArrayList<String> friendsList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);

            if (friend.contains(user)) {
                friendsList.add(returnFriendName(friend, user));
            }
        }
        return friendsList;
    }

    public static LinkedHashMap<String, Integer> makeScoreMap(List<List<String>> friends, List<String> friendsList, List<String> visitorsList, String user) {
        LinkedHashMap<String, Integer> scoreMap = new LinkedHashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);

            for (int j = 0; j < friendsList.size(); j++) {
                String alreadyFriend = friendsList.get(j);

                if (friend.contains(alreadyFriend) && !(friend.contains(user))) {
                    String recommendedFriend = returnFriendName(friend, alreadyFriend);

                    if (scoreMap.containsKey(recommendedFriend)) {
                        scoreMap.put(recommendedFriend, scoreMap.get(recommendedFriend) + 10);
                    } else {
                        scoreMap.put(recommendedFriend, 10);
                    }
                }
            }
        }

        for (String visitor : visitorsList) {
            if (scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            } else {
                scoreMap.put(visitor, 1);
            }
        }

        for (String name : friendsList) {
            scoreMap.keySet().removeIf(key -> key.equals(name));
        }

        return scoreMap;
    }

    public static List<String> sortRecommendations(LinkedHashMap<String, Integer> scoreMap) {
        ArrayList<String> recommendations = new ArrayList<>();


        scoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> {
                    recommendations.add(e.getKey());
                });

        return recommendations;
    }
}
