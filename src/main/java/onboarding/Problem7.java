/*
 * 클래스명: Problem7
 *
 * 시작 날짜: 2022-10-31
 */


package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> map = visitorsCount(visitors); //방문한 사람 추가
        List<String> friendList = followedFriends(user, friends);
        Map<String, Integer> newMap = newFriend(friends,friendList,map);
        newMap = sortByValue(newMap);
        // System.out.println(newMap);
        return answer;
    }

    public static Map<String, Integer> visitorsCount(List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if (map.get(visitor) == null) {
                map.put(visitor, 1);
                continue;
            }
            map.put(visitor, map.get(visitor) + 1);
        }
        return map;
    }

    public static List<String> followedFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            String idA = new String(friends.get(i).get(0));
            String idB = new String(friends.get(i).get(1));

            //자신과 자신은 친구일까
            if (user.equals(idA)) {
                friendList.add(idB);
            }
            if (user.equals(idB)) {
                friendList.add(idA);
            }
        }
        return friendList;
    }

    public static Map<String, Integer> newFriend(List<List<String>> friends, List<String> friendList, Map<String, Integer> map) {
        for (int i = 0; i < friends.size(); i++) {
            String idA = new String(friends.get(i).get(0));
            String idB = new String(friends.get(i).get(1));
            //A는 유저와 친구, B는 친구가 아니라면
            if (friendList.contains(idA) && !friendList.contains(idB)) {
                map = plusTenPoints(idB, map);
            }
            //B는 유저와 친구, A는 친구가 아니라면
            if (friendList.contains(idB) && !friendList.contains(idA)) {
                map = plusTenPoints(idA, map);
            }
        }
        return map;
    }

    public static Map<String, Integer> plusTenPoints(String id, Map<String, Integer> map) {
        if (map.containsKey(id)) {
            map.put(id, map.get(id) + 10);
        } else {
            map.put(id, 10);
        }
        return map;
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> hashMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
