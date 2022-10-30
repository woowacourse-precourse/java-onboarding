package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 전체 사용자의 친구 관계를 정의할 Map을 선언한다.
        // key 값으로 사용자의 아이디, value 값으로 리스트로 해당 사용자의 친구 리스트가 들어간다.
        Map<String, List<String>> friendMap = new HashMap<>();

        // 점수 정보를 관리할 Map을 선언한다.
        // key 값으로 사용자의 아이디, value 값으로 점수가 들어간다.
        Map<String, Integer> scoreMap = new HashMap<>();

        // 전체 사용자에 대한 친구 관계를 정의한다.
        for(List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            // 만약 처음 삽입된다면 초기화 작업을 진행해준다.
            List<String> friendListOfUserA = friendMap.getOrDefault(userA, new ArrayList<>());
            // 친구 정보를 추가한다.
            friendListOfUserA.add(userB);

            List<String> friendListOfUserB = friendMap.getOrDefault(userB, new ArrayList<>());
            friendListOfUserB.add(userA);

            // 친구 관계 Map에 추가한다.
            friendMap.put(userA, friendListOfUserA);
            friendMap.put(userB, friendListOfUserB);
        }

        return answer;
    }
}
