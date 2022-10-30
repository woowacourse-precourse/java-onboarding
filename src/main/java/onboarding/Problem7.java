package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        List<String> user_friends = new ArrayList<>();
        Map<String, Integer> score_map = new HashMap<>();
        for(List <String> friend : friends){
            String id_A = friend.get(0);
            String id_B = friend.get(1);
            if(Objects.equals(id_A, user)){
                user_friends.add(id_B);
            }
            if(Objects.equals(id_B, user)){
                user_friends.add(id_A);
            }
            ArrayList<String> aList = map.getOrDefault(id_A, new ArrayList<>());
            aList.add(id_B);
            ArrayList<String> bList = map.getOrDefault(id_B, new ArrayList<>());
            bList.add(id_A);
            map.put(id_A, aList);
            map.put(id_B, bList);
        }
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            String cur_user = entry.getKey();
            if(user_friends.contains(cur_user) || cur_user == user) continue;
            ArrayList<String> cur_user_friends = entry.getValue();
            int friend_score = 0;
            int visit_score = Collections.frequency(visitors, cur_user);
            for(String cur_user_friend : cur_user_friends){
                if(user_friends.contains(cur_user_friend)) friend_score += 10;
            }
            score_map.put(cur_user, friend_score + visit_score);
        }
        List<String> distinct_visitors = visitors.stream().distinct().collect(Collectors.toList());
        for(String distinct_visitor : distinct_visitors){
            if(!user_friends.contains(distinct_visitor) && !score_map.containsKey(distinct_visitor)){
                int visit_score = Collections.frequency(visitors, distinct_visitor);
                score_map.put(distinct_visitor, visit_score);
            }
        }
        List<Map.Entry<String, Integer>> entry_list = new LinkedList<>(score_map.entrySet());
        entry_list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(Objects.equals(o2.getValue(), o1.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                }
                else{
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        int recommend_size = Math.min(entry_list.size(), 5);
        for(int i = 0; i < recommend_size; i++){
            answer.add(entry_list.get(i).getKey());
        }
        return answer;
    }
}
