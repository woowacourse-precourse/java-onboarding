package onboarding;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {
    @Test
    void checkSolution() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case2() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
    }

//    visitors = []

    @Test
    void case3() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("bedi", "jun"),
                List.of("bedi", "donut"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("donut", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case4() {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "shakevan"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "bedi"),
                List.of("anne", "jun")
        );
        List<String> visitors = List.of("donut", "mrko", "peter", "sam");
        List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
    }

    static Map<String, Integer> userFriends;

    // 추천점수 1이상, 이미 동일한 친구 관계가 아닌 경우
    private List<String> recommandUser(String user, List<String> oldFriends, Map<String, Integer> userFriends) {
        List<String> answer = new ArrayList<>();

        // 점수순 -> 이름순 정렬
        List<Map.Entry<String,Integer>> sortList = new LinkedList<>(userFriends.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 점수가 똑같다면 이름 순
                if (o2.getValue() == o1.getValue()) return o1.getKey().compareToIgnoreCase(o2.getKey());
                // 아니라면 점수 내림차순
                else return o2.getValue() - o1.getValue();
            }
        });

        for (int i=0; i<sortList.size(); i++) {
            String name = sortList.get(i).getKey();
            if (!oldFriends.contains(name) && !name.equals(user)) answer.add(name);
            if (answer.size() == 5) break;
        }
        return answer;
    }
    
    // 방문자
    private void checkVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            addPoint(visitor, 1);
        }
    }

    private void checkFriends(String user, List<List<String>> friends, String oldFriend) {
        // user의 새 친구 찾기
        for (List<String> relation : friends) {
            if(relation.contains(oldFriend) && !relation.contains(user)){
                String newFriend = relation.get(0)==oldFriend ? relation.get(1) : relation.get(0);
                addPoint(newFriend, 10);
            }
        }
    }

    // 이전 친구 찾기
    private List<String> getOldFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        // user 친구 찾기
        for (List<String> relation : friends){
            if(relation.contains(user))  result.add(relation.get(0)==user ? relation.get(1) : relation.get(0));
        }
        return result;
    }

    void addPoint(String user, int point) {
        // 추천 점수 추가
        if(userFriends.containsKey(user)) {
            userFriends.replace(user, userFriends.get(user)+point);
        } else {
            userFriends.put(user, point);
        }
    }
}