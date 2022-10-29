package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
   static class friend {
        public static HashMap<String, Integer> point = new HashMap<>();
        public static List<String> userFriends = new ArrayList<>();
        public static void setfriend(String user, List<List<String>> friends){
            for (List<String> info : friends){
                if (info.get(0).equals(user)){
                    userFriends.add(info.get(1));
                } else if (info.get(1).equals(user)){
                    userFriends.add(info.get(0));
                }
            }
        }

        public static void setMap (List<List<String>> friends, List<String> visitors){
            for (List<String> info : friends){
                for (String s : info){
                    if (!point.containsKey(s)){
                        point.put(s,0);
                    }
                }
            }

            for (String s: visitors){
                if (!point.containsKey(s)){
                    point.put(s,1);
                } else {
                    point.replace(s,point.get(s)+1);
                }
            }
        }

        public static void setPoint(List<List<String>> friends){
            for (List<String> info : friends){
                if (userFriends.contains(info.get(0))) {
                    point.put(info.get(1), point.get(info.get(1)) + 10);
                } else if (userFriends.contains(info.get(1))){
                    point.put(info.get(0), point.get(info.get(0)) + 10);
                }
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friend.setfriend(user,friends);
        friend.setMap(friends, visitors);
        friend.setPoint(friends);
        HashMap<String, Integer> point = friend.point;
        List<String> userFriend = friend.userFriends;

        List<Entry<String,Integer>> list = new LinkedList<>(point.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                else return e2.getValue().compareTo(e1.getValue());
            }
        });

        for (Entry<String,Integer> tuple : list){
            String key = tuple.getKey();
            if (!userFriend.contains(key) && key != user){
                answer.add(key);
            }
        }
        return answer;
    }
}
