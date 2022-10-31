package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> recommendScore = new HashMap<>();
        Map<String, List<String>> network = getFriendList(friends);

        addFriendScore(recommendScore, network, user);
        addTimelineScore(recommendScore, visitors);

        List<String> userFriendList = network.get(user);
        List<String> answer = getRecommendedFriendList(recommendScore, userFriendList);

        return answer;
    }

    private static List<String> getRecommendedFriendList(Map<String, Integer> recommendScore, List<String> userFriendList) {
        List<String> recommendedFriendList = new ArrayList<>();
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(recommendScore.entrySet());
        entries.sort(comparator);

        entries.forEach(entry -> {
            if (recommendedFriendList.size() < 5 && entry.getValue() != 0) {
                if (!userFriendList.contains(entry.getKey())) {
                    recommendedFriendList.add(entry.getKey());
                }
            }
        });

        return recommendedFriendList;
    }

    public static Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> {
        if (o1.getValue() > o2.getValue()) {
            return -1;
        } else if (o1.getValue() == o2.getValue()) {
            return o1.getKey().compareTo(o2.getKey());
        } else {
            return 1;
        }
    };


    public static Map<String, List<String>> getFriendList(List<List<String>> friends) {
        Map<String, List<String>> network = new HashMap<>();
        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if (network.containsKey(f1)) {
                network.get(f1).add(f2);
            } else {
                network.put(f1, new ArrayList<>(List.of(f2)));
            }

            if (network.containsKey(f2)) {
                network.get(f2).add(f1);
            } else {
                network.put(f2, new ArrayList<>(List.of(f1)));
            }
        }
        return network;
    }

    public static void addFriendScore(Map<String, Integer> recommendScore, Map<String, List<String>> network, String user) {

        network.get(user).forEach(userFriend ->
                network.get(userFriend).forEach(userFriendFriend -> {
                    if (!userFriendFriend.equals(user)) {
                        if (recommendScore.containsKey(userFriendFriend)) {
                            recommendScore.put(userFriendFriend, recommendScore.get(userFriendFriend) + 10);
                        } else {
                            recommendScore.put(userFriendFriend, 10);
                        }
                    }
                }));
    }

    private static void addTimelineScore(Map<String, Integer> recommendScore, List<String> visitors) {
        visitors.forEach(visitor -> {
            if (recommendScore.containsKey(visitor)) {
                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
            } else {
                recommendScore.put(visitor, 1);
            }
        });
    }

}
