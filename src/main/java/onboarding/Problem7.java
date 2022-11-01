/*
[기능 목록]

1. 친구 관계 클래스
    1) 프로퍼티
        - 친구 관계를 저장하는 자료구조
    2) 메서드
        - 관계에 속하는 모든 유저 리스트 반환
        - 주어진 두 user의 친구관계 여부 확인
        - 친구 관계 추가
        - 공동 친구 수 구하기

2. 친밀도 클래스
    1) 프로퍼티
        - 친밀도 계산의 목표가 되는 user id
        - id
        - 공동 친구 수
        - 방문 횟수
    2) 메서드
        - id getter
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


4. 친구 관계 클래스의 인스턴스 생성
5. user별 방문 횟수 카운트
6. target User 에 대한 친밀도 클래스의 인스턴스 생성
7. user의 추천 클래스의 인스턴스 생성
 */

package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Relations relations = createRelations(friends);
        Map<String, Integer> visitLog = countVisit(visitors);
        Recommendation recommendation = createRecommendation(user, relations, visitLog);
        return recommendation.recommend();
    }

    public static Relations createRelations (List<List<String>> friends) {
        Relations relations = new Relations();
        for (List<String> relation : friends) {
            relations.addRelation(relation.get(0), relation.get(1));
        }
        return relations;
    }

    public static Map<String, Integer> countVisit (List<String> visitors) {
        Map<String, Integer> visitLog = new HashMap<>();
        for (String visitor : visitors) {
            int numOfVisit = 1;
            if (visitLog.containsKey(visitor)) {
                numOfVisit = visitLog.get(visitor) + 1;
            }
            visitLog.put(visitor, numOfVisit);
        }
        return visitLog;
    }

    public static Recommendation createRecommendation (String targetUser, Relations relations, Map<String, Integer> visitLog) {
        Recommendation recommendation = new Recommendation(targetUser);
        Set<String> allUsers = relations.getAllUsers();
        allUsers.addAll(visitLog.keySet());
        for (String userId : allUsers) {
            if (userId.equals(targetUser) || relations.isFriend(targetUser, userId)) {
                continue;
            }
            Intimacy intimacy = createIntimacy(targetUser, userId, relations, visitLog);
            recommendation.addIntimacy(intimacy);
        }
        return recommendation;
    }

    public static Intimacy createIntimacy (String targetUser, String user,  Relations relations, Map<String, Integer> visitLog) {
        Intimacy intimacy = new Intimacy(targetUser, user);
        intimacy.setNumOfMutualFriends(relations);
        intimacy.setNumOfVisited(visitLog);
        return intimacy;
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

    public boolean isFriend(String user1, String user2) {
        if ( !this.relations.containsKey(user1) ) {
            return false;
        }
        return relations.get(user1).contains(user2);
    }

    public int getNumOfMutualFriends (String user1, String user2) {
        if ( !this.relations.containsKey(user1) || !this.relations.containsKey(user2) ) {
            return 0;
        }
        Set<String> mutualFriends = new HashSet<>(this.relations.get(user1));
        mutualFriends.retainAll(this.relations.get(user2));
        return mutualFriends.size();
    }

    public Set<String> getAllUsers() {
        return new HashSet<>(this.relations.keySet());
    }
}

class Intimacy implements Comparable<Intimacy> {
    private static final int MUTUAL_FRIEND_WEIGHT = 10;
    private static final int VISITED_WEIGHT = 1;

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

    public String getUserId() {
        return userId;
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

    public void setNumOfVisited(Map<String, Integer> visitedLog) {
        this.numOfVisited = 0;
        if (visitedLog.containsKey(this.userId)) {
            this.numOfVisited = visitedLog.get(this.userId);
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

class Recommendation {
    private String userId;
    Map<String, Intimacy> intimacies;

    public Recommendation(String userId) {
        this.userId = userId;
        intimacies = new HashMap<>();
    }

    public void addIntimacy (Intimacy intimacy) {
        intimacies.put(intimacy.getUserId(), intimacy);
    }

    public List<String> recommend() {
        List<Intimacy> otherUserIntimacies = new ArrayList<>(intimacies.values());
        Collections.sort(otherUserIntimacies);
        List<String> recommendations = new ArrayList<>();

        int numOfRecommendation = 0;
        for (Intimacy otherUserIntimacy : otherUserIntimacies) {
            if (otherUserIntimacy.getScore() == 0) {
                break;
            }
            recommendations.add(otherUserIntimacy.getUserId());
            if (++numOfRecommendation >= 5) {
                break;
            }
        }
        return recommendations;
    }
}