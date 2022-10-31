package onboarding;

import java.util.*;

public class Problem7 {

    // 관계 그래프를 저장할 해시맵
    private static HashMap<String, ArrayList<String>> relation = new HashMap<>();
    // 점수를 저장할 해시맵
    private static HashMap<String, Integer> friendPoint = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 관계 생성
        for (List<String>friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            createRelation(userA, userB);
            createRelation(userB, userA);
        }

        // 1촌 친구들
        List<String> firstFriends = relation.get(user);

        // 2촌 친구들 점수 10점
        for (String firstFriend : firstFriends) {
            for (String secondFriend : relation.get(firstFriend)) {
                addPointByRelation(secondFriend);
            }
        }

        // 방문자 점수 1점
        for (String visitor : visitors) {
            addPointByVisit(visitor);
        }

        // 1촌친구, 본인 삭제
        for (String f : firstFriends) {
            friendPoint.remove(f);
        }
        friendPoint.remove(user);


        // 점수를 기준으로 정렬
        List<String> keySet = new ArrayList<>(friendPoint.keySet());
        keySet.sort((o1, o2) -> friendPoint.get(o2).compareTo(friendPoint.get(o1)));

        // 상위 5명을 answer에 담아 리턴
        List<String> answer = new ArrayList<>();
        for (String key : keySet) {
            answer.add(key);
            if (answer.size()>=5){
                break;
            }
        }

        return answer;
    }

    // userA, userB를 담아 관계 HashMap에 저장
    private static void createRelation(String userA, String userB) {
        if (relation.containsKey(userA)){
            relation.get(userA).add(userB);
        }else{
            ArrayList<String> list = new ArrayList<>(Arrays.asList(userB));
            relation.put(userA, list);
        }
    }

    // 2촌 관계에 있는 친구들에게 10점 추가
    private static void addPointByRelation(String user) {
        // 이미 목록에 있다면 업데이트
        if (friendPoint.containsKey(user)){
            friendPoint.put(user, friendPoint.get(user)+10);
        }else{ // 없다면 새로 추가
            friendPoint.put(user, 10);
        }
    }

    // 방문자에게 1점 추가
    private static void addPointByVisit(String user) {
        // 이미 목록에 있다면 업데이트
        if (friendPoint.containsKey(user)){
            friendPoint.put(user, friendPoint.get(user)+1);
        }else{ // 없다면 새로 추가
            friendPoint.put(user, 1);
        }
    }
}
