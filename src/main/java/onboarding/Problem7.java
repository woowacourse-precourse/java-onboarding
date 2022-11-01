package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> friendList = new HashMap<>();
        Map<String,Integer> result = new HashMap<>();
        for (List<String> friend : friends) {
            if(friendList.containsKey(friend.get(0))){
                List<String> lists = new ArrayList<>(friendList.get(friend.get(0)));
                if (!lists.contains(friend.get(1))){
                    lists.add(friend.get(1));
                    friendList.put(friend.get(0), lists);
                }
            }
            else{
                String[] strings = {friend.get(1)};
                friendList.put(friend.get(0),Arrays.asList(strings));
            }

            if (friendList.containsKey(friend.get(1))) {
                List<String> lists = new ArrayList<>(friendList.get(friend.get(1)));
                if (!lists.contains(friend.get(0))){
                    lists.add(friend.get(0));
                    friendList.put(friend.get(1), lists);
                }
            }
            else{
                String[] strings = {friend.get(0)};
                friendList.put(friend.get(1),Arrays.asList(strings));
            }
        }


        return answer;
    }

}
