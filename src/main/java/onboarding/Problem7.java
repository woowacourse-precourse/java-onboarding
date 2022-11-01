package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    private static final Integer FRIEND_SCORE = 10;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> findMyFriends(String user, List<List<String>> AllFriends) {
        List<String> myFriends = new ArrayList<>();
        // 전체 친구들 중에 user의 친구 찾기
        AllFriends.forEach(friend -> {
            if (user.equals(friend.get(1))) {
                myFriends.add(friend.get(0));
            }
        });
        return myFriends;
    }

    private static HashMap<String, Integer> getScoreByFriends(String user, List<String> myFriends, List<List<String>> AllFriends) {
        HashMap<String, Integer> ranking = new HashMap<>();
        if (myFriends.isEmpty()) {
            return ranking;
        }
        AllFriends.forEach(friend -> {
            String name = friend.get(1);
            String friendName = friend.get(0);
            // name의 친구가 나의 친구와 친구 관계이고, name이 내가 아닐 때
            if (myFriends.contains(friendName) && !name.equals(user)) {
                // 추천 랭킹에 이미 이름이 있으면
                if (ranking.containsKey(name)) {
                    // 함께아는 친구 점수 추가
                    ranking.put(name, ranking.get(name) + FRIEND_SCORE);
                } else if(!ranking.containsKey(name)) {
                    // 그렇지 않으면 name에게 친구 추천 점수를 주고 랭킹에 등록
                    ranking.put(name, FRIEND_SCORE);
                }
            }
        });
        return ranking;
    }

}
