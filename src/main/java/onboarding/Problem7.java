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
        List<String> newmap = sortByValues(newMap);

        System.out.println(newmap);
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

    public static List<String> sortByValues(Map<String, Integer> map) {
        List<String> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        return sortedList;
    }
}
