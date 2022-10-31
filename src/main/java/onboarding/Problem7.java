package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    static class Friend implements Comparable<Friend> {
        String name;
        int score;

        public Friend(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Friend o) {
            if (this.score == o.score)
                return this.name.compareTo(o.name);
            return o.score - this.score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, List<String>> friendMap = new HashMap<>();

        for (List<String> list : friends) {
            makeFriendMap(friendMap, list);
        }

        List<String> friendsOfUser = friendMap.get(user);
        HashMap<String, Integer> friendScoreMap = new HashMap<>();

        for (String friend : friendMap.keySet()) {
            if (friend.equals(user) || friendsOfUser.contains(friend))
                continue;

            List<String> friendsOfFriend = friendMap.get(friend);
            makeFriendScoreMap(friendsOfUser, friend, friendsOfFriend, friendScoreMap);
        }

        for (String name : visitors) {
            if (!friendsOfUser.contains(name))
                friendScoreMap.put(name, friendScoreMap.getOrDefault(name, 0) + 1);
        }

        List<Friend> friendScoreList = new ArrayList<>();
        for (String name : friendScoreMap.keySet()) {
            friendScoreList.add(new Friend(name, friendScoreMap.get(name)));
        }

        findMaxFiveFriends(friendScoreList, answer);

        return answer;
    }

    public static void makeFriendMap(HashMap<String, List<String>> friendMap, List<String> list) {
        String a = list.get(0);
        String b = list.get(1);

        if (friendMap.containsKey(a)) {
            friendMap.get(a).add(b);
        }
        else {
            List<String> newList = new ArrayList<>();
            newList.add(b);
            friendMap.put(a, newList);
        }

        if (friendMap.containsKey(b)) {
            friendMap.get(b).add(a);
        }
        else {
            List<String> newList = new ArrayList<>();
            newList.add(a);
            friendMap.put(b, newList);
        }
    }

    private static void makeFriendScoreMap(List<String> friendsOfUser, String friend, List<String> friendsOfFriend, HashMap<String, Integer> friendScoreMap) {
        int score = getScore(friendsOfUser, friendsOfFriend);

        if (score > 0)
            friendScoreMap.put(friend, score);
    }

    public static int getScore(List<String> friendsOfUser, List<String> friendsOfFriend) {
        int cnt = 0;

        for (String name : friendsOfUser) {
            if (friendsOfFriend.contains(name))
                cnt++;
        }

        return cnt * 10;
    }

    public static void findMaxFiveFriends(List<Friend> friendScoreList, List<String> answer) {
        Collections.sort(friendScoreList);

        for (int i = 0; i < friendScoreList.size(); i++) {
            if (i == 5) break;

            answer.add(friendScoreList.get(i).name);
        }
    }
}
