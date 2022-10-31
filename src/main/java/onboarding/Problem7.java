package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<String, List<String>> getFriendMap(List<List<String>> relationships) {
        // 친구 목록을 담을 HashMap
        // ex. { shakevan=[andole, jun, mrko] ... }
        HashMap<String, List<String>> friendMap = new HashMap<>();

        for (List<String> relationship : relationships) {
            // 관계 튜플을 친구A, 친구B로 나누기
            String friendA = relationship.get(0);
            String friendB = relationship.get(1);
            
            // 두 사용자의 친구 목록을 불러오기, 없으면 빈 ArrayList 생성
            List<String> aRelation = friendMap.getOrDefault(friendA, new ArrayList<>());
            List<String> bRelation = friendMap.getOrDefault(friendB, new ArrayList<>());
            
            // 서로의 친구 리스트의 자신을 교차하여 추가
            aRelation.add(friendB);
            bRelation.add(friendA);
            
            // 친구목록 갱신하기
            friendMap.put(friendA, aRelation);
            friendMap.put(friendB, bRelation);
        }

        return friendMap;
    }

    private static List<String> getTopFive(HashMap<String, Integer> scoreMap) {
        List<String> topFive = new ArrayList<>();
        // 정렬을 위해 LinkedList로 변환하기
        // HashMap은 입력 순서를 보장하지 않아 정렬할 수 없음
        List<HashMap.Entry<String, Integer>> scoreList = new LinkedList<>(scoreMap.entrySet());

        // Lambda식을 이용해 다중조건 정렬하기
        scoreList.sort((o1, o2) -> {
            // 먼저 점수를 내림차순
            int status = o2.getValue().compareTo(o1.getValue());

            // 두 점수가 같은 경우 이름으로 오름차순
            if (status == 0)
                status = o1.getKey().compareTo(o2.getKey());
            return status;
        });

        // 최대 다섯번 반복하기
        for (int i = 0; i < 5; i ++) {
            // 0점이면 반복문 탈출
            HashMap.Entry<String, Integer> scoreSet = scoreList.get(i);
            if (scoreSet.getValue() == 0)
                break;

            topFive.add(scoreSet.getKey());
        }

        return topFive;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 각각 사용자의 점수를 저장하는 HashMap
        HashMap<String, Integer> scoreMap = new HashMap<>();
        // 친구 목록 받아오기
        HashMap<String, List<String>> relationships = getFriendMap(friends);

        // 친구 목록에서 점수 계산하기
        // 선택한 사용자의 친구 목록 꺼내기
        List<String> userFriends = relationships.remove(user);

        // 사용자를 제외한 모든 친구목록 반복
        for (String id : relationships.keySet()) {
            List<String> otherFriends = relationships.get(id);
            int score = scoreMap.getOrDefault(id, 0);

            // 다른 사용자의 친구에서 사용자의 친구가 있으면 +10점
            for (String friendId : otherFriends)
                if (userFriends.contains(friendId))
                    score += 10;

            scoreMap.put(id, score);
        }

        // 방문 목록에서 점수 계산하기
        for (String id : visitors) {
            // 사용자의 친구가 아닌경우
            if (!userFriends.contains(id)) {
                int score = scoreMap.getOrDefault(id, 0);
                // 방문 목록에 있는 사용자 +1 점
                scoreMap.put(id, score + 1);
            }
        }

        // 상위 5개 점수 가져오기
        answer = getTopFive(scoreMap);
        return answer;
    }
}
