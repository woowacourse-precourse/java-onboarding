package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * 1. user의 친구들 구하기
 * 2. 추천 점수 계산
 * 3. 방문자 점수 계산
 * 4. 점수 높은순으로 정렬 및 5명 반환
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashSet<String> userFriend = new HashSet<>();
        HashMap<String, Integer> friendOfFriendMap = new HashMap<>();

        //user의 친구들 구하기
        for (List<String> friendList : friends) {
            if(friendList.contains(user)){
                userFriend.add(friendList.get(0));
                userFriend.add(friendList.get(1));
            }
        }
        //자기 자신 제거
        userFriend.remove(user);

        return answer;
    }
}
