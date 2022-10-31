package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, Integer> scores; // 점수 저장
    static Map<String, List<String>> currentFriends; // 모든 친구 관계 저장 (User - User의 친구들)

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        answer = findCloseFriends(user, friends, visitors);

        return answer;
    }

    /**
     * DESCRIPTION
     *   방문기록, 친구관계 등 User의 전체적인 친구 점수를 계산한 후 상위 5명을 뽑아내는 기능
     *
     * Params
     *   user - 추천 친구 찾기 기능을 적용해야하는 user
     *   friends - 현재 SNS 상에 등록된 모든 친구관계(친구-친구)가 적힌 list
     *   visitors - user의 SNS를 방문한 친구들의 이름이 적힌 list
     *
     * RETURN
     *   닉네임 조건을 통과하지 못한 유저들의, 오름차순으로 정리된 이메일 list
     */
    public static List<String> findCloseFriends(String user, List<List<String>> friends, List<String> visitors){
        scores = new HashMap<>();
        currentFriends = new HashMap<>();

        scoreBySameFriend(user, friends); // 겹치는 친구를 기준으로 점수를 세는 기능
        scoreByVisitHistory(user, visitors); // 방문 기록을 기준으로 점수를 세는 기능

        return null;
    }

    /**
     * DESCRIPTION
     *   user와 같은 친구를 가지고 있으면 겹치는 친구 한 명당 10점을 부여한 점수를 저장하는 기능
     *
     * Params
     *   user - 추천 친구 찾기 기능을 적용해야하는 user
     *   friends - 현재 SNS 상에 등록된 모든 친구관계(친구-친구)가 적힌 list
     *
     * RETURN
     *   없음
     */
    public static void scoreBySameFriend(String user, List<List<String>> friends){
        for(List<String> form : friends){

            String UserA = form.get(0);
            String UserB = form.get(1);

            List<String> friendList; // 각 sns user가 가지는 친구목록

            // A가 B를 친구 추가
            friendList = currentFriends.getOrDefault(UserA, new ArrayList<>());
            friendList.add(UserB);
            currentFriends.put(UserA, friendList);

            // B가 A를 친구 추가
            friendList = currentFriends.getOrDefault(UserB, new ArrayList<>());
            friendList.add(UserA);
            currentFriends.put(UserB, friendList);
        }

        List<String> userFriends = currentFriends.get(user); // 추천친구를 원하는 user의 친구목록
        Set<String> anotherUser = currentFriends.keySet(); // 추천친구를 원하는 user를 제외한 나머지 sns user들

        for(String another : anotherUser){

            // 조건 1. 이미 친구이면 카운팅 안함
            // 조건 2. 본인이면 카운팅 안함
            if(userFriends.contains(another) || another.equals(user))
                continue;

            List<String> friendList = currentFriends.get(another);
            int cnt = 0;

            for(String sameFriend : userFriends){ //user와 anotherUser의 친구목록 비교
                if(friendList.contains(sameFriend))
                    cnt++;
            }

            scores.put(another, scores.getOrDefault(another, 0) + cnt*10);
        }
    }

    /**
     * DESCRIPTION
     *   user의 SNS 방문 기록 1번당 1점을 부여한 점수를 저장하는 기능
     *
     * Params
     *   user - 추천 친구 찾기 기능을 적용해야하는 user
     *   visitors - user의 SNS를 방문한 친구들의 이름이 적힌 list
     *
     * RETURN
     *   없음
     */
    public static void scoreByVisitHistory(String user, List<String> visitors){
        for(String visitor : visitors) {
            if(!currentFriends.get(user).contains(visitor)) // 이미 친구이면 카운팅 안함
                scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }
}