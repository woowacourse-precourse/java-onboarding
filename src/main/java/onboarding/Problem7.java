package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. 사용자 별 친구 리스트 생성
 * 2. user의 친구의 친구 점수 계산하는 Map
 * 3. 방문자 점수 계산하는 Map 생성
 * 4. 추천 친구가 될 수 있는 Map 합치기
 * 5. 정렬 조건에 맞게 정렬 후 최대 5개 반환
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> myFriendList = findMyFriend(user, friends);
        Map<String, Integer> findMyfriendsFriend = findMyFriendsFriend(user, myFriendList, friends);
        Map<String, Integer> findMyVisitors = findMyVisitors(user, myFriendList, visitors);

        Map<String, Integer> friendScoreMap = new HashMap<>();
        friendScoreMap.putAll(findMyVisitors);
        friendScoreMap.putAll(findMyfriendsFriend);

        friendScoreMap = sortByValue(friendScoreMap);

        friendScoreMap = friendScoreMap.entrySet()
                .stream()
                .filter(x->x.getValue() != 0)
                .limit(5)
                .collect(Collectors.toMap(x->x.getKey(), x->x.getValue()));

        return friendScoreMap.keySet().stream().collect(Collectors.toList());
    }

    public static List<String> findMyFriend(String user, List<List<String>> friends) {
        List<String> realFriend = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(1).equals(user)){
                realFriend.add(friends.get(i).get(0));
            }
        }
        return realFriend;
    }

    public static Map<String, Integer> findMyFriendsFriend(String user, List<String> myFriend, List<List<String>> friendsList) {

        HashMap<String, Integer> myFriendsFriend = new HashMap<>();
        for(int i = 0; i < friendsList.size(); i++) {
            int count = 10;
            if (!friendsList.get(i).get(1).equals(user) && myFriend.contains(friendsList.get(i).get(0))) {
                myFriendsFriend.put(friendsList.get(i).get(1), count += 10);
            }
        }
        return myFriendsFriend;
    }

    public static Map<String, Integer> findMyVisitors(String user, List<String> myFriend, List<String> visitors) {
        HashMap<String, Integer> notMyFriendVisitors = new HashMap<>();
        for(int i = 0; i < visitors.size(); i++) {
            int count = 0;
            for (String f : myFriend) {
                if (!visitors.get(i).equals(f)) {
                    notMyFriendVisitors.put(visitors.get(i), count++);
                }
            }
        }
        return notMyFriendVisitors;
    }

    public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm){
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
