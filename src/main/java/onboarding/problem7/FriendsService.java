package onboarding.problem7;

import java.util.*;

//TODO 로직 전면 개편 필요!
public class FriendsService {

    public static final int KNOWN_SCORE = 10;

    public Map<String, Integer> getRelationshipScore(String user, List<List<String>> friends) {
        Set<String> users = getNameSet(friends);  // 유저 이름 Set을 만든다.
        Map<String, Set<String>> friendsMap = getFriendsMap(friends, users);  // Map<String, Set<String>> 형태로 친구 관계를 만든다.
        List<String> knownFriends = getKnownFriends(user, friends);  // user가 아는 친구들을 구한다.

        // 공통 분모를 아는 친구를 조회하여 점수를 산정해준다.
        return evaluateScore(user, friendsMap, knownFriends);
    }

    public List<Friend> mapToFriendList(Map<String, Integer> totalScore) {
        List<Friend> result = new ArrayList<>();

        for (String name : totalScore.keySet()) {
            result.add(new Friend(name, totalScore.get(name)));
        }

        return result;
    }

    // 유저 이름 정보와 친구 관계 정보를 받아 Map<String, Set<String> 형태로 반환함.
    private Map<String, Set<String>> getFriendsMap(List<List<String>> friends, Set<String> users) {
        Map<String, Set<String>> friendsMap = new HashMap<>();
        users.forEach(name -> friendsMap.put(name, new HashSet<>()));  // map init.

        // value를 넣어준다.
        friends.forEach(list -> {
            String user1 = list.get(0);
            String user2 = list.get(1);

            friendsMap.get(user1).add(user2);
            friendsMap.get(user2).add(user1);
        });
        return friendsMap;
    }

    // 친구 관계 정보에서 이름 셋을 얻음.
    private Set<String> getNameSet(List<List<String>> friends) {
        Set<String> users = new HashSet<>();
        friends.forEach(users::addAll);
        return users;
    }

    // user를 아는 친구들 조회.
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

    private Map<String, Integer> evaluateScore(String user, Map<String, Set<String>> friendsMap, List<String> knownFriends) {
        Map<String, Integer> result = new HashMap<>();
        for (String knownFriend : knownFriends) {
            friendsMap.entrySet().stream()
                    .filter(entry -> entry.getValue().contains(knownFriend))  //value에 공통 분모가 있는 놈만 가져옴. (logn)
                    .filter(entry -> !entry.getKey().equals(user))
                    .forEach(entry -> {
                        String name = entry.getKey();
                        result.put(name, result.getOrDefault(name, 0) + KNOWN_SCORE);
                    });
        }
        return result;
    }


}
