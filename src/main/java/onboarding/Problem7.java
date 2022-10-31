package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, ArrayList<String>> friend_link = new HashMap<>();

        for(List<String> friend : friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            ArrayList<String> list1 = friend_link.getOrDefault(friend1, new ArrayList<>());
            list1.add(friend2);
            friend_link.put(friend1, list1);

            ArrayList<String> list2 = friend_link.getOrDefault(friend2, new ArrayList<>());
            list2.add(friend1);
            friend_link.put(friend2, list2);
        }

        Map<String, Integer> friends_score = new HashMap<>();
        ArrayList<String> user_friends = friend_link.get(user);
        for(String user_friend : user_friends){
            ArrayList<String> share_friends = friend_link.get(user_friend);
            for(String share_friend : share_friends){
                if((!share_friend.equals(user)) && (!friend_link.get(user).contains(share_friend))){
                    friends_score.put(share_friend, friends_score.getOrDefault(share_friend, 0) + 10);
                }
            }
        }

        for(String visitor : visitors){
            if(!friend_link.get(user).contains(visitor))
                friends_score.put(visitor, friends_score.getOrDefault(visitor, 0) + 1);
        }

        return answer;
    }
}
