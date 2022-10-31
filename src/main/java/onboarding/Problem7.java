package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
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

        Map<Integer, List<String>> friends_ordered_by_score = new TreeMap<>(Comparator.reverseOrder());
        for(String friend : friends_score.keySet()){
            int score = friends_score.get(friend);
            if(!friends_ordered_by_score.containsKey(score)){
                friends_ordered_by_score.put(score, new ArrayList<>());
            }
            friends_ordered_by_score.get(score).add(friend);
        }

        List<String> answer = new ArrayList<>();
        for(int same_score_friends : friends_ordered_by_score.keySet()){
            List<String> same_score_friends_list = friends_ordered_by_score.get(same_score_friends);
            Collections.sort(same_score_friends_list);
            for(String string : same_score_friends_list){
                if(answer.size() >= 5)
                    break;
                answer.add(string);
            }
        }

        return answer;
    }
}
