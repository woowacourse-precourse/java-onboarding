package onboarding;

import java.util.*;

public class Problem7 {

    public static HashMap<String, HashSet<String>> friendList = new HashMap<>();
    public static HashMap<String, Integer> vistorList = new HashMap<>();
    public static HashMap<String, Integer> scoreboard = new HashMap<>();

    private static List<String> getRecommendedFriends(String user) {
        calculateScore(user);
        List<String> friends = new ArrayList<>(scoreboard.keySet());
        Collections.sort(friends, (value1, value2) -> (scoreboard.get(value2).compareTo(scoreboard.get(value1))));
        return friends;
    }

    private static void calculateScore(String user) {
        List<String> userFriends = new ArrayList<>(friendList.get(user));

        for (int i = 0; i < userFriends.size(); i++) {
            String userFriend = userFriends.get(i);
            List<String> acquaintance = new ArrayList<>(friendList.get(userFriend));
            for (int j = 0; j < acquaintance.size(); j++) {
                String name = acquaintance.get(i);
                int score = 0;
                if(scoreboard.containsKey(name)) {
                    score = scoreboard.get(name);
                }
                scoreboard.put(name, score + 10);
            }
        }

        List<String> vistors = new ArrayList<>(vistorList.keySet());
        for (int i = 0; i < vistors.size(); i++) {
            String name = vistors.get(i);
            int score = 0;
            if(scoreboard.containsKey(name)) {
                score = scoreboard.get(name);
            }
            scoreboard.put(name, score + 1);
        }
    }

    private static void setFriendList(List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String user1 = friends.get(i).get(0);
            String user2 = friends.get(i).get(1);
            HashSet<String> user1List = new HashSet<>();
            HashSet<String> user2List = new HashSet<>();
            if(friendList.containsKey(user1)) {
                user1List = friendList.get(user1);
            }
            if(friendList.containsKey(user2)) {
                user2List = friendList.get(user2);
            }
            user1List.add(user2);
            user2List.add(user1);
            friendList.put(user1, user1List);
            friendList.put(user2, user2List);
        }
    }

    private static void setVistorList(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            int count = 0;
            if(vistorList.containsKey(name)) {
                count = vistorList.get(name);
            }
            vistorList.put(name, ++count);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setFriendList(friends);
        setVistorList(visitors);
        List<String> answer = getRecommendedFriends(user);
        return answer;
    }
}
