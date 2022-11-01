package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 1. 사용자 별 친구 리스트 생성
 * 2. user의 친구의 친구 점수 계산하는 Map
 * 3. 방문자 점수 계산하는 Map 생성
 * 4. 추천 친구가 될 수 있는 Map 합치기 5.
 * 정렬 조건에 맞게 정렬 후 최대 5개 반환
 */
public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {

        List<String> myFriendList = findMyFriend(user, friends);
        Map<String, Integer> findMyfriendsFriend = findMyFriendsFriend(user, myFriendList, friends);
        Map<String, Integer> findMyVisitors = findMyVisitors(myFriendList, visitors);

        Map<String, Integer> friendScoreMap = new HashMap<>();
        friendScoreMap.putAll(findMyVisitors);
        friendScoreMap.putAll(findMyfriendsFriend);

        friendScoreMap = sortByValue(friendScoreMap);

        friendScoreMap = friendScoreMap.entrySet()
            .stream()
            .filter(x -> x.getValue() != 0)
            .limit(5)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        return new ArrayList<>(friendScoreMap.keySet());
    }

    public static List<String> findMyFriend(String user, List<List<String>> friends) {
        List<String> realFriend = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(1).equals(user)) {
                realFriend.add(friend.get(0));
            }
        }
        return realFriend;
    }

    public static Map<String, Integer> findMyFriendsFriend(String user, List<String> myFriend,
        List<List<String>> friendsList) {

        HashMap<String, Integer> myFriendsFriend = new HashMap<>();
        for (List<String> strings : friendsList) {
            int count = 10;
            if (!strings.get(1).equals(user) && myFriend.contains(
                strings.get(0))) {
                myFriendsFriend.put(strings.get(1), count + 10);
            }
        }
        return myFriendsFriend;
    }

    public static Map<String, Integer> findMyVisitors(List<String> myFriend,
        List<String> visitors) {
        HashMap<String, Integer> notMyFriendVisitors = new HashMap<>();
        for (String visitor : visitors) {
            int count = 0;
            for (String f : myFriend) {
                if (!visitor.equals(f)) {
                    notMyFriendVisitors.put(visitor, count++);
                }
            }
        }
        return notMyFriendVisitors;
    }

    public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list =
            new LinkedList<>(hm.entrySet());

        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
