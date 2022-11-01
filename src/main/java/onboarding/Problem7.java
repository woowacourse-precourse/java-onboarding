package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem7 {
    public static Comparator<HashMap.Entry<String, Integer>> comparator = new Comparator<>() {
        @Override
        public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        }
    };

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashMap<String, List<String>> friendMap = new HashMap<>();
        List<String> friendList;
        List<String> friendLists;

        // 친구 관계 hashmap으로 생성
        for (List<String> friend : friends) {
            friendList = new ArrayList<>();
            if (friendMap.containsKey(friend.get(0))) {
                friendList = friendMap.get(friend.get(0));
                friendList.add(friend.get(1));
            } else {
                friendList.add(friend.get(1));
            }
            friendMap.put(friend.get(0), friendList);

            friendList = new ArrayList<>();
            if (friendMap.containsKey(friend.get(1))) {
                friendList = friendMap.get(friend.get(1));
                friendList.add(friend.get(0));
            } else {
                friendList.add(friend.get(0));
            }
            friendMap.put(friend.get(1), friendList);
        }

        // 10점 추가 경우
        friendList = friendMap.get(user);

        for (String friend : friendList) {
            friendLists = friendMap.get(friend);

            for (String friendOfFriend : friendLists) {
                scoreMap.put(friendOfFriend, scoreMap.getOrDefault(friendOfFriend, 0) + 10);
            }
        }

        // 방문자 1점 추가
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }

        // 친구인 경우 삭제
        for (String friend : friendList) {
            scoreMap.remove(friend);
        }

        // 자신 삭제
        if (scoreMap.containsKey(user)) {
            scoreMap.remove(user);
        }

        // 1순위 점수 정렬, 2순위 아이디 정렬
        List<HashMap.Entry<String, Integer>> scoreList = new ArrayList<>(scoreMap.entrySet());
        scoreList.sort(comparator);

        int count = 0;

        for (HashMap.Entry<String, Integer> list : scoreList) {
            answer.add(list.getKey());
            count++;
            if (count == 5) {
                break;
            }
        }

        return answer;
    }
}
