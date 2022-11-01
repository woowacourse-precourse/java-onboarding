package onboarding;

import java.util.*;

public class Problem7 {
    private final static int IDX_FRIEND1 = 0;
    private final static int IDX_FRIEND2 = 1;
    private final static int SCORE_RULE1 = 10;
    private final static int SCORE_RULE2 = 1;
    private final static int RECOMMEND_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 추천할 수도 있는 유저들에 대한 정보를 담는 자료구조.
        Map<String, CandidateInfo> candidateUsers = new HashMap<>();
        // 위의 자료구조에 후보 유저들을 등록.
        friends.forEach(relationship -> registerRelationship(candidateUsers, relationship));
        // 후보 유저들에게 rule1, rule2에 대한 점수를 부여.
        evaluateScore(candidateUsers, friends, visitors, user);
        // 최대 다섯 명까지 추천.
        answer = recommendList(candidateUsers, user);

        return answer;
    }

    /**
     * 추천할 후보에 대한 정보(점수와 친구 목록) 표현하는 클래스입니다.
     */
    private static class CandidateInfo {
        private int score;
        private final Set<String> friends;

        public CandidateInfo() {
            score = 0;
            friends = new HashSet<String>();
        }

        public CandidateInfo(String friend) {
            score = 0;
            friends = new HashSet<>();
            friends.add(friend);
        }

        public CandidateInfo(int score) {
            this.score = score;
            friends = null;
        }

        public int getScore() {
            return score;
        }

        public void addScore(int score) {
            this.score += score;
        }

        public Set<String> getFriends() {
            return friends;
        }

        public void addFriend(String friend) {
            this.friends.add(friend);
        }

        public boolean have(String name) {
            return friends.contains(name);
        }
    }

    /**
     * 하나의 친구 관계를 입력받아 candidateUsers에 등록합니다.
     * (fisrtUser의 친구로 secondUser, secondUser의 친구로 firstUser 등록)
     * time complexity = O(1)
     */
    private static void registerRelationship(Map<String, CandidateInfo> candidateUsers, List<String> relationship) {
        String firstUser = relationship.get(IDX_FRIEND1);
        String secondUser = relationship.get(IDX_FRIEND2);

        // firstUser의 친구로 secondUser 등록.
        if (candidateUsers.containsKey(firstUser))
            candidateUsers.get(firstUser).addFriend(secondUser);
        else
            candidateUsers.put(firstUser, new CandidateInfo(secondUser));

        // secondUser의 친구로 firstUser 등록.
        if (candidateUsers.containsKey(secondUser))
            candidateUsers.get(secondUser).addFriend(firstUser);
        else
            candidateUsers.put(secondUser, new CandidateInfo(firstUser));
    }

    /**
     * candidateUser들의 점수를 계산합니다.
     * worst case time complexity = O(N^2)
     */
    private static void evaluateScore(Map<String, CandidateInfo> candidateUsers, List<List<String>> friends,
                                      List<String> visitors, String targetUser) {

        Set<String> friendsOfTargetUser = candidateUsers.get(targetUser).getFriends();

        // RULE1(targetUser와 함께 아는 친구의 수)에 대한 점수 계산.
        for (String friend : friendsOfTargetUser)
            evaluateRule1(candidateUsers, friend);

        // RULE2(피드 방문 여부)에 대한 점수 계산.
        for (String visitor : visitors)
            evaluateRule2(candidateUsers, visitor);
    }

    /**
     * friend와 친구인 유저에게 10점을 더해줍니다.
     */
    private static void evaluateRule1(Map<String, CandidateInfo> candidateUsers, String friend) {
        for (Map.Entry<String, CandidateInfo> candidate : candidateUsers.entrySet())
            candidate.getValue().addScore((candidate.getValue().have(friend) ? SCORE_RULE1 : 0));
    }

    /**
     * 타임라인에 방문한 유저를 candidate로 등록하고 1점을 더해줍니다.
     */
    private static void evaluateRule2(Map<String, CandidateInfo> candidateUsers, String visitor) {
        if (candidateUsers.containsKey(visitor))
            candidateUsers.get(visitor).addScore(SCORE_RULE2);
        else
            candidateUsers.put(visitor, new CandidateInfo(SCORE_RULE2));
    }

    /**
     * candidateUsers에서 점수가 높은 유저를 최대 5명까지 내림차순으로 정렬하여 반환합니다.
     * targetUser와 이미 친구인 유저는 제외합니다.
     */
    private static List<String> recommendList(Map<String, CandidateInfo> candidateUsers, String targetUser) {

        Set<String> friendsOfTargetUser = candidateUsers.get(targetUser).getFriends();      // 이미 친구인 유저 목록.
        List<String> recommendation;                                                        // 추천할 친구 목록.
        Map<String, Integer> userScoreMap = new HashMap<>();

        candidateUsers.forEach((name, info) -> userScoreMap.put(name, info.getScore()));         // O(N)

        // 점수에 대해 내림차순으로 정렬.
        recommendation = new ArrayList<>(userScoreMap.keySet());
        Collections.sort(recommendation, (k1, k2) -> userScoreMap.get(k2).compareTo(userScoreMap.get(k1)));

        // 0점인 후보, 이미 친구인 유저, targetUser 제거.
        recommendation = recommendation.stream()
                .filter(name -> !((userScoreMap.get(name).equals(0)) || friendsOfTargetUser.contains(name) || name.equals(targetUser)))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // 5명만 추천.
        if (recommendation.size() > RECOMMEND_SIZE)
            recommendation = recommendation.subList(0, RECOMMEND_SIZE);

        return recommendation;
    }
}
