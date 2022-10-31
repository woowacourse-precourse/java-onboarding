package onboarding;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Problem7 {
    /**
     [기능목록]
     1. 친구 관계 정보에서 이미 친구인 경우 제거하기
     2. 타임 라인 방문 기록에서 이미 친구인 경우 제거하기
     3. 사용자와 함께 아는 친구인 경우 해쉬맵에 10점 추가하기
     4. 사용자의 타임 라인에 방문한 경우 해쉬맵에 1점 추가하기
     5. 점수가 가장 높은 순으로 정렬하고 추천 점수가 같은 경우 이름순으로 정렬하기
     6. 최대 5명만 추천하고, 추천 점수가 0점인 경우 추천하지 않게 처리하기
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friends = new CopyOnWriteArrayList<>(friends);
        visitors = new CopyOnWriteArrayList<>(visitors);
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 친구 관계 정보에서 이미 친구인 경우 제거하기
        for(List<String> list : friends) {
            if(list.get(0).equals(user)) { // 친구리스트 중 0번째 이름이 사용자 이름일 경우
                userFriends.add(list.get(1)); // 1번째 이름을 사용자 친구 리스트에 저장 (0번째는 사용자 이름이므로)
                friends.remove(list); // 함께 아는 친구의 수를 고려할 때 필요 없는 리스트이므로 삭제
            } else if(list.get(1).equals(user)) { // 친구리스트 중 1번째 이름이 사용자 이름인 경우
                userFriends.add(list.get(0)); // 0번째 이름을 사용자 친구 리스트에 저장 (1번째는 사용자 이름이므로)
                friends.remove(list); // 함께 아는 친구의 수를 고려할 때 필요 없는 리스트이므로 삭제
            }
        }

        return answer;
    }
}
