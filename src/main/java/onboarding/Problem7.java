package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriends = getMyFriends(user, friends);
        List<String> friendOfFriends = getMyFriends(myFriends, friends);

        Map<String, Integer> scoreboard = getScoreboard(friendOfFriends, visitors);
        exceptFriend(scoreboard, user, myFriends);
        List<String> answer = recommendedFriends(scoreboard);
        return answer;
    }

    static List<String> getMyFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                myFriends.addAll(friend);
                myFriends.remove(user);
            }
        }
        return myFriends;
    }

    static List<String> getMyFriends(List<String> users, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (String user : users) {
            myFriends.addAll(getMyFriends(user, friends));
        }

        return myFriends;
    }

    static Map<String, Integer> getScoreboard(List<String> friendOfFriends, List<String> visitors) {
        Map<String, Integer> scoreboard = new TreeMap<>();
        for (String friendOfFriend : friendOfFriends) {
            scoreboard.put(friendOfFriend, scoreboard.getOrDefault(friendOfFriend, 0) + 10);
        }
        for (String visitor : visitors) {
            scoreboard.put(visitor, scoreboard.getOrDefault(visitor, 0) + 1);
        }
        return scoreboard;
    }

    static Map<String, Integer> exceptFriend(Map<String, Integer> scoreboard, String user, List<String> myFriends) {
        myFriends.add(user);
        for (String myFriend : myFriends) {
            if (scoreboard.containsKey(myFriend)) {
                scoreboard.remove(myFriend);
            }
        }
        return scoreboard;
    }

    static List<String> recommendedFriends(Map<String, Integer> scoreboard) {
        List<String> recommendedList = new ArrayList<>();
        String temp = "";
        while (recommendedList.size() < 6 && !scoreboard.isEmpty()) {
            int maxScore = Collections.max(scoreboard.values());
            for (Map.Entry<String, Integer> entry : scoreboard.entrySet()) {
                if (maxScore == entry.getValue()) {
                    temp = entry.getKey();
                    break;
                }
            }
            recommendedList.add(temp);
            scoreboard.remove(temp);
        }

        return recommendedList;
    }
}
