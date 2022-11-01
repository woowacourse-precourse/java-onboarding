package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = new ArrayList<>();

        /**
         * user - friends
         * friends - friends(+10)
         * visitoris(+1)
         */

        HashSet<String> friend = new HashSet<>();
        Map<String, Integer> togetherKnowFriend = new HashMap<>();

        // 친구 찾기
        for (List<String> list : friends) {
            String friendA = list.get(0);
            String friendB = list.get(1);
            if (friendA.equals(user)) {
                friend.add(friendB);
            }
            if (friendB.equals(user)) {
                friend.add(friendA);
            }
        }

        // 친구의 친구 점수 계산
        for (List<String> list : friends) {
            String friendA = list.get(0);
            String friendB = list.get(1);

            if (friend.contains(friendA) && !friendB.equals(user)) {
                togetherKnowFriend.put(friendB,
                    togetherKnowFriend.getOrDefault(friendB, 0) + 10);
            }
            if (friend.contains(friendB) && !friendB.equals(user)) {
                togetherKnowFriend.put(friendA,
                    togetherKnowFriend.getOrDefault(friendA, 0) + 10);
            }

        }

        //방문자 점수 계산
        for (String visitor : visitors) {
            if (!friend.contains(visitor)) {
                togetherKnowFriend.put(visitor,
                    togetherKnowFriend.getOrDefault(visitor, 0) + 1);
            }
        }

        // 정렬

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(
            togetherKnowFriend.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (Objects.equals(o1.getValue(), o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }

                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            answer.add(entry.getKey());
        }

        return answer;
    }
}
