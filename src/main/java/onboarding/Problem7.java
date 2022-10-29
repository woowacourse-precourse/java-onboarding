/*
[기능 목록]

1. 친구 관계 클래스
    1) 프로퍼티
        - 친구 관계를 저장하는 자료구조
    2) 메서드
        - 친구 관계 추가
        - 공동 친구 수 구하기

2. 친밀도 클래스
    1) 프로퍼티
        - 친밀도 계산의 목표가 되는 user id
        - id
        - 공동 친구 수
        - 방문 횟수
    2) 메서드
        - 공동 친구 수 getter / setter
        - 방문 횟수 getter / setter
        - 점수 구하기
        - 정렬을 위한 compareTo

3. 추천 클래스
    1) 프로퍼티
        - user id
        - 친구가 아닌 사용자와의 친밀도 Set
            -> 특징 : 친밀도 순으로 정렬

    2) 메서드
        - 다른 사용자와의 친밀도 추가
        - 최대 5명의 친구 추천


4. 친구 관계 클래스 생성
5. user별 방문 횟수 카운트
6. user의 추천 클래스 생성
 */

package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class Relations {
    private Map<String, Set<String>> relations;

    public Relations() {
        this.relations = new HashMap<>();
    }

    public void addRelation (String friend1, String friend2) {
        initRelationIfEmpty(friend1);
        initRelationIfEmpty(friend2);

        relations.get(friend1).add(friend2);
        relations.get(friend2).add(friend1);
    }

    private void initRelationIfEmpty(String userId) {
        if (!relations.containsKey(userId)) {
            relations.put(userId, new HashSet<>());
        }
    }

    public int getNumOfMutualFriends (String user1, String user2) {
        Set<String> mutualFriends = new HashSet<>(this.relations.get(user1));
        mutualFriends.retainAll(this.relations.get(user2));
        return mutualFriends.size();
    }
}

class Intimacy implements Comparable<Intimacy> {
    static final int MUTUAL_FRIEND_WEIGHT = 10;
    static final int VISITED_WEIGHT = 10;

    private String targetId;
    private String userId;
    private int numOfMutualFriends;
    private int numOfVisited;

    public Intimacy (String targetId, String userId) {
        this.targetId = targetId;
        this.userId = userId;
        this.numOfMutualFriends = 0;
        this.numOfVisited = 0;
    }

    public int getNumOfMutualFriends() {
        return numOfMutualFriends;
    }

    public void setNumOfMutualFriends(Relations relations) {
        this.numOfMutualFriends = relations.getNumOfMutualFriends(this.targetId, this.userId);
    }

    public int getNumOfVisited() {
        return numOfVisited;
    }

    public void setNumOfVisited(Map<String, Integer> visitedCount) {
        this.numOfVisited = 0;
        if (visitedCount.containsKey(this.userId)) {
            this.numOfVisited = visitedCount.get(this.userId);
        }
    }

    public int getScore() {
        return ( this.numOfMutualFriends * MUTUAL_FRIEND_WEIGHT ) + ( this.numOfVisited * VISITED_WEIGHT );
    }

    @Override
    public int compareTo (Intimacy o) {
        if (this.getScore() == o.getScore()) {
            return this.userId.compareTo(o.userId);
        }
        return o.getScore() - this.getScore();
    }
}
