package onboarding;

import java.util.*;

class RecommendFriend implements Comparable<RecommendFriend>{
    public String name;
    public int value;
    RecommendFriend(String name, int value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public int compareTo(RecommendFriend o) {
        if(this.value==o.value) return this.name.compareTo(o.name);
        else return o.value-this.value;
    }
}
public class Problem7 {
    private static List<String> arrange_recommend_list(HashMap<String, Integer> map){
        List<RecommendFriend> tmp = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            int value =  map.get(key);
            tmp.add(new RecommendFriend(key,value));
        }
        Collections.sort(tmp);
        for(RecommendFriend x : tmp){
            ans.add(x.name);
            if(ans.size()>5) break;
        }
        return ans;
    }
    private static HashMap<String, Integer> putCommon(String user, HashMap<String, List<String>> friends_list, HashMap<String, Integer> map){
        List<String> user_friends = friends_list.get(user);
        for(String user_friend : user_friends){
            List<String> user_friend_list = friends_list.get(user_friend);
            for(String user_friend_friend: user_friend_list){
                if(user_friend_friend != user && !user_friends.contains(user_friend_friend)){
                    map.put(user_friend_friend, map.getOrDefault(user_friend_friend, 0)+10);
                }
            }
        }
        return map;
    }
    private static  HashMap<String, Integer> putVisitors(String user, List<String> visitors, HashMap<String, List<String>> friends_list){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> user_friends = friends_list.get(user);
        for (String x : visitors){
            if(!user_friends.contains(x)){
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }

        return map;
    }
    private static HashMap<String, List<String>> arrange_friends_list(List<List<String>> friends){
        HashMap<String, List<String>> friends_list =new HashMap<>();
        for(List<String> link : friends){
            String friendA = link.get(0);
            String friendB = link.get(1);

            List<String> A_friends = friends_list.getOrDefault(friendA, new ArrayList<>());
            List<String> B_friends = friends_list.getOrDefault(friendB, new ArrayList<>());

            A_friends.add(friendB);
            B_friends.add(friendA);

            friends_list.put(friendA,A_friends);
            friends_list.put(friendB,B_friends);

        }
        return friends_list;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> friends_list = arrange_friends_list(friends);
        HashMap<String, Integer> recommendListMap = putVisitors(user,visitors,friends_list);
        recommendListMap = putCommon(user,friends_list, recommendListMap);
        List<String> ans = arrange_recommend_list(recommendListMap);
        return ans;
    }
}
