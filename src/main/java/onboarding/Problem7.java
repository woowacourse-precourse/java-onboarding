package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 기능 목록
 * 1. 함께 아는 친구들 처리. -> [user 의 친구를 먼저 찾고, 친구의 친구를 찾아서 등록 해줘야 한다.]
 * 2. 타임 라인 방문한 친구들 처리
 * 3. 점수를 매겨서,
 * 4. 순서대로 list 에 넣어주기.
 * 5. 기존의 친구들도 제외 해주어야한다. (나 자신도 제외.)
 */
public class Problem7 {

    public static Map<String, Integer> algorithmCandidate = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p7 = new Problem7();
        p7.addCandidateFriends(user, friends);
        p7.addCandidateVisitors(visitors);
        p7.remove(user, friends);

        return p7.getAnswer();
    }

    public void remove(String user, List<List<String>> friends) {
        removeUserFriend(user, friends);
        removeUser(user);
    }

    private void removeUserFriend(String user, List<List<String>> friends) {
        List<String> userFriends = findUserFriends(user, friends);
        for (String userFriend : userFriends) {
            algorithmCandidate.remove(userFriend);
        }
    }

    private void removeUser (String user) {
        algorithmCandidate.remove(user);
    }

    public void addCandidateVisitors(List<String> visitors) {
        addCandidateIterList(visitors, 1);
    }

    public void addCandidateFriends(String user, List<List<String>> friends) {
        List<String> userFriends = findUserFriends(user, friends);
        for (String userFriend : userFriends) {
            List<String> list = findUserFriends(userFriend, friends);
            addCandidateIterList(list, 10);
        }
    }

    public List<String> getAnswer() {
        // Map.Entry 리스트 작성
        ArrayList<Map.Entry<String, Integer>> list_entries = new ArrayList<>(algorithmCandidate.entrySet());
        Set<String> answer = new HashSet<>();

        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                // 오름 차순 정렬
                return obj1.getValue().compareTo(obj2.getValue());
            }
        }.reversed());

        for (Map.Entry<String, Integer> list_entry : list_entries) {
            for (int i = 0; i < 5; i++) {
                answer.add(list_entry.getKey());
            }
        }
        return answer.stream().collect(Collectors.toList());
    }

    private List<String> findUserFriends(String user, List<List<String>> list) {
        List<String> friends = new ArrayList<>();
        for (List<String> friendList : list) {
            if (checkUserFriend(user, friendList)) {
                friends.add(getUserFriend(user, friendList));
            }
        }
        return friends;
    }

    private String getUserFriend(String user, List<String> list) {
        for (String name : list) {
            if (!(user.equals(name))) {
                return name;
            }
        }
        return "";
    }

    private boolean checkUserFriend(String user, List<String> list) {
        for (String name : list) {
            if (user.equals(name)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private boolean checkMapIfExist(String name) {
        if (algorithmCandidate.containsKey(name)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void addCandidateIterList(List<String> list, int score) {
        for (String s : list) {
            if (checkMapIfExist(s)) {
                algorithmCandidate.replace(s, algorithmCandidate.get(s), algorithmCandidate.get(s) + score);
            }
            algorithmCandidate.put(s, score);
        }
    }
}
