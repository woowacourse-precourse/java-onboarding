package onboarding.problem7;

import java.util.*;

public class FriendsService {

    public static final int KNOWN_SCORE = 10;

    // 사용자 아이디와 친구 정보를 이용하여 사용자가 아는 친구의 수를 구한다.
    public Map<String, Integer> getRelationshipScore(String user, List<List<String>> friends) {
        // 1. user가 알고 있는 친구 : 유저 이름이 있는 리스트 조회
        List<String> knownFriends = getKnownFriends(user, friends);

        // 2. user를 알고 있는 친구를 아는 친구 조회하여, Map형태로 알고있는 인원 수를 적어준다.
        Map<String, Integer> results = new HashMap<>();
        for (String knownFriend : knownFriends) {
            // 알고 있는 친구 조회
            List<String> friendsName = getKnownFriends(knownFriend, friends);  // 삼중 포문임ㅠ 방법을 찾아보자...
            for (String name : friendsName) {  // 알고 있는 친구의 이름을 조회해서
                if (name.equals(user)) {  // 유저랑 같으면 continue
                    continue;
                }
                // 유저랑 다르면 점수를 산정함.
                results.put(name, (results.getOrDefault(name, 0) + KNOWN_SCORE));  // 점수를 산정
            }
        }

        return results;
    }

    public List<String> getKnownFriends(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>();  // user를 알고 있는 친구.
        friends.stream()
                .filter(list -> list.contains(user))  // 유저 이름이 들어있는 리스트
                .forEach(list -> {
                    for (String name : list) {
                        if (!name.equals(user)) {
                            friendsOfUser.add(name);
                        }
                    }
                });

        return friendsOfUser;
    }

    // map을 List<Friend>로 바꿔주는 로직
    public List<Friend> mapToFriendList(Map<String, Integer> totalScore) {
        List<Friend> result = new ArrayList<>();

        for (String name : totalScore.keySet()) {
            result.add(new Friend(name, totalScore.get(name)));
        }

        return result;
    }
}
