package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. 주어진 규칙에 따라 추천 점수가 높은 순서대로 최대 5명까지 리턴(추천 점수가 0일 경우 추천하지 않음)
        - 규칙 1번(사용자와 함께 아는 친구의 수 = 10점)을 해결하기 위해, 주어진 friends 리스트를 통해 Map 객체를 만들어 Key(특정 인물), Value(특정 인물과 관계있는 인물들) 구조로 매핑
        - 만든 Map 객체를 통해서 유저가 아는 친구와 관계가 있는 인물들 점수 10점씩 추가
        - visitors중 유저와 친구 관계가 아닌 인물들의 점수 1점씩 추가
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friends_part = friends.stream().flatMap(Collection::stream).collect(Collectors.toList());  // friends를 1d list로 만듬
        friends_part.addAll(visitors);  // 1차원이 된 friends와 visitors를 합침
        Set<String> all_friend = new HashSet<>(friends_part);   // 주어진 전체 인물들의 이름이 담긴 Set 객체 세팅 완료
//        System.out.println(all_friend);

        Map<String, List<String>> proximity_node = new HashMap<>();
        for (List<String> a : friends) {
            for (int i = 0; i < 2; i++) {
                int res_idx = (i + 1) % 2;  // 다른 한쪽 index
                String now_node = a.get(i); // 선택된 노드
                String remain_node = a.get(res_idx);    // 다른 노드
                if (proximity_node.containsKey(now_node)) { // Map 객체에 해당 노드가 있을 경우
                    List<String> temp = proximity_node.get(now_node);   // 해당 노드의 관계리스트
                    temp.add(remain_node);  // 해당 노드의 관계리스트에 다른 친구 추가
                    proximity_node.replace(now_node, temp); // 해당 노드로 교체
                } else {    // Map 객체에 해당 노드가 없을 경우(처음 넣을 때)
                    proximity_node.put(now_node, new ArrayList<>(Arrays.asList(remain_node)));  // 노드 세팅
                }
            }
        }
        System.out.println(proximity_node);

        return answer;
    }
}
