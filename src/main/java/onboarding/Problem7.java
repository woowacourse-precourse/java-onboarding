package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = new ArrayList<>();

        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friend_a = friend.get(0);
            String friend_b = friend.get(1);

            List<String> tmpListA = new ArrayList<>();
            if(friendsMap.get(friend_a) != null) tmpListA = friendsMap.get(friend_a);
            tmpListA.add(friend_b);
            friendsMap.put(friend_a, tmpListA);

            List<String> tmpListB = new ArrayList<>();
            if(friendsMap.get(friend_b) != null) tmpListB = friendsMap.get(friend_b);
            tmpListB.add(friend_a);
            friendsMap.put(friend_b, tmpListB);
        }

        for (String name : friendsMap.get(user)) {
            for (String nearFriend : friendsMap.get(name)) {
                int score = 0;

                if(nearFriend==user) {
                    continue;
                }
                if(friendsMap.get(user).contains(nearFriend)) {
                    continue;
                }

                if(scoreMap.get(nearFriend) != null) {
                    score = scoreMap.get(nearFriend);
                }
                scoreMap.put(nearFriend, score+10);
            }
        }

        for (String visitor : visitors) {
            int score = 0;
            if(visitor==user) {
                continue;
            }
            if(friendsMap.get(user).contains(visitor)) {
                continue;
            }

            if(scoreMap.get(visitor) != null) {
                score = scoreMap.get(visitor);
            }
            scoreMap.put(visitor, score+1);
        }

        List<String> answer = new ArrayList<>(scoreMap.keySet());
        answer.sort((nameA, nameB) ->  {
            if(scoreMap.get(nameA).equals(scoreMap.get(nameB))){
                return nameA.compareTo(nameB);
            } else {
                return scoreMap.get(nameB) - scoreMap.get(nameA);
            }
        });
        if(answer.size()>5) answer = answer.subList(0,5);
        return answer;
    }
}