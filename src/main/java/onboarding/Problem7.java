package onboarding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return new Solver7(user, friends, visitors).solve();
    }
}

class Solver7 {

    private final String user;

    /**
     * Map<Name, Set<FriendName>>으로 저장하여 조회가 훨씬 쉽도록 함
     */
    private final Map<String, Set<String>> friends = new HashMap<>();

    /**
     * Visitor의 정보는 방문 횟수만 중요하므로 횟수만 저장
     */
    private final Map<String, Integer> visitCounts = new HashMap<>();

    /**
     * 최종적으로 활용할 추천 친구 점수
     */
    private final Map<String, Integer> recommendationPoints = new HashMap<>();

    public Solver7(final String user, final List<List<String>> friends, final List<String> visitors) {
        this.user = user;
        this.makeFriendsRelationship(friends);
        this.calcVisitCounts(visitors);
    }

    private void makeFriendsRelationship(final List<List<String>> friends) {
        friends.forEach(pair -> {
            String friend1 = pair.get(0);
            String friend2 = pair.get(1);

            if (!this.friends.containsKey(friend1)) {
                this.friends.put(friend1, new HashSet<>());
            }
            if (!this.friends.containsKey(friend2)) {
                this.friends.put(friend2, new HashSet<>());
            }

            this.friends.get(friend1).add(friend2);
            this.friends.get(friend2).add(friend1);
        });
    }

    private void calcVisitCounts(final List<String> visitors) {
        visitors.forEach(visitor -> {
            if (!this.visitCounts.containsKey(visitor)) {
                this.visitCounts.put(visitor, 0);
            }
            this.visitCounts.put(visitor, this.visitCounts.get(visitor) + 1);
        });

        // friends에 없어도 visitor를 등록해야 함
        visitors.forEach(visitor -> {
            if (!this.friends.containsKey(visitor)) {
                this.friends.put(visitor, new HashSet<>());
            }
        });

        // visitor 기록이 없는 경우 0으로 초기화
        this.friends.keySet()
            .forEach(friend -> {
                if (!this.visitCounts.containsKey(friend)) {
                    this.visitCounts.put(friend, 0);
                }
            });
    }

    /**
     * [함께 아는 친구]
     *
     * mrko
     * - donut
     * - shakevan
     *
     * andole --> [donut, shakevan] --> 함께 아는 친구의 수 = 2
     * jun --> [donut, shakevan]    --> 함께 아는 친구의 수 = 2
     *
     * 방문자 수 =
     *
     * bedi * 3
     * donut * 1
     * shakevan * 1
     *
     * --> 결과:
     * andole (이름 우선; 20점)
     * jun (이름 우선; 20점)
     * bedi (3점)
     *
     * [친구 추천]
     * - 이미 친구인 경우는 제외
     * friends에는 없지만 visitors에 있을 수 있음
     * friends에 [중복]이 없으므로 체크할 필요 없음
     *
     * 추천 점수가 0점인 경우는 5명이 안 되어도 뺀다.
     * 정렬 조건은 (추천 점수, 이름) 순이다.
     */
    public List<String> solve() {
        calcRecommendationPoints();

        return strangerSortedByRecommendPoints();
    }

    /**
     *
     * [함께 아는 친구] 추천 점수를 계산
     */
    private void calcRecommendationPoints() {
        Set<String> strangers = myStrangers();
        strangers.forEach(stranger -> {
            int togetherPoints = pointsForFriendsKnownTogether(stranger) * 10;
            int visitorPoints = this.visitCounts.get(stranger);
            addPoints(stranger, togetherPoints + visitorPoints);
        });
    }

    private List<String> strangerSortedByRecommendPoints() {
        return this.recommendationPoints.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // 내림차순
            .filter(entry -> entry.getValue() > 0) // 0점이 아닌 애만 가능
            .filter(entry -> !myFriends().contains(entry.getKey()))
            .filter(entry -> !entry.getKey().equals(this.user))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    /**
     * 친구가 아닌 사람의 친구 추천 점수를 증감
     */
    private void addPoints(final String stranger, final int points) {
        if (!this.recommendationPoints.containsKey(stranger)) {
            this.recommendationPoints.put(stranger, 0);
        }
        this.recommendationPoints.put(stranger, this.recommendationPoints.get(stranger) + points);
    }

    /**
     * 친구가 아닌 사람의 [함께 아는 친구] 추천 점수를 반환
     */
    private int pointsForFriendsKnownTogether(final String stranger) {
        Set<String> friendsOfStranger = this.friends.get(stranger);
        return (int) myFriends().stream().filter(friendsOfStranger::contains).count();
    }

    /**
     * 대상 사용자의 친구가 아닌 사람들을 반환
     */
    private Set<String> myStrangers() {
        return this.friends.keySet()
            .stream()
            .filter(friend -> !this.user.equals(friend) && !myFriends().contains(friend))
            .collect(Collectors.toSet());
    }

    /**
     * 대상 사용자의 친구를 반환
     */
    private Set<String> myFriends() {
        return this.friends.get(this.user);
    }
}
