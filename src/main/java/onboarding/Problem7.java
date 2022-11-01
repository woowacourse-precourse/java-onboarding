package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userList = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();
        HashMap<String, List<String>> friendList = new HashMap<>();
        userList.add(user);
        score.put(user, 0);
        for(List<String> friend : friends) {
            String a = friend.get(0), b = friend.get(1);
            if(!userList.contains(a)) {
                userList.add(a);
                score.put(a, 0);
            }
            if(!userList.contains(b)) {
                userList.add(b);
                score.put(b, 0);
            }
            if(friendList.containsKey(a)) friendList.get(a).add(b);
            else {
                List<String> newList = new ArrayList<>();
                newList.add(b);
                friendList.put(a, newList);
            }
            if(friendList.containsKey(b)) friendList.get(b).add(a);
            else {
                List<String> newList = new ArrayList<>();
                newList.add(a);
                friendList.put(b, newList);
            }
        }

        List<String> userFriendList = friendList.get(user);
        for(String friend : userList) {
            if(friend.compareTo(user) == 0 || userFriendList.contains(friend)) continue;
            for(String ffriend : friendList.get(friend)) {
                if(userFriendList.contains(ffriend)) score.put(friend, score.get(friend) + 10);
            }
        }
        for(String visitor : visitors) {
            if(userFriendList.contains(visitor)) continue;
            if(score.containsKey(visitor)) score.put(visitor, score.get(visitor) + 1);
            else score.put(visitor, 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(score.entrySet());
        list.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) return o1.getKey().compareTo(o2.getKey());
            return o2.getValue() - o1.getValue();
        });
        for(Map.Entry<String, Integer> entry : list) {
            if(answer.size() == 5 || entry.getValue() == 0) break;
            answer.add(entry.getKey());
        }
        return answer;
    }
}
