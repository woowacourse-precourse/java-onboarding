package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* 기능 목록
 * user의 친구 목록 반환 기능 구현
 * user의 친구의 친구 관계 반환 기능 구현
 * user의 친구의 친구와 방문자의 친구 추천 규칙에 따라 점수 부여
 * 점수 순으로 정렬 기능 구현
 * */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * user의 친구 목록을 반환합니다.
     *
     * @param user    친구 목록을 반환할 대상 사용자
     * @param friends 친구 관계 목록
     * @return user의 친구 목록을 반환
     */
    List<String> getMyFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        myFriends.add(user);

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                String myFriend;
                if (friend.get(0).equals(user)) {
                    myFriend = friend.get(1);
                } else {
                    myFriend = friend.get(0);
                }
                myFriends.add(myFriend);
            }
        }

        return myFriends;
    }

    /**
     * 친구의 친구 목록을 반환합니다.
     *
     * @param userFriends user의 친구 리스트
     * @param friends     친구 관계 목록
     * @return 친구의 친구 목록 반환
     */
    List<String> getSubFriends(List<String> userFriends, List<List<String>> friends) {
        List<String> subFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (userFriends.contains(friend.get(0)) && !userFriends.contains(friend.get(1))) {
                subFriends.add(friend.get(1));
            } else if (userFriends.contains(friend.get(1)) && !userFriends.contains(friend.get(0))) {
                subFriends.add(friend.get(0));
            }
        }

        return subFriends;
    }

    /**
     * 추천 사용자 이름과 점수 쌍들을 반환합니다.
     *
     * @param subFriends 친구의 친구 리스트
     * @param visitors   방문자 리스트
     * @return 추천 사용자의 이름과 점수 쌍들 반환
     */
    HashMap<String, Integer> getRecommends(List<String> myFriends, List<String> subFriends, List<String> visitors) {
        HashMap<String, Integer> recommends = new HashMap<>();

        for (String friend : subFriends) {
            if (recommends.containsKey(friend)) {
                recommends.put(friend, recommends.get(friend) + 10);
            } else {
                recommends.put(friend, 10);
            }
        }

        for (String visitor : visitors) {
            if (myFriends.contains(visitor)) {
                continue;
            }

            if (recommends.containsKey(visitor)) {
                recommends.put(visitor, recommends.get(visitor) + 1);
            } else {
                recommends.put(visitor, 1);
            }
        }

        return recommends;
    }
}
