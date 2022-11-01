package onboarding;

import java.util.*;

/**
 * Problem 7
 *
 * 기능 요구 사항
 * 1. 친추 추천 알고리즘
 *     - 사용자와 함꼐 아는 친구 = 10점
 *     - 사용자의 타임라인에 방문한 횟수 = 1점
 * 2. Param
 *     - user : 사용자 아이디
 *     - friend : 친구 관계 정보
 *     - visitor : 사용자 타임라인 방문 기록
 * 3. 점수가 가장 높은 순으로 정렬하여 최대 5명을 return
 * 4. 추천 점수가 0이면 추천 X
 * 5. 점수가 같으면 이름 순
 *
 * 제한 사항
 * 1. user의 길이 : 1~30
 * 2. friends의 길이 : 1~10,000이하의 리스트
 * 3. friends각 원소 : 길이 2인 리시트, [아이디A, 아이디B] = A와 B는 친구, 1~30아히의 길이
 * 4. visitor : 0~10,000 리스트
 * 5. 알파벳 소문자로만 이루어져 있다.
 * 6. 동일한 친구관계 중복 주어지지 않는다.
 * 7. 추천할 친구가 없는 경우는 주어지지 않는다.
 */
public class Problem7 {
    /**
     *
     * @param user
     * @param friends
     * @param visitors
     * @return 추천친구 리스트 최대 5명까지
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsMap = getFriendsMap(friends); // 친구들 맵 생성
        Map<String, Integer> possibleFriend = findPossibleFriend(friendsMap, user); // 사용자와 함께 아는 친구
        Map<String, Integer> visitorFriend = calcVisitFriend(possibleFriend, visitors, friendsMap, user); // 방문자 계산
        answer = getRecoFriend(visitorFriend); // 최종 5명 이하의 추천 친구 얻음

        return answer;
    }

    /**
     * 친구들 form을 통해 친구 관계 Map을 만드는 함수
     * @param friends
     * @return 친구 관계 Map
     */
    public static Map<String, List<String>> getFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> friend: friends) {
            if (friendsMap.containsKey(friend.get(0))) {
                friendsMap.get(friend.get(0)).add(friend.get(1));
            } else {
                friendsMap.put(friend.get(0), new ArrayList<String>(Arrays.asList(friend.get(1))));
            }

            if (friendsMap.containsKey(friend.get(1))) {
                friendsMap.get(friend.get(1)).add(friend.get(0));
            } else {
                friendsMap.put(friend.get(1), new ArrayList<String>(Arrays.asList(friend.get(0))));
            }
        }
        return friendsMap;
    }

    /**
     * user의 친구를 가져오는 함수
     * @param friendList
     * @return 유저의 친구 List
     */
    public static Set<String> getUserFriend(List<String> friendList) {
        return new HashSet<>(friendList);
    }

    /**
     * 공통으로 친구를 가지고 있는 유저들을 선정 후 점수 주는 함수
     * @param friendsMap
     * @param user
     * @return 추천 친구가 될 수 있는 친구들의 리스트 반환
     */
    public static Map<String, Integer> findPossibleFriend(Map<String, List<String>> friendsMap, String user) {
        Map<String, Integer> possibleFriend = new HashMap<>();

        for (String userFriend: friendsMap.get(user)) {
            for (String friend : friendsMap.get(userFriend)) {
                if (user.equals(friend)) {
                    continue;
                }

                if (possibleFriend.containsKey(friend)) {
                    possibleFriend.put(friend, possibleFriend.get(friend) + 10);
                } else {
                    possibleFriend.put(friend, 10);
                }
            }
        }
        return possibleFriend;
    }

    /**
     * 방문한 친구들 계산
     * @param possibleFriend
     * @param visitors
     * @param friendsMap
     * @param user
     * @return 나와 내 친구를 제외한 나한테 방문한 리스트 반환
     */
    public static Map<String, Integer> calcVisitFriend(Map<String, Integer> possibleFriend, List<String> visitors, Map<String, List<String>> friendsMap, String user) {
        Set<String> userFriend = getUserFriend(friendsMap.get(user)); // 내 친구들 생성
        for (String visitor : visitors) {
            if (possibleFriend.containsKey(visitor)) {
                possibleFriend.put(visitor, possibleFriend.get(visitor)+1);
            } else {
                if (!userFriend.contains(visitor) && !visitor.equals(user)) {
                    possibleFriend.put(visitor, 1);
                }
            }
        }
        return possibleFriend;
    }

    /**
     * 최대 5명의 추천친구 얻는 함수
     * @param calcFriend
     * @return 최종 추천 친구 5명 이하
     */
    public static List<String> getRecoFriend(Map<String, Integer> calcFriend) {
        int maxRecoFriend = 5;
        List<String> recommendFriend = new ArrayList<>();
        List<String> friendKeys = new ArrayList<>(calcFriend.keySet());
        friendKeys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int comp = calcFriend.get(o2).compareTo(calcFriend.get(o1));
                if (comp != 0) {
                    return comp;
                }
                return o1.compareTo(o2);
            }
        });

        for (String friendKey : friendKeys) {
            if (calcFriend.get(friendKey) != 0 && recommendFriend.size() < maxRecoFriend) {
                recommendFriend.add(friendKey);
            }
        }
        return recommendFriend;
    }
}
