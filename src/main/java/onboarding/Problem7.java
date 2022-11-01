package onboarding;

import org.mockito.internal.util.collections.ListUtil;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    static Map<String, List<String>> friendsDic(List<List<String>> friends){
        Map<String, List<String>> map = new HashMap<>();
        List<String> emptyList = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if(!map.containsKey(friends.get(i).get(0))){
                map.put(friends.get(i).get(0), emptyList);
            } /*else {
                List<String> friendsList = map.get(friends.get(i).get(0));
                if(!map.containsKey(friends.get(i).get(1))) {
                    friendsList.add(friends.get(i).get(1));
                    map.put(friends.get(i).get(0), friendsList);
                }
            }*/
            if(!map.containsKey(friends.get(i).get(1))){
                map.put(friends.get(i).get(1), emptyList);
            } /*else {
                friendsList = map.get(friends.get(i).get(1));
                if(!map.containsKey(friends.get(i).get(0))) {
                    friendsList.add(friends.get(i).get(0));
                    map.put(friends.get(i).get(1), friendsList);
                }
            }*/
        }
        for(int i=0; i<friends.size(); i++){
            String name1 = friends.get(i).get(0);
            List<String> friendsList1 = new ArrayList<>(map.get(name1));
            String name2 = friends.get(i).get(1);
            List<String> friendsList2 = new ArrayList<>(map.get(name2));
            if(!friendsList1.contains(name2)){
                friendsList1.add(name2);
                map.put(name1, friendsList1);
            }
            if(!friendsList2.contains(name1)){
                friendsList2.add(name1);
                map.put(name2, friendsList2);
            }
        }
        return map;
    }
    static Map<String, Integer> pointDic(List<List<String>> friends, List<String> visitors){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.size(); i++){
            if(!map.containsKey(friends.get(i).get(0))){
                map.put(friends.get(i).get(0), 0);
            }
            if(!map.containsKey(friends.get(i).get(1))){
                map.put(friends.get(i).get(1), 0);
            }
        }
        for(int i=0; i<visitors.size(); i++){
            if(!map.containsKey(visitors.get(i))){
                map.put(visitors.get(i), 0);
            }
        }
        return map;
    }
    static Map<String, Integer> compareFriends(String user, Map<String, List<String>> friendsMap, Map<String, Integer> pointMap){
        List<String> userFriends = new ArrayList<>();
        userFriends.addAll(friendsMap.get(user));
        for(String i : friendsMap.keySet()){
            if((i != user) && (!userFriends.contains(i))){
                List<String> friendsList = new ArrayList<>();
                friendsList.addAll(friendsMap.get(i));
                for(int j=0; j<friendsList.size(); j++){
                    if(userFriends.contains(friendsList.get(j))){
                        int point = pointMap.get(i);
                        point += 10;
                        pointMap.put(i, point);
                    }
                }
            }
        }
        return pointMap;
    }
    static Map<String, Integer> checkVisit(List<String> visitors, Map<String, Integer> pointMap){
        for(int i=0; i<visitors.size(); i++){
            int point = pointMap.get(visitors.get(i));
            point += 1;
            pointMap.put(visitors.get(i), point);
        }
        return pointMap;
    }
    static List<String> sortedArray(String user, Map<String, List<String>> friendsMap, Map<String, Integer> pointMap) {
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(pointMap.entrySet());
        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                // 오름 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        List<String> sortList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : list_entries) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(value > 0){
                sortList.add(key);
            }
        }
        for(int i=0; i<sortList.size(); i++) {
            if (sortList.get(i) == user) {
                sortList.remove(i);
            }
        }
        for(int i=sortList.size()-1; i>0; i--){
            List<String> userFriends = friendsMap.get(user);
            if(userFriends.contains(sortList.get(i))){
                sortList.remove(i);
            }
        }
        return sortList;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = new HashMap<>(friendsDic(friends));
        Map<String, Integer> pointMap = new HashMap<>(pointDic(friends, visitors));
        pointMap = compareFriends(user, friendsMap, pointMap);
        pointMap = checkVisit(visitors, pointMap);

        List<String> answer = sortedArray(user, friendsMap, pointMap);

        return answer;
    }
}
