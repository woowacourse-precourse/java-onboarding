package onboarding;

import java.util.*;

/**
 * 요구사항
 * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
 * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
 * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
 *      - 사용자와 함께 아는 친구의 수 = 10점
 *      - 사용자의 타임 라인에 방문한 횟수 = 1점
 * - user는 길이가 1 이상 30 이하인 문자열이다.
 * - friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
 * - friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
 *   - A와 B는 친구라는 의미이다.
 *   - 아이디는 길이가 1 이상 30 이하인 문자열이다.
 * - visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
 * - 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
 * - 동일한 친구 관계가 중복해서 주어지지 않는다.
 * - 추천할 친구가 없는 경우는 주어지지 않는다.
 */

/**
 * 설계
 * HashMap key: 친구,  value: 추천 점수
 * 함께 아는 친구일 때 추천 점수 + 10
 * 방문자일 때 + 1
 * 추천 점수가 높은 키 값을 순서대로 최종 retrun하는 list에 저장
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> scoreMap = new HashMap<>();

        scoreMap = friendsListMap(user, friends, visitors);
        System.out.println(scoreMap);

        return answer;
    }

    public static HashMap<String, Integer> friendsListMap(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>(); // 추천친구와 추천 점수를 저장
        HashSet<String> friend = new HashSet<>(); // 이미 친구인 친구를 저장

        // friends
        for (List<String> withFriend : friends) { // 함께 아는 친구를 map에 저장
            String friendName = withFriend.get(1);
            friend.add(withFriend.get(0));

            if (friendName == user)  // 본인일 때
                continue;
            else if (scoreMap.containsKey(friendName)) { // map에 이미 존재
                scoreMap.put(friendName, scoreMap.get(friendName)+10); // +10점
                continue;
            }
            scoreMap.put(friendName, 10);
        }

        // visitors
        for (String friendName : visitors) {  // 방문자를 map에 저장
            if(friend.contains(friendName)) { // 이미 친구일 때
                continue;
            }
            if (scoreMap.containsKey(friendName)) { // map에 이미 친구가 있을 떄
                scoreMap.put(friendName, scoreMap.get(friendName) + 1);
                continue;
            }
            scoreMap.put(friendName, 1);
        }

        return scoreMap;
    }
}