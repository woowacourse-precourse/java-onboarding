package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        HashMap<String,List<String>> friendsList=new HashMap<>();
        for (List<String> friend : friends) {

            if (friendsList.containsKey(friend.get(0))) {
                friendsList.get(friend.get(0)).add(friend.get(1));
            } else {
                List<String> temp=new ArrayList<String>();
                temp.add(friend.get(1));
                friendsList.put(friend.get(0),temp);
            }

            if (friendsList.containsKey(friend.get(1))) {
                friendsList.get(friend.get(1)).add(friend.get(0));
            } else {
                List<String> temp=new ArrayList<String>();
                temp.add(friend.get(0));
                friendsList.put(friend.get(1),temp);
            }

        }

        HashMap<String,Integer> friendsPoint=new HashMap<>();
        if (friendsList.containsKey(user)) {
            for (String fr : friendsList.get(user)) {
                if (friendsList.containsKey(fr)) {
                    for (String subfr : friendsList.get(fr)) {
                        if (friendsPoint.containsKey(subfr)) {
                            friendsPoint.put(subfr, friendsPoint.get(subfr) + 10);
                        } else {
                            friendsPoint.put(subfr, 10);
                        }
                    }
                }
            }
        }
        for (String visitor : visitors) {
            if (friendsList.containsKey(user) && ! friendsList.get(user).contains(visitor)) {
                if (friendsPoint.containsKey(visitor)) {
                    friendsPoint.put(visitor, friendsPoint.get(visitor) + 1);
                }else {
                    friendsPoint.put(visitor, 1);
                }
            }
        }
        Stream<Map.Entry<String,Integer>> sorted =
                friendsPoint.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue()).thenComparing(Map.Entry.comparingByKey()));
        sorted.forEach(e -> {
            if (!e.getKey().equals(user)) {
                answer.add(e.getKey());
            }
        });
        return answer;
    }

}
