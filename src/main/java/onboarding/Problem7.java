package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> nearFriends = new ArrayList<>();
        Map<String, Integer> recommendScore = new HashMap<>();

        if (user.length() < 1 || user.length() > 30)
            return answer;
        if (friends.size() < 1 || friends.size() > 10_000)
            return answer;
        if (visitors.size() > 10_000)
            return answer;

        // 1. 내 친구 찾기.
        List<String> myFriends = findMyFriends(user, friends);
        // 2. 내 친구와 아는(=함께 아는 친구) 찾기.
        for (String friend : myFriends) {
            nearFriends.addAll(findMyFriends(user, friends, friend));
        }
        // 3. 함께 아는 친구에 대한 점수 부여.(리스트의 중복을 이용하기)
        for (String nearFriend : nearFriends) {
            if (recommendScore.containsKey(nearFriend))
                recommendScore.put(nearFriend, recommendScore.get(nearFriend) + 10);
            else
                recommendScore.put(nearFriend, 10);

        }
        // 4. 방문자에게 점수 부여하기. (이미 등록된 내 친구들는 제외)
        for (String visitor : visitors) {
            if (myFriends.contains(visitor))
                continue;

            if (recommendScore.containsKey(visitor))
                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
            else
                recommendScore.put(visitor, 1);
        }

        // 5. 점수별로 정렬하기
        List<Map.Entry<String, Integer>> recommendScoreList = new LinkedList<>(recommendScore.entrySet());
        recommendScoreList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> recommendPerson : recommendScoreList) {
            if (answer.size() < 5)
                answer.add(recommendPerson.getKey());
        }

        // 6. 5명까지만 자르기.
        return answer;
    }

    /**
     * 파라미터가 두개라면, 내 친구 찾기.
     * @param user 사용자의 이름
     * @param friends 모든 사람의 친구 관계 리스트
     * @return friends 중에서 내 친구들만 선택된 리스트
     */
    public static List<String> findMyFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if (friend1.equals(user))
                myFriends.add(friend2);
            if (friend2.equals(user))
                myFriends.add(friend1);
        }
        return myFriends;
    }

    /**
     * 파라미터가 3개라면 함께 아는 친구 찾기.
     * @param user 사용자의 이름
     * @param friends 모든 사람의 친구 관계
     * @param myFriendName 내 친구들의 이름 리스트
     * @return (내 친구와) 함께 아는 사람 리스트
     */
    public static List<String> findMyFriends(String user, List<List<String>> friends, String myFriendName) {
        List<String> myFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if (friend1.equals(myFriendName)) {
                if (!friend2.equals(user))
                    myFriends.add(friend2);
            }
            if (friend2.equals(myFriendName)) {
                if (!friend1.equals(user))
                    myFriends.add(friend1);
            }
        }
        return myFriends;
    }
}
