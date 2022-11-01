package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> IsFriendOf_user (List<List<String>> friends, String user) {
        List<String> friendOf_user = new ArrayList<String>();

        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                friendOf_user.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                friendOf_user.add(friend.get(0));
            }
        }
        return friendOf_user;
    }

    public static void addScore (Map<String, Integer> score, String name, final int SCORE){
        if(!score.containsKey(name)) {
            score.put(name, SCORE);
        }
        else {
            score.put(name, score.get(name) + SCORE);
        }
    }

    public static void plusFriendScore(Map<String, Integer> score,
                                       String User, List<List<String>> friends, List<String> friendOf_user) {
        final int SCORE = 10;
        for (String nameOfFriend : friendOf_user) {
            for (List<String> friend : friends) {
                if (nameOfFriend.equals(friend.get(0))) {
                    addScore(score, friend.get(1), SCORE);
                } else if (friend.equals(friend.get(1))) {
                    addScore(score, friend.get(0), SCORE);
                }
            }
        }
    }
    public static void plusVisitScore(Map<String, Integer> score, List<String> visitors) {
        final int SCORE = 1;
        for (String friend : visitors){
            addScore(score, friend, SCORE);

        }
    }

    public static void removeFriend(Map<String, Integer> score, List<String> friendsOf_user, String user){
        for(String friend : friendsOf_user) {
            if(score.containsKey(friend)) {
                score.remove(friend);
            }
        }
        if(score.containsKey(user)) {
            score.remove(user);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> score = new HashMap<>();


        List<String> friendOf_user = IsFriendOf_user(friends, user);

        plusFriendScore(score, user, friends, friendOf_user);
        plusVisitScore(score, visitors);

        removeFriend(score, friendOf_user, user);

        answer = new ArrayList<>(score.keySet());
        Collections.sort(answer);
        Collections.sort(answer,(f1, f2) -> (score.get(f2).compareTo(score.get(f1))));
        if(answer.size()>5)
            answer = answer.subList(0,5);
        return answer;
    }
}