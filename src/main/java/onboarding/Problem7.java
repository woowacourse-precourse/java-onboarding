package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, ArrayList<String>> mutualFriends = new HashMap<>();
        Map<String, Integer> friendAndScore = new HashMap<>();

        ArrayList<String> friend;

        for(List<String> friendInfo : friends){
            if(!mutualFriends.containsKey(friendInfo.get(0)) && !mutualFriends.containsKey(friendInfo.get(1))){
                friend = new ArrayList<>();
                friend.add(friendInfo.get(1));
                mutualFriends.put(friendInfo.get(0), friend);

                friend = new ArrayList<>();
                friend.add(friendInfo.get(0));
                mutualFriends.put(friendInfo.get(1), friend);
            }else if(mutualFriends.containsKey(friendInfo.get(0)) && !mutualFriends.containsKey(friendInfo.get(1))){
                friend = new ArrayList<>();
                friend = mutualFriends.get(friendInfo.get(0));
                friend.add(friendInfo.get(1));
                mutualFriends.put(friendInfo.get(0), friend);

                friend = new ArrayList<>();
                friend.add(friendInfo.get(0));
                mutualFriends.put(friendInfo.get(1), friend);
            }else if(!mutualFriends.containsKey(friendInfo.get(0)) && mutualFriends.containsKey(friendInfo.get(1))){
                friend = new ArrayList<>();
                friend.add(friendInfo.get(1));
                mutualFriends.put(friendInfo.get(0), friend);

                friend = new ArrayList<>();
                friend = mutualFriends.get(friendInfo.get(1));
                friend.add(friendInfo.get(0));
                mutualFriends.put(friendInfo.get(1), friend);
            }else{
                friend = new ArrayList<>();
                friend = mutualFriends.get(friendInfo.get(0));
                friend.add(friendInfo.get(1));
                mutualFriends.put(friendInfo.get(0), friend);

                friend = new ArrayList<>();
                friend = mutualFriends.get(friendInfo.get(1));
                friend.add(friendInfo.get(0));
                mutualFriends.put(friendInfo.get(1), friend);
            }
        }

        for(String s : mutualFriends.get(user)){
            for(String mutual : mutualFriends.get(s)){
                if((user != mutual) && (mutual != s)) {
                    if (!friendAndScore.containsKey(mutual)) {
                        friendAndScore.put(mutual, 10);
                    } else {
                        friendAndScore.put(mutual, friendAndScore.get(mutual) + 10);
                    }
                }
            }

        }

        for(String v : visitors){
            if(!mutualFriends.get(user).contains(v)) {
                if (!friendAndScore.containsKey(v)) {
                    friendAndScore.put(v, 1);
                } else {
                    friendAndScore.put(v, friendAndScore.get(v) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(friendAndScore.entrySet());

        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() > o2.getValue()){
                    return -1;
                }else if(o1.getValue() < o2.getValue()){
                    return 1;
                }else{
                    if(o1.getKey().compareTo(o2.getKey()) < 0){
                        return -1;
                    }else if(o1.getKey().compareTo(o2.getKey()) > 0){
                        return 1;
                    }
                }
                return 0;
            }
        });

        for(Map.Entry<String, Integer> ans : sortedList){
            answer.add(ans.getKey());
        }
        if(answer.size() > 5){
            answer = answer.subList(0, 5);
        }

        return answer;
    }
}
