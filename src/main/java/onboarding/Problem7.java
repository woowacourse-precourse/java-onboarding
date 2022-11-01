package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Map.*;
import java.util.*;

public class Problem7 {
    public static void sortScore(List<Entry<String, Integer>> sort){
        sort.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });
    }
    public static void recommend(List<String> answer, List<Entry<String, Integer>> sort,
                                       List<String> userFriends) {
        for (Entry<String, Integer> entry : sort) {
            if (answer.size() == 5) {
                break;
            }
            if (entry.getValue() > 0 && !userFriends.contains(entry.getKey())) {
                answer.add(entry.getKey());
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        Map<String, Integer> friendScore = new HashMap<>();

        for(List<String> friend : friends){
            if(friend.get(0)==user || friend.get(1)==user){
                userFriends.add(friend.get(0)==user?friend.get(1):friend.get(0));
            }
        }
        for(List<String> friend: friends){
            if(userFriends.contains(friend.get(0)) || userFriends.contains(friend.get(1))){
                int i = userFriends.contains(friend.get(0)) ? 1 : 0;
                if(friend.get(i) != user)
                    friendScore.put(friend.get(i),friendScore.getOrDefault(friend.get(i),10)+10);
            }
        }
        for(String visitor : visitors){
            friendScore.put(visitor,friendScore.getOrDefault(visitor,0)+1);
        }

        List<Entry<String, Integer>> sort = new ArrayList<>(friendScore.entrySet());
        sortScore(sort);
        recommend(answer, sort, userFriends);
        return answer;
    }
}
