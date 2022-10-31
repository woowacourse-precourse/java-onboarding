/**
 * 클래스 이름
 * - 문제 7
 *
 * 버전정보
 * - jdk-11.0.17
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;

import java.util.*;

class Node implements Comparable<Node> {

    private String name;
    private int score;

    public Node(String name, int distance) {
        this.name = name;
        this.score = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Node o) {
        if(this.getScore()>o.getScore()){
            return -1;
        } else if (this.getScore() < o.getScore()) {
            return 1;
        } else {
            return this.getName().compareTo(o.getName());
        }
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 친구관계 정리 맵
        HashMap<String, List<String>> friendRelation = new HashMap<>();
        // 유저의 친구인지 확인
        HashMap<String, Boolean> userFriendCheck = new HashMap<>();
        // 친구 추천 점수 맵
        HashMap<String, Integer> score = new HashMap<>();


        for (List<String> friend : friends) {
            // 유저 친구들 따로 체크
            setUserFriendCheck(user, userFriendCheck, friend);

            // 친구 관계 그래프로 설정
            setFriendRelation(friendRelation, friend);
        }

        // 함께 아는 친구의 수 추천점수
        friendOfFriendScoring(user, friendRelation, score);

        // 방문자 추천점수
        visitorScoring(visitors, score);

        // 조건에 맞게 정렬하기 위해 Node 사용
        ArrayList<Node> result = new ArrayList<>();

        for (String key : score.keySet()) {
            Boolean check = userFriendCheck.get(key);

            // 이미 user와 친구가 아니라면 결과에 저장
            if(check==null) result.add(new Node(key, score.get(key)));
            else if(!check) result.add(new Node(key, score.get(key)));
        }

        Collections.sort(result);

        for (Node node : result) {
            answer.add(node.getName());
        }

        return answer;
    }

    private static void visitorScoring(List<String> visitors, HashMap<String, Integer> score) {
        for (String visitor : visitors) {
            if(score.get(visitor)==null){
                score.put(visitor, 1);
            } else {
                score.put(visitor, score.get(visitor) + 1);
            }
        }
    }

    private static void friendOfFriendScoring(String user, HashMap<String, List<String>> friendRelation, HashMap<String, Integer> score) {
        List<String> userFriendList = friendRelation.get(user);
        for (String friend : userFriendList) {
            // user 친구의 친구리스트
            List<String> friendOfFriendList = friendRelation.get(friend);

            for (String friendOfFriend : friendOfFriendList) {
                if(friendOfFriend.equals(user)) continue;
                // 함께하는 친구 한명당 점수 10점씩 증가
                if(score.get(friendOfFriend)==null){
                    score.put(friendOfFriend, 10);
                } else {
                    score.put(friendOfFriend, score.get(friendOfFriend) + 10);
                }
            }
        }
    }

    private static void setFriendRelation(HashMap<String, List<String>> friendRelation, List<String> friend) {
        String name1 = friend.get(0);
        String name2 = friend.get(1);
        if (friendRelation.get(name1) == null) {
            friendRelation.put(name1, new ArrayList<String>());
            friendRelation.get(name1).add(name2);
        } else {
            friendRelation.get(name1).add(name2);
        }
        if (friendRelation.get(name2) == null) {
            friendRelation.put(name2, new ArrayList<>());
            friendRelation.get(name2).add(name1);
        } else {
            friendRelation.get(name2).add(name1);
        }
    }

    private static void setUserFriendCheck(String user, HashMap<String, Boolean> userFriendCheck, List<String> friend) {
        String name1 = friend.get(0);
        String name2 = friend.get(1);
        if (name1.equals(user)) {
            userFriendCheck.put(name2, true);
        } else if (name2.equals(user)) {
            userFriendCheck.put(name1, true);
        }
    }
}

