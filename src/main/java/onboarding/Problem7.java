package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        final int friends_to_friends_count = 10;
        final int visitors_count = 1;

        try {
            ExceptionProblem7.validateId(user);
            ExceptionProblem7.validateFriends(friends);
        } catch (IllegalArgumentException e) {
            return Collections.emptyList();
        }

        HashMap<String, Integer> friendRecommendationMap = new HashMap<>();

        List<String> usersFriends = new ArrayList<>(findUserFriend(friends, user));
        List<String> usersFriendsToFriends = new ArrayList<>(findUserFriendToFriend(friends, usersFriends, user));
        countFriendsShip(friendRecommendationMap, usersFriendsToFriends, friends_to_friends_count);
        countFriendsShip(friendRecommendationMap, visitors, visitors_count);
        removeUserFriends(friendRecommendationMap, usersFriends);

        List<String> recommendationFriendsList = getDescendingOrderFriendsList(friendRecommendationMap);
        List<String> finalRecommendationFriendsList = getSubListFriendsFive(recommendationFriendsList);

        return finalRecommendationFriendsList;
    }

    public static HashSet<String> findUserFriend(List<List<String>> friends, String user) {
        HashSet<String> usersFriends = new HashSet<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                usersFriends.add(friend.get(0));
                usersFriends.add(friend.get(1));
            }
        }

        usersFriends.remove(user);
        return usersFriends;
    }

    public static HashSet<String> findUserFriendToFriend(List<List<String>> friends, List<String> usersFriends, String user) {
        HashSet<String> usersFriendToFriends = new HashSet<>();

        for (String usersFriend : usersFriends) {
            usersFriendToFriends.addAll(findUserFriend(friends, usersFriend));
        }

        usersFriendToFriends.remove(user);
        return usersFriendToFriends;
    }

    public static void countFriendsShip(HashMap<String, Integer> friendRecommendationMap, List<String> friendsToFriends, int count) {
        for (String name : friendsToFriends) {
            if (friendRecommendationMap.containsKey(name)) {
                friendRecommendationMap.put(name, friendRecommendationMap.get(name) + count);
                continue;
            }
            friendRecommendationMap.put(name, count);
        }
    }

    public static void removeUserFriends(HashMap<String, Integer> friendRecommendationMap, List<String> userFriends) {
        for (String friend : userFriends) {
            friendRecommendationMap.remove(friend);
        }
    }

    public static List<String> getDescendingOrderFriendsList(HashMap<String, Integer> friendRecommendationMap) {
        List<String> answer = new ArrayList<>(friendRecommendationMap.keySet());
        Collections.sort(answer, (o1, o2) -> (friendRecommendationMap.get(o2).compareTo(friendRecommendationMap.get(o1))));
        return answer;
    }

    public static List<String> getSubListFriendsFive(List<String> recommendationFriendsList) {
        int max = 5;
        if (recommendationFriendsList.size() < 5) {
            max = recommendationFriendsList.size();
        }

        return recommendationFriendsList.subList(0, max);
    }
}

class ExceptionProblem7 {
    public static void validateId(String user) {
        enterId(user);
        haveSpace(user);
        validateUserLength(user);
        validateEnglish(user);
        validateSamllLetter(user);
    }

    public static void validateFriends(List<List<String>> friends) {
        validateFriendsListSize(friends);

        for (List<String> friend : friends) {
            for (String id : friend) {
                validateId(id);
            }
        }
    }

    private static void validateUserLength(String user) {
        if (user.length() < 1 || user.length() > 30) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEnglish(String id) {
        if(!Pattern.matches("^[a-zA-Z]*$", id)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSamllLetter(String id) {
        for (char c : id.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void enterId(String id) {
        if (id.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static void haveSpace(String id) {
        if (id.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateFriendsListSize(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateVisitorsListSize(List<String> visitors) {
        if (visitors.size() < 0 || visitors.size() > 10000) {
            throw new IllegalArgumentException();
        }
    }
}
