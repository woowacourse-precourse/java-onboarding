package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> alreadyFriends = new ArrayList<>();
        List<ScoreList> scoreLists = new ArrayList<>();
        HashMap<String, Integer> candidates = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String leftFriend = friends.get(i).get(0);
            String rightFriend = friends.get(i).get(1);
            if (leftFriend.equals(user))
                alreadyFriends.add(rightFriend);
            else if (rightFriend.equals(user))
                alreadyFriends.add(leftFriend);
            candidates.put(leftFriend, 0);
            candidates.put(rightFriend, 0);
        }
        for (int i = 0; i < friends.size(); i++) {
            String leftFriend = friends.get(i).get(0);
            String rightFriend = friends.get(i).get(1);
            int tmp = 0;
            if (alreadyFriends.contains(leftFriend)) {
                if (!rightFriend.equals(user)) {
                    tmp = candidates.get(rightFriend);
                    candidates.put(rightFriend, tmp + 10);
                }
            }
            if (alreadyFriends.contains(rightFriend)) {
                if (!leftFriend.equals(user)) {
                    tmp = candidates.get(leftFriend);
                    candidates.put(leftFriend, tmp + 10);
                }
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            int tmp = 0;
            if (candidates.containsKey(visitor))
                tmp = candidates.get(visitor);
            candidates.put(visitor, tmp + 1);
        }
        for (int i = 0; i < alreadyFriends.size(); i++) {
            String alreadyFriend = alreadyFriends.get(i);
            if (candidates.containsKey(alreadyFriend))
                candidates.remove(alreadyFriend);
        }
        candidates.remove(user);


        return answer;
    }
    public static class ScoreList {
        String name;
        private Integer score;
        public ScoreList(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
        public String getName() {
            return name;
        }
        public Integer getScore() {
            return score;
        }
    }

}
