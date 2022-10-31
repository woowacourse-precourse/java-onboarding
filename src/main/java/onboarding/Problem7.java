package onboarding;

import java.util.*;

public class Problem7 {

    public static int INTERSECTION_FRIEND_SCORE = 10;
    public static int VISITOR_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        Set<String> friendList = new HashSet<>();
        HashMap<String, Integer> friendScoreList = new HashMap<>();

        findFriend(user, friends, friendList);
        getScoreInFriend(user, friends, friendList, friendScoreList);
        getScoreInVisitors(user, visitors, friendList, friendScoreList);

        if (friendScoreList.isEmpty() == true) {
            return Collections.emptyList();
        }

        answer = sortDescValueAscKey(new ArrayList<>(friendScoreList.keySet()), friendScoreList);

        if (answer.size() > 5) {
            answer = answer.subList(0, 5);
        }

        return answer;
    }

    public static void findFriend(String user, List<List<String>> friends, Set<String> friendList) {
        for (List<String> friendData : friends) {
            if (user.equals(friendData.get(0)) == true) {
                friendList.add(friendData.get(1));
            }
            if (user.equals(friendData.get(1)) == true) {
                friendList.add(friendData.get(0));
            }
        }
    }

    public static void getScoreInFriend(String user, List<List<String>> friends, Set<String> friendList, HashMap<String, Integer> friendScoreList) {
        for (List<String> friendData : friends) {
            if (user.equals(friendData.get(1)) == false && friendList.contains(friendData.get(0)) == true && friendList.contains(friendData.get(1)) == false) {
                addScore(friendScoreList, friendData.get(1), INTERSECTION_FRIEND_SCORE);
            }
            if (user.equals(friendData.get(0)) == false && friendList.contains(friendData.get(1)) == true && friendList.contains(friendData.get(0)) == false) {
                addScore(friendScoreList, friendData.get(0), INTERSECTION_FRIEND_SCORE);
            }
        }
    }

    public static void getScoreInVisitors(String user, List<String> visitors, Set<String> friendList, HashMap<String, Integer> friendScoreList) {
        for (String visitor : visitors) {
            if (visitor.equals(user) == false && friendList.contains(visitor) == false) {
                addScore(friendScoreList, visitor, VISITOR_SCORE);
            }
        }
    }

    public static List<String> sortDescValueAscKey(List<String> sortList, HashMap<String, Integer> friendScoreList) {
        Collections.sort(sortList, (o1, o2) -> {
            if (friendScoreList.get(o1) != friendScoreList.get(o2)) {
                return friendScoreList.get(o2).compareTo(friendScoreList.get(o1));
            } else {
                return o1.compareTo(o2);
            }
        });

        return sortList;
    }

    public static void addScore(HashMap<String, Integer> friendScoreList, String key, int addNumber) {
        if (friendScoreList.containsKey(key) == false) {
            friendScoreList.put(key, addNumber);
            return;
        }
        friendScoreList.put(key, friendScoreList.get(key) + addNumber);
    }
}
