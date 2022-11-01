package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendship = getFriendship(user, friends);
        Map<String, Long> recommendScore = new HashMap<>();
        addFriendshipScore(user, friends, friendship, recommendScore);
        addVisitorScore(visitors, friendship, recommendScore);
        return getSortAnswer(recommendScore);
    }

    /**
     * 친구 관계 점수를 더한다.
     *
     * @param user           유저
     * @param friends        SNS 친구 관계
     * @param friendship     유저의 친구 관계
     * @param recommendScore 친구 추천 점수
     */
    private static void addFriendshipScore(String user, List<List<String>> friends, List<String> friendship, Map<String, Long> recommendScore) {
        for (List<String> friend : friends) {
            if (!friend.contains(user)) {
                if (hasIdByFriendship(friend.get(0), friendship)) {
                    addRecommendScore(recommendScore, friend.get(1), 10L);
                } else if (hasIdByFriendship(friend.get(1), friendship)) {
                    addRecommendScore(recommendScore, friend.get(0), 10L);
                }
            }
        }
    }

    /**
     * 친구 관계에 점수를 더한다.
     *
     * @param recommendScore 친구 추천 점수
     * @param friend         친구
     * @param score          점수
     */
    private static void addRecommendScore(Map<String, Long> recommendScore, String friend, long score) {
        recommendScore.put(friend, recommendScore.getOrDefault(friend, 0L) + score);
    }

    /**
     * 방문 친구 점수를 더한다.
     *
     * @param visitors       방문 목록
     * @param friendship     유저의 친구들
     * @param recommendScore 친구 추천 점수
     */
    private static void addVisitorScore(List<String> visitors, List<String> friendship, Map<String, Long> recommendScore) {
        for (String visitor : visitors) {
            if (!hasIdByFriendship(visitor, friendship)) {
                addRecommendScore(recommendScore, visitor, 1L);
            }
        }
    }

    /**
     * 해당 Id를 가지고 있는지 검색한다.
     *
     * @param id  아이디
     * @param ids 아이디 리스트
     * @return 해당 id 를 가지고 있으면 true
     */
    private static boolean hasIdByFriendship(String id, List<String> ids) {
        return ids.contains(id);
    }

    /**
     * 유저의 친구 관계를 구한다.
     *
     * @param user    유저
     * @param friends SNS 친구관계
     * @return 유저의 친구 관계를 반환한다.
     */
    private static List<String> getFriendship(String user, List<List<String>> friends) {
        List<String> friendship = new ArrayList<>(Collections.emptyList());
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    friendship.add(friend.get(1));
                } else if (friend.get(1).equals(user)) {
                    friendship.add(friend.get(0));
                }
            }
        }
        return friendship;
    }

    /**
     * 정렬된 추천 목록을 구한다.
     * @param recommendScore    친구 추천 점수
     * @return  친추 추천 목록 반환
     */
    private static List<String> getSortAnswer(Map<String, Long> recommendScore) {
        List<String> answer = new ArrayList<>(recommendScore.keySet());
        Collections.sort(answer);
        answer.sort((o1, o2) -> (recommendScore.get(o2).compareTo(recommendScore.get(o1))));
        answer.subList(0, Math.min(5, answer.size()));
        return answer;
    }
}
