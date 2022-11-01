package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.groupingBy;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        return validation(user, friends, visitors)
                ? List.of()
                : recommendation(user, friends, visitors);
    }

    private static boolean validation(String user, List<List<String>> friends, List<String> visitors) {
        if (userValidation(user))
            return true;
        else if (friendsValidation(friends))
            return true;
        else return visitorsValidation(visitors);
    }

    private static boolean userValidation(String user) {
        return user.length() < 1 || user.length() > 30 || isNotLowerCaseAlphabet(user);
    }

    private static boolean friendsValidation(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000)
            return true;

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            if (friendA.length() < 1 || friendA.length() > 30 || friendB.length() < 1 || friendB.length() > 30)
                return true;
            if (isNotLowerCaseAlphabet(friendA) || isNotLowerCaseAlphabet(friendB))
                return true;
        }
        return false;
    }

    private static boolean visitorsValidation(List<String> visitors) {
        for (String visitor : visitors) {
            if (isNotLowerCaseAlphabet(visitor))
                return true;
        }
        return false;
    }

    private static boolean isNotLowerCaseAlphabet (String id) {
        return id.matches("^[^a-z]+$");
    }

    private static List<String> recommendation(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> visitorsScoreTmp = visitorsToScore(visitors);
        List<String> friendsList = friendsList(user, friends);
        Map<String, Integer> friendsScoreTmp = friendsToScore(user, friends, friendsList);

        visitorsScoreTmp.forEach((key, value) -> friendsScoreTmp.merge(key, value, Integer::sum));
        friendsList.forEach(friendsScoreTmp::remove);

        List<String> recommendList = new ArrayList<>();
        friendsScoreTmp.entrySet().stream()
                .sorted(comparingByValue(reverseOrder()))
                .forEachOrdered(x -> recommendList.add(x.getKey()));
        return recommendList;
    }

    private static Map<String, Integer> visitorsToScore(List<String> visitors) {
        Map<String, List<String>> visitorsTmp = visitors.stream()
                .collect(groupingBy(visitor -> visitor));
        Map<String, Integer> visitorsScore = new HashMap<>();
        for (String s : visitorsTmp.keySet()) {
            visitorsScore.put(s, visitorsTmp.get(s).size());
        }
        return visitorsScore;
    }

    private static List<String> friendsList(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user))
                userFriend.add(friend.get(1));
            if (friend.get(1).equals(user))
                userFriend.add(friend.get(0));
        }
        return userFriend;
    }

    private static Map<String, Integer> friendsToScore(String user ,List<List<String>> friends, List<String> userFriend) {
        Map<String, Integer> friendsScore = new HashMap<>();
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            for (String userFriendTmp : userFriend) {
                if (friendA.equals(userFriendTmp) && !friendsScore.containsKey(friendB) && !friendB.equals(user))
                    friendsScore.put(friendB, 10);
                else if (friendA.equals(userFriendTmp) && friendsScore.containsKey(friendB) && !friendB.equals(user))
                    friendsScore.put(friendB, friendsScore.get(friendB) + 10);
                if (friendB.equals(userFriendTmp) && !friendsScore.containsKey(friendA) && !friendA.equals(user))
                    friendsScore.put(friendA, 10);
                else if (friendB.equals(userFriendTmp) && friendsScore.containsKey(friendA) && !friendA.equals(user))
                    friendsScore.put(friendA, friendsScore.get(friendA) + 10);
            }
        }
        return friendsScore;
    }
}
