package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String,Integer> map = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> user_friend = new HashSet<>();
        user_friend = findFriends(user,friends);
        checkFriends(user,friends, (HashSet<String>) user_friend);
        checkIsVisited(visitors, (HashSet<String>) user_friend);
        sortMaps(map,answer);
        return answer;
    }
    static void sortMaps(Map<String,Integer>map,List<String> answer) {
        int count = 0;
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            count += 1;
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
            answer.add(entry.getKey());
            if(count == 5){break;}
        }
    }
    static void checkIsVisited(List<String> visitors,HashSet<String> user_friend){
        for(String info : visitors){
            if(map.get(info) == null && !user_friend.contains(info)){map.put(info,1);}
            else if(map.get(info) != null && !user_friend.contains(info)){map.put(info,map.get(info)+1);}
        }
    }
    static void checkFriends(String host,List<List<String>> friends,HashSet<String> user_friend){
        for(List<String> info : friends){
            if(user_friend.contains(info.get(0)) && info.get(1) != host){
                if(map.get(info.get(1)) == null){map.put(info.get(1),10);}
                else{map.put(info.get(1),map.get(info.get(1))+10);}}
            if(user_friend.contains(info.get(1))&& info.get(0) != host){
                if(map.get(info.get(0)) == null){map.put(info.get(0),10);}
                else{map.put(info.get(0),map.get(info.get(0))+10);}}
        }
    }
    static HashSet<String> findFriends(String host,List<List<String>> friends){
        Set<String> friend_info = new HashSet<>();
        for(List<String> info : friends){
            if(info.get(0).equals(host)){friend_info.add(info.get(1));}
            if(info.get(1).equals(host)){friend_info.add(info.get(0));}
        }
        return (HashSet<String>) friend_info;
    }
}