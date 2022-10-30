package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 🚀 기능 요구 사항
 * 레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다.
 * 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.
 *
 * 사용자와 함께 아는 친구의 수 = 10점
 * 사용자의 타임 라인에 방문한 횟수 = 1점
 * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
 * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록
 * solution 메서드를 완성하라.
 * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
 *
 * 제한사항
 * user는 길이가 1 이상 30 이하인 문자열이다.
 * friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
 * friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
 * A와 B는 친구라는 의미이다.
 * 아이디는 길이가 1 이상 30 이하인 문자열이다.
 * visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
 * 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
 * 동일한 친구 관계가 중복해서 주어지지 않는다.
 * 추천할 친구가 없는 경우는 주어지지 않는다.
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        PriorityQueue<Recommend> pq = new PriorityQueue<>();
        Map<String, List<String>> relationship = new HashMap<>();
        initializeAcquaintanceScore(user, relationship, friends, pq);
        initializeVisitScore(user, relationship, visitors, pq);
        return pq.stream()
                .sorted((o1, o2) -> {
                    if (o1.getScore() == o2.getScore()) {
                        return o1.getRecommendedUser().compareTo(o2.getRecommendedUser());
                    }
                    return o2.getScore() - o1.getScore();
                })
                .map(Recommend::getRecommendedUser)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void initializeVisitScore(String user, Map<String, List<String>> relationship,
                                       List<String> visitors, PriorityQueue<Recommend> pq) {
        for (String visitor : visitors) {
            if (visitor.equals(user)) {
                continue;
            }
            boolean isAlreadyFriend = isAlreadyFriend(user, relationship, visitor);
            if (isAlreadyFriend) {
                continue;
            }
            Recommend recommend = getRecommend(pq, visitor);
            recommend.addScore(1);
            if (recommend.getScore() == 1) {
                pq.add(recommend);
            }
        }
    }

    private static boolean isAlreadyFriend(String user, Map<String, List<String>> relationship, String visitor) {
        for (String nickname : relationship.get(user)) {
            if (nickname.equals(visitor)) {
                return true;
            }
        }
        return false;
    }

    private static Recommend getRecommend(PriorityQueue<Recommend> pq, String visitor) {
        for (Recommend recommend : pq) {
            if (recommend.recommendedUser.equals(visitor)) {
                return recommend;
            }
        }
        return new Recommend(visitor, 0);
    }

    private static void initializeAcquaintanceScore(String user, Map<String, List<String>> relationship,
                                              List<List<String>> friends, PriorityQueue<Recommend> pq) {
        Map<String, Boolean> visited = new HashMap<>();
        Map<String, Recommend> recommendMap = new HashMap<>();
        setRelationship(relationship, friends, visited);
        saveAcquaintanceScoreRM(user, relationship, visited, recommendMap);
        saveAcquaintanceScorePQ(pq, recommendMap);
    }

    private static void saveAcquaintanceScoreRM(String user, Map<String, List<String>> relationship,
                                                Map<String, Boolean> visited, Map<String, Recommend> recommendMap) {
        Queue<String> queue = new LinkedList<>();
        queue.add(user);
        visited.put(user, true);
        int level = 1;
        int nowSize = 1;
        int count = 0;
        while (level <= 2) {
            investigateUserRelationship(relationship, visited, recommendMap, queue, level);
            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }
    }

    private static void saveAcquaintanceScorePQ(PriorityQueue<Recommend> pq,
                                                Map<String, Recommend> recommendMap) {
        for (String key : recommendMap.keySet()) {
            pq.add(recommendMap.get(key));
        }
    }

    private static void investigateUserRelationship(Map<String, List<String>> relationship,
                                                    Map<String, Boolean> visited,
                                                    Map<String, Recommend> recommendMap,
                                                    Queue<String> queue, int level) {
        String nickname = queue.poll();
        visited.put(nickname, true);
        for (String friend : relationship.get(nickname)) {
            if (!visited.get(friend) && level < 2) {
                visited.put(friend, true);
                queue.add(friend);
                continue;
            }
            if (!visited.get(friend)) {
                addScoreFriendsAcquaintance(recommendMap, level, friend);
            }
        }
    }

    private static void addScoreFriendsAcquaintance(Map<String, Recommend> recommendMap,
                                                    int level, String friend) {
        Recommend recommend = getRecommend(recommendMap, friend);
        recommend.addScore(10);
        if (recommend.getScore() == 10) {
            recommendMap.put(friend, recommend);
        }
    }

    private static Recommend getRecommend(Map<String, Recommend> recommendMap, String friend) {
        if (recommendMap.containsKey(friend)) {
            return recommendMap.get(friend);
        }
        return new Recommend(friend, 0);
    }

    private static void setRelationship(Map<String, List<String>> relationship, List<List<String>> friends,
                                        Map<String, Boolean> visited) {
        for (List<String> friend : friends) {
            for (String nickname : friend) {
                initializeRelationship(relationship, visited, nickname);
            }
            relationship.get(friend.get(0)).add(friend.get(1));
            relationship.get(friend.get(1)).add(friend.get(0));
        }
    }

    private static void initializeRelationship(Map<String, List<String>> relationship,
                                               Map<String, Boolean> visited, String nickname) {
        if (!relationship.containsKey(nickname)) {
            relationship.put(nickname, new ArrayList<>());
            visited.put(nickname, false);
        }
    }

    private static class Recommend implements Comparable<Recommend> {
        private final String recommendedUser;
        private int score;

        public Recommend(String recommendedUser, int score) {
            this.recommendedUser = recommendedUser;
            this.score = score;
        }

        public String getRecommendedUser() {
            return recommendedUser;
        }

        public int getScore() {
            return score;
        }

        public void addScore(int score) {
            this.score += score;
        }

        @Override
        public int compareTo(Recommend o) {
            if (this.getScore() == o.getScore()) {
                return this.getRecommendedUser().compareTo(o.getRecommendedUser());
            }
            return o.getScore() - this.getScore();
        }
    }
}
