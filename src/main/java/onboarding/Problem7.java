package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    /**
     * 추천할 친구를 리턴해주는 메서드입니다.
     *
     * @param :
     *   - String, 유저
     *   - List<List<String>>, 친구 관계들
     *   - List<String>, 방문자
     * @return : List<Integer>, 점수에 따라 추천하는 친구들의 아이디
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendConnection = setConnection(friends);
        Map<String, Integer> friendScore = calculateScore(user, friendConnection, visitors);
        List<String> answer = selectTop5(friendScore);

        return answer;
    }

    /**
     * 친구 관계를 Map으로 정리하여 리턴하는 메서드 입니다.
     *
     * @param : List<List<String>>, 친구 관계들
     * @return : Map<String, Set<String>>, Map으로 정리된 친구 관계. Key가 아이디, Value가 Set<String>. Value에는 그 사람과 친구인 사람의 아이디
     */
    public static Map<String, Set<String>> setConnection(List<List<String>> friends) {
        Map<String, Set<String>> answer = new HashMap<>();

        for (List<String> connection : friends) {
            String friendA = connection.get(0);
            String friendB = connection.get(1);

            if (!answer.containsKey(friendA)) answer.put(friendA, new HashSet<>());
            if (!answer.containsKey(friendB)) answer.put(friendB, new HashSet<>());

            answer.get(friendA).add(friendB);
            answer.get(friendB).add(friendA);
        }

        return answer;
    }

    /**
     * 친구 관계와, 방문자를 보고 점수를 구해주는 메서드
     *
     * @param :
     *   - Map<String, Set<String>>, Map으로 정리된 친구 관계. Key가 아이디, Value가 Set<String>. Value에는 그 사람과 친구인 사람의 아이디
     *   - List<String>, 방문자
     * @return : Map<String, Integer>, Map으로 정리된 아이디와 점수. Key가 아이디, Value가 점수
     */
    public static Map<String, Integer> calculateScore(String userId, Map<String, Set<String>> friendConnection, List<String> visitors) {
        Map<String, Integer> answer = new HashMap<>();
        Set<String> userFriend = friendConnection.get(userId);
        if (userFriend == null) userFriend = new HashSet<>();

        for (String friendId : friendConnection.keySet()) {
            if (userId == friendId) continue;
            if (userFriend.contains(friendId)) continue;

            int sameFriendCnt = 0;
            Set<String> friendFriend = friendConnection.get(friendId);

            if (userFriend.size() < friendFriend.size()) {
                for (String friend : userFriend) {
                    if (friendFriend.contains(friend)) sameFriendCnt++;
                }
            } else {
                for (String friend : friendFriend) {
                    if (userFriend.contains(friend)) sameFriendCnt++;
                }
            }

            if (sameFriendCnt != 0) answer.put(friendId, sameFriendCnt * 10);
        }

        for (String visitor : visitors) {
            if (userFriend.contains(visitor)) continue;

            if (!answer.containsKey(visitor)) answer.put(visitor, 1);
            else answer.put(visitor, answer.get(visitor) + 1);
        }

        return answer;
    }

    /**
     * 추천해줄 친구를 뽑아주는 메서드
     *
     * @param : Map<String, Integer>, Map으로 정리된 아이디와 점수. Key가 아이디, Value가 점수
     * @return : List<String>, 추천할 친구들의 아이디
     */
    public static List<String> selectTop5(Map<String, Integer> friendScore) {
        List<String> answer = new LinkedList<>();

        List<Entry<String, Integer>> sortedFriendScore = new ArrayList<>(friendScore.entrySet());
        Collections.sort(sortedFriendScore, (f1, f2) -> {
            int comp = Integer.compare(f2.getValue(), f1.getValue());
            if (comp == 0) comp = f1.getKey().compareTo(f2.getKey());
            return comp;
        });

        int idx = 0;
        for (Entry<String, Integer> friend : sortedFriendScore) {
            answer.add(friend.getKey());

            if (idx == 4) break;
            else idx++;
        }

        return answer;
    }
}
