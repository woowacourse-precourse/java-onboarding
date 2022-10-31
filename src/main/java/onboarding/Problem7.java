package onboarding;

import java.util.*;

public class Problem7 {

    Map<String, Integer> user_score = new HashMap<>();
    Map<String, List<String>> user_friends = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<String> answer = Collections.emptyList();
        // TODO solution 내에 객체를 생성해야 하는 구조 비효율적. 다른 아키텍처 고민해 refactoring 하기.
        Problem7 problem7 = new Problem7();
        List<String> answer = problem7.returnResult(user, friends, visitors);
        return answer;
    }

    List<String> returnResult(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();
        // TODO 내부 로직을 중복해 사용해서 오히려 헷갈림. 메소드 구조 고민한 후 refactoring.
        setVisitorScore(visitors);
        setFriendScore(user, friends);
        // 이미 친구인 사람 목록에서 빼기 로직 추가
        List<String> user_friends_list = user_friends.get(user);
        for (String friend : user_friends_list) {
            user_score.remove(friend);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(user_score.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int i = 0;
        // looping이 entryList 범위를 넘어가는 경우 제한
        while (i < 5 & i < entryList.size()) {
            int score = entryList.get(i).getValue();
            if (score <= 0) {
                break;
            }
            result.add(entryList.get(i).getKey());
            i += 1;
        }
        return result;
    }


    void setVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            user_score.put(visitor, user_score.getOrDefault(visitor, 0) + 1);
        }
    }

    void setFriendScore(String user, List<List<String>> friends) {
        setUserFriends(friends);
        List<String> friend_list = user_friends.get(user);
        for (String friend : friend_list) {
            List<String> cross_friend_list = user_friends.get(friend);
            for (String cross_friend : cross_friend_list) {
                if (cross_friend.equals(user)) {
                    continue;
                }
                user_score.put(cross_friend, user_score.getOrDefault(cross_friend, 0) + 10);
            }
        }
    }

    void setUserFriends(List<List<String>> friends) {
        for (List<String> friend_list : friends) {
            for (int i = 0; i <= 1; i++) {
                String friend1 = friend_list.get(i);
                String friend2 = friend_list.get(1 - i);
                List<String> array = new ArrayList<>();
                List<String> friend1_friend_list = user_friends.getOrDefault(friend1, array);
                friend1_friend_list.add(friend2);
                user_friends.put(friend1, friend1_friend_list);
            }
        }
    }
}
