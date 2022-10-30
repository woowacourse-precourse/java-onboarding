package onboarding;

import java.util.*;

public class Problem7 {
    public static TreeMap<String, Integer>  getVisitorScore(TreeMap<String, Integer> map, List<String> visitors, List<String> directFriends){
        for (int i=0; i<visitors.size();i++){
            if (!directFriends.contains(visitors.get(i))){
                if (map.containsKey(visitors.get(i)) == true){
                    map.put(visitors.get(0), map.get(visitors.get(i))+1);
                }else{
                    map.put(visitors.get(i),1);
                }
            }
        }
        return map;
    }

    public static List<String> getSorted(TreeMap<String, Integer> map){
        List<String> answer = new ArrayList<>();
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((((o1, o2) -> map.get(o2.getKey())-map.get(o1.getKey()))));
        for(Map.Entry<String, Integer> entry:entryList){
            answer.add(entry.getKey());
        }
        return answer;
    }
    public static List<String> getDirect(String user, List<List<String>> friends, List<String> visitors){
        ArrayList<String> directFriends = new ArrayList<>();
        for(int i=0; i<friends.size();i++){
            List friend = friends.get(i);
            if(friend.contains(user)){
                for (Object f:friend){
                    if (f!=user){
                        directFriends.add(String.valueOf(f));
                    }
                }
            };
        }
        return directFriends;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        TreeMap<String, Integer> map = new TreeMap<>();

        // get Score from friends
        // user's direct friend.
        List<String> directFriends = getDirect(user, friends, visitors);
        // direct friends 안에서 loop을 돌려서 getDirect를 한다. 이때 user에 들어가게 된다.
        for (int i=0; i<directFriends.size();i++){
            List<String> friendFriend = getDirect(directFriends.get(i),friends,visitors);
            for (int j=0; j<friendFriend.size();j++){
                String friendFriendInfo = friendFriend.get(i);
                map.put(friendFriendInfo, getDirect(friendFriendInfo,friends,visitors).size()*10);
            }
        }

        // get score from visitors
        map = getVisitorScore(map, visitors, directFriends);

        // sort
        List<String> answer = getSorted(map);

        return answer;
    }
}
