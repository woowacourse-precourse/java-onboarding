package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
* 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드 완성
* - 점수 계산 방법: 친구의 친구인 경우마다 10점, 본인 타임라인 방문한 경우마다 1점씩 더한다.
* */
public class Problem7 {

    // 추가될 점수를 전역변수로 선언
    static final int SCORE_FRIEND = 10; // 친구의 친구
    static final int SCORE_VISITOR = 1; // 타임라인 방문

    /*
    * 설명: 기능#3(기능1을 실행한 결과로 기능2를 실행시키고, 자기 자신과 이미 친구인 유저를 제외하고, 아이디별 점수를 비교해 친구 추천 대상 선별)
    * 입력:
    *   1. String: 친구 추천받을 유저id
    *   2. List<List<String>>: 친구 관계 정보
    *   3. List<String>: 사용자 타임 라인 방문 기록
    * 결과: List<String> (친구 추천 목록)
    * */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 동작1. 유저id마다 점수를 기록할 Map<String, Integer>를 생성한다.
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();

        // 동작2. 메소드#1을 통해 친구의 친구 리스트 Map을 받아서 친구의 친구 리스트에 대해 메소드#2(친구 추천 점수를 계산)를 실행한다.
        Map<String, List<String>> friendMap = makeFriendListMap(friends);
        for(String id : friendMap.get(user)) {
            addScore(friendMap.get(id), scoreMap,SCORE_FRIEND);
        }
        // 동작3. 사용자 타임 라인 방문 기록을 토대로 메소드#2(친구 추천 점수를 계산)을 실행한다.
        addScore(visitors, scoreMap,SCORE_VISITOR);

        // 동작4. 점수판에 친구 추천받을 유저와 그 유저와 이미 친구인 아이디를 제거한다.
        if(scoreMap.containsKey(user))
            scoreMap.remove(user);
        for(String id : friendMap.get(user)){
            if(scoreMap.containsKey(id))
                scoreMap.remove(id);
        }

        // 동작5. 점수의 오름차순으로 정렬해서, 최대 5명을 앞에서부터 뽑는다.
        return scoreMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    /*
    * 설명: 기능2(리스트에 아이디가 있으면 그 아이디에 특정 점수를 추가)
    *   1. `친구의 친구 리스트`이 경우에는 `10점`
    *   2. `사용자 타임 라인 방문 기록 리스트`인 경우에는 `1점`
    * 입력:
    *   1. List<String>: 유저id 리스트 (친구 목록 리스트, 사용자 타임 라인 방문 기록 리스트)
    *   2. Map<String, int>: 유저id별 점수 목록
    *   3. int: 발견되는 아이디에 추가할 점수
    * 결과: void (반환 없음)
    * */
    public static void addScore(List<String> list, Map<String, Integer> scoreMap, int score) {
        // 동작1. 리스트에 있는 유저id마다 반복
        for(String id : list) {
            // 동작1.2. Map에 유저id에 따른 점수판이 없는 경우에는, 점수판을 추가하고 해당되는 점수를 기입한다.
            if(!scoreMap.containsKey(id)) {
                scoreMap.put(id, score);
                continue;
            }
            // 동작1.1. Map에 담긴 유저id의 점수에 해당되는 추가점수를 부여한다.
            scoreMap.replace(id, scoreMap.get(id) + score);
        }
    }

    /*
    * 설명: 기능1(List<List<String>>의 친구 관계를 토대로 각 아이디별 친구 리스트 생성)
    * 입력: List<List<String>> : 친구 관계 정보
    * 결과: Map<String, List<String>> : (유저id, 해당 유저의 친구 목록)이 담긴 Map
    * */
    public static Map<String, List<String>> makeFriendListMap(List<List<String>> friends) {
        // 동작1. 각 유저id의 친구 목록을 관리할 Map<String, List<String>>을 만든다.
        Map<String, List<String>> friendListMap = new HashMap<String, List<String>>();

        // 동작2. 친구 관계 정보를 토대로 각 유저id의 친구목록을 추가한다.
        for(List<String> relation : friends) {
            String user1 = relation.get(0), user2 = relation.get(1);

            // 동작2.1. 친구 관계인 유저1과 유저2를 받아서 동일 인물인 경우에는 다음 관계로 넘어간다.
            if(user1.equals(user2))
                continue;

            // 동작2.3. Map에 해당 유저의 친구목록 자체가 없는 경우에는 (해당 유저id, 친구 목록 객체)를 저장해준다.
            if(!friendListMap.containsKey(user1)) {
                friendListMap.put(user1, new ArrayList<String>());
            }
            if(!friendListMap.containsKey(user2)) {
                friendListMap.put(user2, new ArrayList<String>());
            }

            // 동작2.2. Map에 저장된 유저1의 친구목록에 유저2를 넣고, 유저2의 친구목록에 유저1에 넣는다.
            friendListMap.get(user1).add(user2);
            friendListMap.get(user2).add(user1);
        }
        // 동작3. Map<String, List<String>>을 반환한다.
        return friendListMap;
    }
}
