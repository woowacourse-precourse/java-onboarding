/**
 * 클래스 이름
 * - 문제 7
 *
 * 버전정보
 * - openjdk version "11.0.15"
 *
 * 날짜
 * - 2022-10-31
 *
 */
package onboarding;

import java.util.*;

class Node implements Comparable<Node> {

    private String name;
    private int distance;

    public Node(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node o) {
        if(this.getDistance()>o.getDistance()){
            return -1;
        } else if (this.getDistance() < o.getDistance()) {
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
        // 유저의 친구 맵
        HashMap<String, Boolean> userFriendMap = new HashMap<>();
        // 친구 추천 점수 맵
        HashMap<String, Integer> score = new HashMap<>();


        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            // 유저 친구들 따로 체크
            if (name1.equals(user)) {
                userFriendMap.put(name2, true);
            } else if (name2.equals(user)) {
                userFriendMap.put(name1, true);
            }

            // 친구 관계 그래프로 설정
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

        List<String> userFriendList = friendRelation.get(user);
        for (String friend : userFriendList) {
            List<String> friendList = friendRelation.get(friend);
            // 친구의 친구
            for (String ff : friendList) {
                if(ff.equals(user)) continue;
                // 함께하는 친구 한명당 점수 10점씩 증가
                if(score.get(ff)==null){
                    score.put(ff, 10);
                } else {
                    score.put(ff, score.get(ff) + 10);
                }
            }
        }
        for (String visitor : visitors) {
            if(score.get(visitor)==null){
                score.put(visitor, 1);
            } else {
                score.put(visitor, score.get(visitor) + 1);
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        for (String key : score.keySet()) {
            Boolean check = userFriendMap.get(key);

            if(check==null) result.add(new Node(key, score.get(key)));
            else if(!check) result.add(new Node(key, score.get(key)));

        }
        Collections.sort(result);
        for (Node node : result) {
            answer.add(node.getName());
        }

        return answer;
    }
}
