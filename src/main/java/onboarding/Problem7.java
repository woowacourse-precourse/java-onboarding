/*
 * 클래스명: Problem7
 *
 * 시작 날짜: 2022-10-31
 */


package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = visitorsCount(visitors); //방문한 사람 점수 추가
        List<String> friendList = followedFriends(user, friends); //이미 user와 친구인 사람들 리스트
        Map<String, Integer> newMap = newFriend(friends,friendList,map); //친구의 친구 점수 추가
        List<String> sortedList = sortByValues(newMap); //점수, 사전 순으로 정렬
        List<String> answer = commendList(user, sortedList, friendList); //이미 친구인 사람들이 아니고 자신이 아닌 사람들 리스트

        return answer;
    }

    public static Map<String, Integer> visitorsCount(List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String visitor : visitors) {
            plusPoints(visitor, map, 1);
        }
        return map;
    }

    public static List<String> followedFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);

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
        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);
            //A는 유저와 친구, B는 친구가 아니라면
            if (friendList.contains(idA) && !friendList.contains(idB)) {
                plusPoints(idB, map, 10);
            }
            //B는 유저와 친구, A는 친구가 아니라면
            if (friendList.contains(idB) && !friendList.contains(idA)) {
                plusPoints(idA, map, 10);
            }
        }
        return map;
    }

    public static void plusPoints(String id, Map<String, Integer> map, int point) {
        if (map.containsKey(id)) {
            map.put(id, map.get(id) + point);
        } else {
            map.put(id, point);
        }
    }

    public static List<String> sortByValues(Map<String, Integer> map) {
        List<String> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList);
        sortedList.sort((value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        return sortedList;
    }

    public static List<String> commendList(String user, List<String> sortedList, List<String> friendList) {
        List<String> result = new ArrayList<>();
        int friendsNumber = 0;
        for (String friend : sortedList) {
            if (!friendList.contains(friend) && !user.equals(friend)) {
                result.add(friend);
                friendsNumber += 1;
            }
            if (friendsNumber == 5) {
                return result;
            }
        }
        return result;
    }
}
