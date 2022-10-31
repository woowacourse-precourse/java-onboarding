package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return
 *      - 사용자와 함께 아는 친구의 수 = 10점
 *      - 사용자의 타임 라인에 방문한 횟수 = 1점
 *
 * 1. 접근 방식
 *  - 사용자와 친구간 그래프를 만들어 사용자를 기준으로 BFS 탐색 2depth 실행
 *  - friend의 관계 그래프를 나타낼 수 있는 Map(friendGraph), friend 각각의 점수를 저장하는 Map(friendScore) 준비
 *      - 1 depth : 사용자의 친구들
 *      - 2 depth : 사용자와 동일한 친구를 아는 사람들 <- 해당 사람들에게 friendScore.VAULE +10
 *  - visitor는 최종적으로 더함
 *
 * */
public class Problem7 {

    private Map<String, List<String>> friendGraphMap = new HashMap<>();
    private Map<String, Integer> friendScoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 problem7 = new Problem7();

        // Friend Graph 제작
        problem7.makeFriendGraph(friends);

        // 친구 추천 규칙에 따라 점수 계산
        problem7.calcScoreFriends(user);
        problem7.calcScoreVisitor(visitors);

        // user와 user의 직접적인 친구는 추천에서 제외
        problem7.removeUserFriend(user);

        // 1순위 정렬 : 추천 점수 - 2순위 정렬 : 이름 => 구현은 역순으로 먼저 이름으로 정렬하고 이후 추천 점수로 정렬
        return problem7.friendScoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .filter(f -> f.getValue() > 0)
                .map(f -> f.getKey())
                .collect(Collectors.toList());
    }

    // user와 user의 직접적인 친구는 추천에서 제외
    public void removeUserFriend(String user){
        // user 본인 제외
        friendScoreMap.remove(user);

        // user 직접적인 친구들 제외
        List<String> userFriendList = friendGraphMap.get(user);
        for(String userFriend : userFriendList){
            friendScoreMap.remove(userFriend);
        }
    }

    // 사용자와 함께 아는 친구의 수로 score 계산(10점)
    public void calcScoreFriends(String user){
        List<String> userFriendList = friendGraphMap.get(user);

        // 사용자의 직접적인 친구들의 친구들이 득점의 대상이 된다.
        for(String userFriend : userFriendList){
            List<String> userTwoDepthFriendList = friendGraphMap.get(userFriend);
            for(String scoredFriend : userTwoDepthFriendList){
                friendScoreMap.put(scoredFriend,(friendScoreMap.get(scoredFriend) + 10));
            }
        }
    }

    // 사용자의 타임 라인에 방문한 횟수로 score 계산(1점)
    public void calcScoreVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            // 이미 friendGraph에서 추가된 crew일 경우
            if (friendScoreMap.containsKey(visitor)) {
                friendScoreMap.put(visitor, (friendScoreMap.get(visitor) + 1));
                continue;
            }

            // friendGraph에서 추가되지 않은 신규 crew일 경우
            friendScoreMap.put(visitor, 1);
        }
    }

    // HashMap으로 FriendGraph 구성
    public void makeFriendGraph(List<List<String>> friends){
        for(List<String> crew : friends){
            boolean isFirstCrewExist = friendGraphMap.containsKey(crew.get(0));
            boolean isSecondCrewExist = friendGraphMap.containsKey(crew.get(1));

            if(isFirstCrewExist && isSecondCrewExist) {     // 둘다 그래프에 있을시
                addCrewInGraph(crew);
                continue;
            }
            if(!isFirstCrewExist){      // 첫번째 친구가 Graph에 없을시 Graph와 Score에 추가
                putNewCrew(crew.get(0));
            }
            if(!isSecondCrewExist){     // 두번째 친구가 Graph에 없을시 Graph와 Score에 추가
                putNewCrew(crew.get(1));
            }
            // 없는 친구를 Graph에 넣은 후 친구 관계 추가(VALUE)
            addCrewInGraph(crew);
        }
    }

    // crew 관계를 FriendGraph에 추가
    public void addCrewInGraph(List<String> crew){
        friendGraphMap.get(crew.get(0)).add(crew.get(1));
        friendGraphMap.get(crew.get(1)).add(crew.get(0));
    }

    // 새로운 crew를 생성(friendGraphMap과 friendScoreMap에 넣어준다)
    public void putNewCrew(String crew){
        friendGraphMap.put(crew,new ArrayList<>());
        friendScoreMap.put(crew,0);
    }
    
}
