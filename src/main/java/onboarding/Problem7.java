package onboarding;

import org.assertj.core.data.MapEntry;

import java.util.*;

public class Problem7 {

    public static Set<String> allUserSet = new HashSet<>();
    public static Set<String> friendSet = new HashSet<>(); // user의 친구들을 저장
    public static Map<String, Integer> usersFriends = new HashMap<>(); // 각 사용자들의 index를 저장
    public static List<List<String>> friendList = new ArrayList<>(); // 각 index에 해당하는 리스트에는 해당 사용자의 친구 목록을 저장
    public static Map<String, Integer> scores = new HashMap<>(); // 각 사용자들의 점수를 저장
    public static String targetUser; // 대상 user

    /**
     *
     * @param user1
     * @param user2
     * 친구 관계를 추가하는 함수
     */
    public static void addFriend(String user1, String user2) {
        // user1 또는 user2가 전체 사용자 목록에 없을 경우 새로 추가
        if (!allUserSet.contains(user1)) {
            allUserSet.add(user1);
            scores.put(user1, 0);
            usersFriends.put(user1, friendList.size());
            friendList.add(new ArrayList<>());
        }
        if (!allUserSet.contains(user2)) {
            allUserSet.add(user2);
            scores.put(user2, 0);
            usersFriends.put(user2, friendList.size());
            friendList.add(new ArrayList<>());
        }

        // user의 친구인 경우
        if (user1.equals(targetUser)) friendSet.add(user2);
        else if (user2.equals(targetUser)) friendSet.add(user1);

        // 친구 관계를 추가
        friendList.get(usersFriends.get(user1)).add(user2);
        friendList.get(usersFriends.get(user2)).add(user1);
    }

    /**
     *
     * @param user
     * 사용자를 입력받으면, 해당 사용자의 친구 중 user의 친구와 동일한 경우 점수를 갱신
     */
    public static void updateScoreByRelation(String user) {
        // 해당 사용자가 target 사용자의 친구이거나, target 사용자일 경우 return
        if (friendSet.contains(user) || user.equals(targetUser)) return;

        // 해당 사용자의 친구 목록을 탐색하면서 target 사용자의 친구 목록과 중복되는 경우가 있을 때 점수를 갱신
        for (String friend : friendList.get(usersFriends.get(user))) {
            if (friendSet.contains(friend)) scores.replace(user, scores.get(user) + 10);
        }
    }

    public static void updateScoreByVisit(String user) {
        // 해당 사용자가 target 사용자의 친구일 경우 return
        if (friendSet.contains(user)) return;

        // 해당 사용자가 처음 만난 사용자일 경우 새로 추가
        if (!allUserSet.contains(user)) {
            allUserSet.add(user);
            scores.put(user, 1);
            return;
        }

        // 기존 사용자일 경우, 해당 사용자의 점수를 갱신
        scores.replace(user, scores.get(user) + 1);

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        targetUser = user;
        // 1. 친구 관계 추가
        for (List<String> list : friends) {
            addFriend(list.get(0), list.get(1));
        }

        // 2. 친구 관계로 점수 산출
        for (String singleUser : allUserSet) {
            updateScoreByRelation(singleUser);
        }

        // 3. 방문자로 점수 산출
        for (String visitor : visitors) {
            updateScoreByVisit(visitor);
        }

        // 4. Map 안의 entry들을 점수를 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scores.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<String> answer = new ArrayList<>();
        int index = 0;

        // 5. 상위 5명을 추출
        while(index < entryList.size() && answer.size() < 5) {
            Map.Entry<String, Integer> current = entryList.get(index);
            if (current.getValue() == 0 || friendSet.contains(current.getKey())) {
                index++;
                continue;
            }

            answer.add(current.getKey());
            index++;

        }

        return answer;

    }
}
