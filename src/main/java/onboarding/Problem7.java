package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> hasPoint = new ArrayList<>();
        List<String> myFriend = new ArrayList<>();
        Map<String, Integer> pointMap = new HashMap<>();
        for (List<String> friend : friends) {
            if(friend.get(1).equals(user)) {
                myFriend.add(friend.get(0));
            }
        }

        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);
            if(!friend.contains(user)) {
                if(myFriend.contains(b) && !myFriend.contains(a)) {
                    pointMap.put(a, pointMap.getOrDefault(b, 0) + 10);
                } else if(myFriend.contains(a) && !myFriend.contains(b)) {
                    pointMap.put(b, pointMap.getOrDefault(a, 0) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if(!myFriend.contains(visitor)) {
                pointMap.put(visitor, pointMap.getOrDefault(visitor, 0) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(pointMap.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(pointMap.get(o1).equals(pointMap.get(o2))) {
                    return o1.compareTo(o2);
                }
                return pointMap.get(o2).compareTo(pointMap.get(o1));
            }
        });

        for(int i = 0; i < keySet.size(); i++) {
            if(i > 4) {
                break;
            }
            answer.add(keySet.get(i));
        }
        return answer;
    }
}
