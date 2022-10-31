package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> realFriends = new ArrayList<>();
        List<String> frOfFriends = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();

        for(List<String> friend : friends){
            for(int i=0; i<2; i++){
                if(friend.get(i) == user)
                    realFriends.add(friend.get(1-i));
            }
        }

        for(String realFriend : realFriends){
            for(List<String> friend : friends){
                for(int i=0; i<2; i++){
                    if(friend.get(i) == realFriend) {
                        if(friend.get(1-i) != user)
                            frOfFriends.add(friend.get(1 - i));
                    }
                }
            }
        }

        for(String frOfFriend : frOfFriends){
            if(score.containsKey(frOfFriend))
                score.put(frOfFriend, score.get(frOfFriend) +10);
            else
                score.put(frOfFriend,10);
        }

        for(String visitor : visitors){
            if(realFriends.contains(visitor)) continue;

            if(score.containsKey(visitor))
                score.put(visitor, score.get(visitor) +1);
            else
                score.put(visitor,1);
        }

        List<Map.Entry<String, Integer>> scoreList = new LinkedList<>(score.entrySet());
        scoreList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int i=0;
        for(Map.Entry<String, Integer> scoreHigh : scoreList){
            if(i<5) {
                answer.add(scoreHigh.getKey());
                i++;
            }
        }
        return answer;
    }
}
