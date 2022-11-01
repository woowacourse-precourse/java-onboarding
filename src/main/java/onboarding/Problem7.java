package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, Integer> friendPoint;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendPoint = new HashMap<>(); // 친밀도 배열 <다른유저, usesr와 친밀도>

        // 친구관계
        List<String> oldFriends = getOldFriends(user, friends);
        for (String oldFriend : oldFriends) {
            NewFriends(user, friends, oldFriend);
        }

        // 방문자 확인 함수
        checkVisitors(visitors);

        // 친구 추천 정렬
        return recommandUser(user, oldFriends, friendPoint);
    }

    // 추천점수 1이상, 이미 동일한 친구 관계가 아닌 경우 List 반환
    private static List<String> recommandUser(String user, List<String> oldFriends, Map<String, Integer> userFriends) {
        List<String> answer = new ArrayList<>();

        // 점수순 -> 이름순 정렬
        List<Map.Entry<String,Integer>> sortList = new LinkedList<>(userFriends.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() == o1.getValue()) return o1.getKey().compareToIgnoreCase(o2.getKey());    // 점수가 똑같다면 이름 순
                else return o2.getValue() - o1.getValue();      // 아니라면 점수 내림차순
            }
        });

        for (int i=0; i<sortList.size(); i++) {
            String name = sortList.get(i).getKey();
            if (!oldFriends.contains(name) && !name.equals(user)) answer.add(name);
            if (answer.size() == 5) break;
        }
        return answer;
    }

    // 방문자 체크
    private static void checkVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            addPoint(visitor, 1);
        }
    }

    // 새친구 점수 추가
    private static void NewFriends(String user, List<List<String>> friends, String oldFriend) {
        // user의 새 친구 찾기
        for (List<String> relation : friends) {
            if(relation.contains(oldFriend) && !relation.contains(user)){
                String newFriend = relation.get(0)==oldFriend ? relation.get(1) : relation.get(0);
                addPoint(newFriend, 10);
            }
        }
    }

    // user 친구 찾기
    private static List<String> getOldFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        // user 친구 찾기
        for (List<String> relation : friends){
            if(relation.contains(user)) {
                result.add(relation.get(0)==user ? relation.get(1) : relation.get(0));
            }
        }
        return result;
    }

    // 추천 점수 추가
    static void addPoint(String user, int point) {
        if(friendPoint.containsKey(user)) {
            friendPoint.replace(user, friendPoint.get(user)+point);
        } else {
            friendPoint.put(user, point);
        }
    }
}
