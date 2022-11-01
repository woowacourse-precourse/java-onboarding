package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        HashMap<String, Integer> scoreMap = new HashMap<>();

        List<String> oldFriendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user))
                oldFriendList.add(friend.get(1));
            else if (friend.get(1).equals(user)) {
                oldFriendList.add(friend.get(0));
            }
        }

        for (List<String> friend : friends) {
            if (!friend.contains(user)) {
                for (String s : oldFriendList) {
                    if (friend.get(0).equals(s)) {
                        if (!scoreMap.containsKey(friend.get(1)))
                            scoreMap.put(friend.get(1), 10);
                        else
                            scoreMap.put(friend.get(1), scoreMap.get(friend.get(1)) + 10);
                    } else if (friend.get(1).equals(s)) {
                        if (!scoreMap.containsKey(friend.get(0)))
                            scoreMap.put(friend.get(0), 10);
                        else
                            scoreMap.put(friend.get(0), scoreMap.get(friend.get(0)) + 10);
                    }
                }
            }
        }

        for (String visitor : visitors
        ) {
            if (!oldFriendList.contains(visitor)) {
                if (!scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, 1);
                } else
                    scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            }
        }

        List<Map.Entry<String,Integer>> list = new LinkedList<>(scoreMap.entrySet());
        list.sort((l1, l2) -> l2.getValue().compareTo(l1.getValue()));

        for(int i=0; i< list.size(); i++){
            if(i>=5)
                break;
            answer.add(list.get(i).getKey());
        }

        return answer;
    }
}
