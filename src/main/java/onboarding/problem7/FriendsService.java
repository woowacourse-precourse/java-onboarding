package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendsService {

    // 사용자 아이디와 친구 정보를 이용하여 사용자가 아는 친구의 수를 구한다.
    public Map<String, Integer> getRelationship(String user, List<List<String>> friends) {
        // "user가 아는 친구"를 "알고 있는 친구"를 구하자.

        // 1. user가 알고 있는 친구 : 유저 이름이 있는 리스트 조회
        List<String> knownFriends = getKnownFriends(user, friends);

        // 2. user를 알고 있는 친구를 아는 친구 조회하여, Map형태로 알고있는 인원 수를 적어준다.
        // TODO 어떻게 보면 이는 삼중 포문이다.. 방법이 없을까..?
        Map<String, Integer> results = new HashMap<>();
        for (String knownFriend : knownFriends) {
            List<String> friendsName = getKnownFriends(knownFriend, friends);  // 삼중 포문임ㅠ 방법을 찾아보자...
            for (String name : friendsName) {
                if (name.equals(user)) {
                    continue;
                }
                results.put(name, results.getOrDefault(name, 0) + 1);
            }
        }

        return results;
    }

    private List<String> getKnownFriends(String user, List<List<String>> friends) {
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
}
