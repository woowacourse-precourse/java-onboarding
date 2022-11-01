package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        List<String> userFriends = new ArrayList<>();
        Map<String, Integer> score = new HashMap<>();

        // 친구 관계 정보에 해당하는 친구들을 user 의 친구리스트에 저장
        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);

            if (a.equals(user)) userFriends.add(b);
            else if (b.equals(user)) userFriends.add(a);
        }

        // 사용자와 함께 아는 친구의 수 10점 추가
        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);

            if (a.equals(user) || b.equals(user)) continue;

            if (userFriends.contains(a)) {
                score.put(b, score.containsKey(b) ? score.get(b) + 10 : 10);
            }
            if (userFriends.contains(b)) {
                score.put(a, score.containsKey(a) ? score.get(a) + 10 : 10);
            }
        }

        // 사용자의 타임라인에 방문한 횟수에 따라 +1점 추가
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) continue;
            score.put(visitor, score.containsKey(visitor) ? score.get(visitor) + 1 : 1);
        }

        // score 를 List 로 묶어서 추천 점수가 가장 높은 순으로 정렬한다.
        List<Map.Entry<String, Integer>> scoreList = new LinkedList<>(score.entrySet());
        scoreList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // 정렬된 scoreList 에서 최대 5명을 answer 에 담아서 반환한다.
        for (int i = 0; i < 5; i++) {
            if (scoreList.size() <= i) break;
            answer.add(scoreList.get(i).getKey());
        }
        
        return answer;
    }
}
