/**
 * 기능 요구 사항:
 * 사용자와 함께 아는 친구의 수 = 10점
 * 사용자의 타임 라인에 방문한 횟수 = 1점
 * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
 * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
 * <p>
 * 제한사항:
 * 1. user는 길이가 1 이상 30 이하인 문자열이다.
 * 2. friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
 * 3. friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
 * 3-1. A와 B는 친구라는 의미이다.
 * 3-2. 아이디는 길이가 1 이상 30 이하인 문자열이다.
 * 4. visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
 * 5. 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
 * 6. 동일한 친구 관계가 중복해서 주어지지 않는다.
 * 7. 추천할 친구가 없는 경우는 주어지지 않는다.
 * <p>
 * 기능 목록:
 * 1. 점수를 계산할 모든 유저네임을 담고있는 Map 구현 (key=유저네임 : value=점수)
 * 2. 주어진 friends를 탐색하며 점수를 계산하고 1.의 Map에 업데이트하는 메서드
 * 3. visitors에서 타임라인을 방문한 user들의 점수를 계산하고 1.의 Map에 업데이트하는 메서드
 * 4. 추천 친구를 골라내어 저장한 리스트를 반환하는 메서드
 */

package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        Map<String, Integer> userScore = getNewUserScoreMap(friends, visitors);
        addScoreFromFriends(user, friends, userScore);
        addScoreFromVisitors(visitors, userScore);
        userScore.remove(user);
        answer = getRecommendedFriendsList(user, friends,userScore);

        return answer;
    }

    /**
     * 추천 친구 목록을 만드는 메서드
     * @param user 추천을 받는 user의 ID
     * @param userScore user ID와 점수가 저장되어있는 Map 인스턴스
     * @return 추천 친구 목록 List
     */
    private static List<String> getRecommendedFriendsList(String user, List<List<String>> friends, Map<String, Integer> userScore) {
        List<String> recommendedFriends = new ArrayList<>();
        List<String> userFriendsList = getUserFriendsList(user, friends);
        Map.Entry<String, Integer> recommended;
        Map.Entry<String, Integer> currentCheckingEntry;
        Map.Entry<String, Integer> nextEntry;

        for (String userFriend : userScore.keySet()) {
            if (userScore.get(userFriend).equals(0)) {
                userScore.remove(userFriend);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(userScore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        while(recommendedFriends.size() < 5 && entryList.size() > 0) {
            recommended = entryList.get(0);

            for (int i = 1; i < entryList.size() - 1; i++) {
                currentCheckingEntry = entryList.get(i);
                nextEntry = entryList.get(i + 1);

                if (currentCheckingEntry.getValue().equals(recommended.getValue())
                        && (currentCheckingEntry.getKey().compareTo(recommended.getKey()) < 0)) {
                    recommended = currentCheckingEntry;
                } else if (currentCheckingEntry.getValue() > nextEntry.getValue()) {
                    break;
                }
            }

            if (!userFriendsList.contains(recommended.getKey())) {
                recommendedFriends.add(recommended.getKey());
            }
            entryList.remove(recommended);
        }

        return recommendedFriends;
    }

    /**
     * 모든 User ID에 대해 점수가 0으로 초기화된 Map 인스턴스를 생성하고 반환하는 메서드
     *
     * @param friends 친구 관계 정보 List
     * @param visitors 방문자 List
     * @return 모든 user ID에 대해 점수가 0으로 초기화된 Map 인스턴스
     */
    private static Map<String, Integer> getNewUserScoreMap(List<List<String>> friends, List<String> visitors) {
        Set<String> userSet = new HashSet<>();
        Map<String, Integer> userScoreMap = new HashMap<>();

        for (List<String> friendsPair : friends) {
            userSet.addAll(friendsPair);
        }
        userSet.addAll(visitors);

        for (String user : userSet) {
            userScoreMap.put(user, 0);
        }

        return userScoreMap;
    }

    /**
     * 친구 추천을 받을 user와 이미 친구인 ID의 List를 반환하는 메서드
     *
     * @param user 친구 추천을 받을 user ID
     * @param friends 친구 관계 정보 List
     * @return 매개변수로 전달된 user와 친구 관계에 있는 user ID의 List
     */
    private static List<String> getUserFriendsList(String user, List<List<String>> friends) {
        List<String> userFriendsList = new ArrayList<>();

        for (List<String> friendsPair : friends) {
            if (friendsPair.get(0).equals(user)) {
                userFriendsList.add(friendsPair.get(1));
            } else if (friendsPair.get(1).equals(user)) {
                userFriendsList.add(friendsPair.get(0));
            }
        }

        return userFriendsList;
    }

    /**
     * 매개변수로 주어지는 friends로부터 점수를 계산하여 userScore에 업데이트하는 메서드
     *
     * @param user 친구 추천을 받을 user ID
     * @param friends 친구 관계 정보 List
     * @param userScore 각 user ID의 점수를 저장하는 Map 인스턴스
     */
    private static void addScoreFromFriends(String user, List<List<String>> friends, Map<String, Integer> userScore) {
        String scoredFriend;
        List<String> userFriends = getUserFriendsList(user, friends);

        for (List<String> friendsPair : friends) {
            if (userFriends.contains(friendsPair.get(0)) && !(friendsPair.get(1).equals(user))) {
                scoredFriend = friendsPair.get(1);
                userScore.replace(scoredFriend, userScore.get(scoredFriend) + 10);
            } else if (userFriends.contains(friendsPair.get(1)) && !(friendsPair.get(0).equals(user))) {
                scoredFriend = friendsPair.get(0);
                userScore.replace(scoredFriend, userScore.get(scoredFriend) + 10);
            }
        }
    }

    /**
     * 매개변수로 주어지는 visitors로부터 점수를 계산하여 userScore에 업데이트하는 메서드
     *
     * @param visitors 방문자 목록
     * @param userScore 각 user ID의 점수를 저장하는 Map 인스턴스
     */
    private static void addScoreFromVisitors(List<String> visitors, Map<String, Integer> userScore) {
        for (String visitor : visitors) {
            userScore.replace(visitor, userScore.get(visitor) + 1);
        }
    }

}
