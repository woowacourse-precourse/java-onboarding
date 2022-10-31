package onboarding;

import java.util.*;

public class Problem7 {

    public static HashMap<String, List<String>> hpFriend;
    public static HashMap<String, Integer> hpScore;

    /**
     * 친구 관계 저장 메서드
     * @param friends 친구 관계 정보
     */
    public static void saveFriend(List<List<String>> friends) {
        for (List<String> o : friends) {
            List<String> friendList1 = hpFriend.getOrDefault(o.get(0), null);
            List<String> friendList2 = hpFriend.getOrDefault(o.get(1), null);

            if (friendList1 == null) {
                friendList1 = new ArrayList<>();
            }

            if (friendList2 == null) {
                friendList2 = new ArrayList<>();
            }

            friendList1.add(o.get(1));
            friendList2.add(o.get(0));
            hpFriend.put(o.get(0), friendList1);
            hpFriend.put(o.get(1), friendList2);

        }
    }

    /**
     * 함께 아는 친구의 수를 세는 메서드
     * @param user1 사용자1
     * @param user2 사용자2
     * @return user1과 user2가 함께 아는 친구의 수
     */
    public static int findFriend(List<String> user1, List<String> user2) {
        int friend = 0;
        for (String name : user1) {
            if(user2.contains(name)) friend++;
        }
        return friend;
    }

    /**
     * 친구 점수 계산 메서드
     * @param user 친구 추천을 받을 사용자
     */
    public static void calcFriend(String user) {
        List<String> userFriend = hpFriend.get(user);
        hpFriend.forEach((o, friends) ->{
            if (user.equals(o)) return;
            int score = findFriend(userFriend, friends) * 10;
            if(score==0) return;
            hpScore.put(o, hpScore.getOrDefault(o, 0)+score);
        });
    }

    /**
     * 방문 점수 계산 메서드
     * @param visitors 방문 기록
     */
    public static void calcVisitor(List<String> visitors) {
        for (String o : visitors) {
            hpScore.put(o, hpScore.getOrDefault(o, 0) + 1);
        }
    }

    /**
     * 친구 확인 메서드
     * @param user1 사용자1
     * @param user2 사용자2
     * @return user1 과 user2 가 이미 친구면 true
     */
    public static boolean isFriend(String user1, String user2) {
        List<String> friendList = hpFriend.get(user1);
        if (friendList != null && friendList.contains(user2)) {
            return true;
        }
        return false;
    }

    /**
     * 친구 추천 메서드
     * @param user 친구 추천을 받을 사용자
     * @return 추천 친구 리스트
     */
    public static List<String> recommendFriend(String user) {
        List<String> result = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hpScore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() == o1.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : entryList) {
            if (result.size()==5) return result;
            if (isFriend(user, entry.getKey())) continue;
            result.add(entry.getKey());
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        hpFriend = new HashMap<>();
        hpScore = new HashMap<>();

        saveFriend(friends);
        calcFriend(user);
        calcVisitor(visitors);

        List<String> answer = recommendFriend(user);
        return answer;
    }
}
