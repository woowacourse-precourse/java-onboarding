package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getRecommendList(user, friends, visitors);
        return answer;
    }

    /**
     * 사용자의 아이디와 친구관계 정보, 사용자 타임라인 방문 기록으로 추천 친구 리스트를 반환
     * @param user : 사용자의 아이디
     * @param friends : 친구 관계 정보
     * @param visitors : 사용자 타임라인 방문 기록
     * @return 적합한 순서대로 정렬 된 추천 친구 리스트 (최대 5개)
     */
    private static List<String> getRecommendList(String user,List<List<String>> friends ,List<String> visitors){
        // 친구 관계 정보가 담긴 맵을 받아옴
        Map<String , Set<String>> friendMap = getFriendsMap(friends);
        // 유저별 추천 점수 정보가 담긴 맵을 초기화
        Map<String , Integer> recommendScoreMap = new HashMap<>();

        // 친구관계로 추천 점수 정보맵 갱신
        setFriendsScore(user, friendMap, recommendScoreMap);
        // 방문기록으로 추천 점수 정보맵 갱신
        setVisitorScore(visitors, recommendScoreMap);
        // 자신과 이미 친구인 유저를 추천 점수 정보에서 제외
        deleteUserAndFriends(user ,friendMap, recommendScoreMap);

        // 추천 점수 정보맵으로 추천 친구 리스트를 받아옴
        List<String> result = getRecommendListByScoreMap(recommendScoreMap);

        return result;
    }

    /**
     * 친구 관계 정보를 받아 친구 관계 맵을 만들어 반환
     * @param friends : 친구 관계 정보
     * @return 친구 관계 정보로 만들어진 친구 관계 맵
     */
    private static Map<String , Set<String>> getFriendsMap(List<List<String>> friends){
        Map<String, Set<String>> result = new HashMap<>();
        for(List<String> friend : friends){
            // 0번 인덱스에 저장된 유저의 친구관계를 저장
            if (result.containsKey(friend.get(0))){
                result.get(friend.get(0)).add(friend.get(1));
            } else {
                // key에 처음 접근하는 경우 새로운 Set을 할당해줌
                result.put(friend.get(0), new HashSet<>(List.of(friend.get(1))));
            }
            // 1번 인덱스에 저장된 유저의 친구관계를 저장
            if (result.containsKey(friend.get(1))){
                result.get(friend.get(1)).add(friend.get(0));
            } else {
                // key에 처음 접근하는 경우 새로운 Set을 할당해줌
                result.put(friend.get(1), new HashSet<>(List.of(friend.get(0))));
            }
        }
        return result;
    }

    /**
     * 유저 이름과 친구 관계 맵을 받아 추천 점수 맵에 등록
     * @param user : 추천을 받을 대상 유저
     * @param friendsMap : 친구 관계 맵
     * @param recommendScoreMap : 점수를 갱신할 추천 점수 맵
     */
    private static void setFriendsScore(String user, Map<String, Set<String>> friendsMap , Map<String , Integer> recommendScoreMap){
        friendsMap.get(user).forEach(friend -> {
            friendsMap.get(friend).forEach(friendsfriend -> {
                // 친구의 친구에게는 10점을 추가 함.
                addScore(friendsfriend, 10, recommendScoreMap);
            });
        });
    }

    /**
     * 타임라인 방문자 기록을 받아 추천 점수 맵에 등록
     * @param visitors : 타임라인 방문자 기록
     * @param recommendScoreMap : 점수를 갱신할 추천 점수 맵
     */
    private static void setVisitorScore(List<String > visitors, Map<String, Integer> recommendScoreMap){
        visitors.forEach(visitor -> {
            // 방문자에게는 1점을 추가함
            addScore(visitor, 1, recommendScoreMap);
        });
    }

    /**
     * 추천 점수 맵에 점수를 등록
     * @param recommendUser : 점수를 올릴 유저
     * @param score : 올릴 점수
     * @param recommendScoreMap : 점수를 갱신할 추천 점수 맵
     */
    private static void addScore(String recommendUser, int score, Map<String , Integer> recommendScoreMap){
        recommendScoreMap.put(
                recommendUser,
                recommendScoreMap.get(recommendUser) != null ? recommendScoreMap.get(recommendUser) + score : score
        );
    }

    /**
     * 추천 점수 맵에서 자신과 이미 등록된 친구를 삭제
     * @param user : 추천 대상 유저
     * @param friendsMap : 친구 관계 맵
     * @param recommendScoreMap : 유저별 추천 점수가 등록된 맵
     */
    private static void deleteUserAndFriends(String user, Map<String, Set<String>> friendsMap, Map<String, Integer> recommendScoreMap){
        // 자신은 추천대상에서 제외
        recommendScoreMap.remove(user);
        // 이미 등록된 친구는 추천 대상에서 제외
        friendsMap.get(user).forEach(friend -> {
            recommendScoreMap.remove(friend);
        });
    }

    /**
     * 추천 점수 맵의 점수가 높은 유저 순으로 추천 유저 리스트를 반환
     * @param recommendScoreMap : 유저별 추천 점수가 등록된 맵
     * @return 추천 유저 리스트
     */
    private static List<String> getRecommendListByScoreMap(Map<String, Integer> recommendScoreMap){
        // 결과 리스트 초기화
        List<String> result = new ArrayList<>();

        // 더 이상 추천할 유저가 없거나 5명을 추천했으면 종료
        while (!recommendScoreMap.isEmpty() && result.size() < 5){
            // 최고 점수를 가진 유저를 리스트에 등록
            String maxScoreUser = Collections.max(recommendScoreMap.entrySet(),
                    Comparator.comparingInt(Map.Entry::getValue)
            ).getKey();
            result.add(maxScoreUser);
            // 해당 유저를 추천 유저 맵에서 제외
            recommendScoreMap.remove(maxScoreUser);
        }

        return result;
    }
}
