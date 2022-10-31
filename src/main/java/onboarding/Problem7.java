package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static HashMap<String, ArrayList<String>> createFriendsMap(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> friendsList = new HashMap<>();
        for (List<String> friend : friends) {
            for (int i = 0; i < 2; i++) {
                if (!friendsList.containsKey(friend.get(i))) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(friend.get((i + 1) % 2));
                    friendsList.put(friend.get(i), list);
                } else {
                    friendsList.get(friend.get(i)).add(friend.get((i + 1) % 2));
                }
            }
        }
        return friendsList;
    }

    public static HashMap<String, Integer> createNotDupFriendsMap(String user, HashMap<String, ArrayList<String>> friendsMap) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String friend : friendsMap.get(user)) {
            for (String friendOfFriend : friendsMap.get(friend)) {
                if (user.equals(friendOfFriend) || friendsMap.get(user).contains(friendOfFriend)) {
                    continue;
                }
                if (!result.containsKey(friendOfFriend)) {
                    result.put(friendOfFriend, 1);
                } else {
                    result.put(friendOfFriend, result.get(friendOfFriend) + 1);
                }
            }
        }
        return result;
    }

    public static HashMap<String, Integer> friendPoint(HashMap<String, Integer> notDupFriendsMap, HashMap<String, Integer> totalPoint) {
        for (Map.Entry<String, Integer> friend : notDupFriendsMap.entrySet()) {
            totalPoint.put(friend.getKey(), friend.getValue() * 10);
        }

        return totalPoint;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> totalPoint = new HashMap<>();
        // 1. 친구 목록 생성
        HashMap<String, ArrayList<String>> friendsMap = createFriendsMap(friends);
        HashMap<String, Integer> notDupFriendsMap = createNotDupFriendsMap(user, friendsMap);
        // 2. 친구의 친구의 경우 10점 증가
        HashMap<String, Integer> friendPoint = friendPoint(notDupFriendsMap, totalPoint);
        // 3. 타임라인 방문의 경우 1점 증가
        // 4. 점수로 정렬(점수 동일한 경우 이름순) 후 5명 출력

        return null;
    }
}
