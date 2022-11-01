package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scores = new HashMap<>();
        scores = add_visit_scores(scores, visitors);
        scores = add_relationship_scores(user, friends, scores);

        List<Map.Entry<String, Integer>> sorted_scores  = sort_scores(scores);

        List<String> answer = get_top_5_scores_from(sorted_scores);

        return answer;
    }


    // 점수 기준 내림차순, 점수가 같으면 이름 기준 오름차순으로 정렬
    public static List<Map.Entry<String, Integer>> sort_scores(HashMap<String, Integer> scores){
        List<Map.Entry<String, Integer>> sorted_scores  = new ArrayList<>(scores.entrySet());
        sorted_scores.sort((o1, o2) -> (
                Objects.equals(o1.getValue(), o2.getValue()) ?
                        o1.getKey().compareTo(o2.getKey()) :
                        o2.getValue().compareTo(o1.getValue()))
        );

        return sorted_scores;
    }


    // 방문 점수 집계
    public static HashMap<String, Integer> add_visit_scores(HashMap<String, Integer> scores, List<String> visitors){
        for (String visitor : visitors) {
            int score = scores.getOrDefault(visitor,0);
            scores.put(visitor, score + 1);
        }
        return scores;
    }

    // 관계성 점수 집계
    public static HashMap<String, Integer> add_relationship_scores(String user, List<List<String>> friends, HashMap<String, Integer> scores){

        HashMap<String, HashSet<String>> relatives = find_relatives(friends);

        // 유저와 직접적인 친구관계
        HashSet<String> direct_friends = relatives.getOrDefault(user, new HashSet<>());

        // 친구의 친구가 있으면 관계성 점수 10점 씩 추가
        for (String direct_friend : direct_friends) {
            // 친구의 친구
            HashSet<String> indirect_friends = relatives.getOrDefault(direct_friend, new HashSet<>());

            // 친구의 친구에게 10점 추가 부여
            for (String indirect_friend : indirect_friends){
                int score = scores.getOrDefault(indirect_friend,0);
                scores.put(indirect_friend, score + 10);
            }
        }

        // 직접적인 친구나 자기자신의 점수는 추천할 때 필요 없기 때문에 제거

        // 자신의 점수 제거
        scores.remove(user);

        // 직접적인 친구 점수 제거
        for (String direct_friend: direct_friends) {
            scores.remove(direct_friend);
        }

        return scores;
    }

    // 각 유저에 대한 친구 목록을 해시맵으로 저장
    public static HashMap<String, HashSet<String>> find_relatives(List<List<String>> friends){
        HashMap<String, HashSet<String>> relatives = new HashMap<>();

        // 각 친구 정보에 대해
        for (List<String> friend : friends){
            String p1 = friend.get(0);
            String p2 = friend.get(1);

            // 각자 친구 목록 가져오기
            HashSet<String> p1_relatives = relatives.getOrDefault(p1, new HashSet<>());
            HashSet<String> p2_relatives = relatives.getOrDefault(p2, new HashSet<>());

            // 친구 목록에 서로를 추가
            p1_relatives.add(p2);
            p2_relatives.add(p1);

            // 각 친구 목록 정보 저장
            relatives.put(p1, p1_relatives);
            relatives.put(p2, p2_relatives);
        }

        return relatives;
    }


}
