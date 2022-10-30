package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Hashtable<String, HashSet<String>> friendDict = new Hashtable<>();
        Hashtable<String, Integer> scoreDict = new Hashtable<>();

        for(List<String> friend: friends){
            if (friendDict.get(friend.get(0)) == null){
                friendDict.put(friend.get(0), new HashSet<>(List.of(friend.get(1))));
            }
            else{
                friendDict.get(friend.get(0)).add(friend.get(1));
            }
            if (friendDict.get(friend.get(1)) == null){
                friendDict.put(friend.get(1), new HashSet<>(List.of(friend.get(0))));
            }
            else{
                friendDict.get(friend.get(1)).add(friend.get(0));
            }
        }

        for (String friend: friendDict.get(user)){
            for(String rFriend: friendDict.get(friend)){
                if (user.equals(rFriend)) continue;
                if (scoreDict.containsKey(rFriend))
                    scoreDict.put(rFriend, scoreDict.get(rFriend) + 10);
                else scoreDict.put(rFriend, 10);
            }
        }

        for (String visitor: visitors){
            if (friendDict.get(user).contains(visitor)) continue;
            if (scoreDict.containsKey(visitor)) scoreDict.put(visitor, scoreDict.get(visitor) + 1);
            else scoreDict.put(visitor,1);
        }

        List<String> keySet = new ArrayList<>(scoreDict.keySet());
        Collections.sort(keySet, (val1, val2) -> (scoreDict.get(val2).compareTo(scoreDict.get(val1))));

        return (keySet.size() >= 5)?keySet.subList(0, 6): keySet;
    }
}

