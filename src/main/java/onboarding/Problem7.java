package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final HashSet<String> users = new HashSet<>();
    private static final HashMap<String, List<String>> network = new HashMap<>();
    private static final HashMap<String, Integer> recommendedScore = new HashMap<>();

    public static boolean validCheck(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                return false;
            }
            if (friend.get(0).length() < 1 || friend.get(0).length() > 30) {
                return false;
            }
            if (friend.get(1).length() < 1 || friend.get(1).length() > 30) {
                return false;
            }
        }
        if (visitors.size() > 10000) {
            return false;
        }
        if (friends.stream().distinct().count() != friends.size()) {
            return false;
        }
        return true;
    }

    public static void makeUser(String user, List<List<String>> friends, List<String> visitors) {
        users.add(user);
        for (List<String> friend : friends) {
            users.addAll(friend);
        }
        users.addAll(visitors);
    }

    public static void makeNetwork(List<List<String>> friends) {
        for (String name : users) {
            network.put(name, new ArrayList<>());
        }
        for (List<String> friend : friends) {
            List<String> connectedFirstFriend = network.get(friend.get(0));
            List<String> connectedSecondFriend = network.get(friend.get(1));
            connectedFirstFriend.add(friend.get(1));
            connectedSecondFriend.add(friend.get(0));
            network.put(friend.get(0), connectedFirstFriend);
            network.put(friend.get(1), connectedSecondFriend);
        }
    }

    public static void recommendedScoreCalculation(String user, List<String> visitors) {
        for (String name : users) {
            recommendedScore.put(name, 0);
            if (Objects.equals(name, user)) {
                recommendedScore.put(name, -1);
            }
        }

        List<String> userFriends = network.get(user);

        for (String friend : userFriends) {
            recommendedScore.put(friend, -1);
        }
        for (String friend : userFriends) {
            List<String> connectedFriend = network.get(friend);
            for (String connectedFriendName : connectedFriend) {
                Integer originScore = recommendedScore.get(connectedFriendName);
                if (originScore != -1) {
                    originScore += 10;
                    recommendedScore.put(connectedFriendName, originScore);
                }
            }
        }
        for (String visitor : visitors) {
            Integer originScore = recommendedScore.get(visitor);
            if (originScore != -1) {
                originScore += 1;
                recommendedScore.put(visitor, originScore);
            }
        }
    }

    public static List<String> getRecommendedFriend() {
        List<String> result = new ArrayList<>(Collections.emptyList());
        List<Map.Entry<String, Integer>> sortedFriend = recommendedScore
                .entrySet()
                .stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (Objects.equals(o1.getValue(), o2.getValue())) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }).collect(Collectors.toList());
        for (Map.Entry<String, Integer> recommendedFriend : sortedFriend) {
            if (recommendedFriend.getValue() > 0) {
                result.add(recommendedFriend.getKey());
            }
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if (!validCheck(user, friends, visitors)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        makeUser(user, friends, visitors);
        makeNetwork(friends);
        recommendedScoreCalculation(user, visitors);
        answer = getRecommendedFriend();
        return answer;
    }
}
