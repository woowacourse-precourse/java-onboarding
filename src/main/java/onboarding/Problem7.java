package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 기능 구현 목록
 * 1. user의 친구 목록 뽑기
 * 2. user 친구의 친구들을 뽑기. -> 키-값의 형태로 저장하기 위해 해시맵에 저장.
 * 3. 친구의 친구 순회 하면서 score 합산
 * 4. visitors 중 친구가 아닌 사람들만 스코어에 넣기
 * 5. score 순서대로 정렬. 점수가 같다면 이름순으로 정렬
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> nonFriends = new HashMap<>();

        // user의 친구 목록 추가
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).get(0).equals(user)){
                userFriends.add(friends.get(i).get(0));
            } else if (friends.get(i).get(1).equals(user)){
                userFriends.add(friends.get(i).get(1));
            }
        }

        return answer;
    }
}
