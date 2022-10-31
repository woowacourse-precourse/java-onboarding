package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> userMap = new HashMap<>();
        HashMap<String, List<String>> friendMap = new HashMap<>();

        for(int i=0;i<friends.size();i++){
            String leftFriend = friends.get(i).get(0);
            String rightFriend = friends.get(i).get(1);

            userMap.put(leftFriend, 0);
            userMap.put(rightFriend, 0);

            friendMap.put(leftFriend, friendMap.containsKey(leftFriend) ? Stream.of(friendMap.get(leftFriend), List.of(rightFriend)).flatMap(x->x.stream()).collect(
                Collectors.toList()) : List.of(rightFriend));
            friendMap.put(rightFriend, friendMap.containsKey(rightFriend) ? Stream.of(friendMap.get(rightFriend),List.of(leftFriend)).flatMap(x->x.stream()).collect(
                Collectors.toList()) : List.of(leftFriend));
        }

        for(int i=0;i<visitors.size();i++){
            String visitor = visitors.get(i);
            userMap.put(visitor, userMap.containsKey(visitor) ? userMap.get(visitor) + 1 : 1);
        }

        Iterator<Map.Entry<String, Integer>> it = userMap.entrySet().iterator();

        while (it.hasNext()) {
            Entry<String, Integer> next = it.next();
            String friend = next.getKey();
            Integer point = next.getValue();

            List<String> friendList = friendMap.get(friend);
            if(friendList!=null) {
                for (int i = 0; i < friendList.size(); i++) {
                    String commonFriend = friendList.get(i);
                    List<String> commonFriendList = friendMap.get(commonFriend);
                    if(commonFriendList.contains(user)) userMap.put(friend, point+10);
                }
            }
        }

        List<Entry<String, Integer>> resultList = new ArrayList<>(userMap.entrySet());
        Collections.sort(resultList, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        Iterator<Map.Entry<String, Integer>> result = resultList.iterator();

        int cnt=0;
        while (result.hasNext()) {
            Entry<String, Integer> next = result.next();
            String friend = next.getKey();
            Integer point = next.getValue();
            if(point!=0 && friend!=user && cnt<5 && !friendMap.get(user).contains(friend)) {
                answer.add(friend);
                cnt++;
            }
        }

        return answer;
    }
}
