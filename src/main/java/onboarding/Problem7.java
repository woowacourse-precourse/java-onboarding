package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /*
            old_friends : 현재 친구들
            new_friends : 새로 추가된 친구들
         */
        int user_length = user.length();
        int friends_length = friends.size();
        int visitors_length = visitors.size();
        if(user_length < 1 || user_length > 30) System.exit(1);
        if(friends_length < 1 || friends_length > 10000) System.exit(1);

        HashSet<String> old_friends = new HashSet<>();
        HashMap<String, Integer> new_friends = new HashMap<>();

        for (int i = 0; i < friends_length; i++) {
            for (int j = 0; j < 2; j++) {
                String Me = friends.get(i).get(j);
                int friend_length= Me.length();
                if (friend_length < 1 || friend_length > 30) {
                    break;
                }
                if (Me == user) {
                    old_friends.add(friends.get(i).get(1 - j));
                }
            }
        }
        for(String x : old_friends){
            for (int i = 0; i < friends_length; i++) {
                for (int j = 0; j < 2; j++) {
                    String new_friend = friends.get(i).get(1-j);
                    if (x == friends.get(i).get(j) && new_friend != user) {
                        if(!new_friends.containsKey(new_friend)) new_friends.put(friends.get(i).get(1 - j),0);
                            new_friends.put(new_friend, new_friends.get(new_friend) + 10);
                    }
                }
            }
        }
        if(visitors_length < 0 || visitors_length > 10000) System.exit(1);

        for (String x : visitors) {
            if(!old_friends.contains(x)){
                if (!new_friends.containsKey(x)) new_friends.put(x, 0);
                new_friends.put(x, new_friends.get(x) + 1);
            }
        }
        List<String> keys = new ArrayList<>(new_friends.keySet());
        Collections.sort(keys, (v2, v1) -> (new_friends.get(v1).compareTo(new_friends.get(v2))));
        List<String> answer = new ArrayList<>();
        for (String key : keys) {
            answer.add(key);
        }
        return answer;
    }
}
