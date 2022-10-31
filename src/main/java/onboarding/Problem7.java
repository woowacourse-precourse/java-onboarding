package onboarding;

import java.util.*;

public class Problem7 {
    private static class UserVerifier {

        protected static void userIdAndFriendsListVerifier(String userId, List<List<String>> friends) {
            isUserLengthThan1CharactersAndLessThan30Characters(userId);
            isUserIdConsistOfOnlyLowerAlphabet(userId);
            isFriendsLengthThan1CharactersAndLessThan10000List(friends);
        }

        protected static void isUserLengthThan1CharactersAndLessThan30Characters(String userId) {
            if (userId.length() < 1 || 30 < userId.length()) {
                throw new IllegalArgumentException("유저의 아이디는 1자 이상 30자 이하만 가능합니다.");
            }
        }

        protected static void isFriendsLengthThan1CharactersAndLessThan10000List(List<List<String>> friends) {
            if (friends.size() < 1 || 10000 < friends.size()) {
                throw new IllegalArgumentException("friends는 길이가 1 이상 10,000 이하인 리스트/배열이어야 합니다.");
            }
        }

        protected static void isEachElementLengthOf2(List<String> users) {
            if (users.size() != 2) {
                throw new IllegalArgumentException("friends의 각 원소는 길이가 2어야 합니다.");
            }
        }

        protected static void isUserIdConsistOfOnlyLowerAlphabet(String userId) {
            for (int i = 0; i < userId.length(); i++) {
                if (userId.charAt(i) < 97 && userId.charAt(i) > 122) {
                    throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자만 입력 가능합니다.");
                }
            }
        }
    }

    private static final List<String> myFriends = new ArrayList<>();
    private static final List<String> aFriendWeKnow = new ArrayList<>();
    private static final Map<String, Integer> result = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserVerifier.userIdAndFriendsListVerifier(user, friends);
        init(friends, visitors);
        friendsVerifier(user, friends);
        visitorsVerifier(visitors);
        return sortMapAndMapToList();
    }

    private static void init(List<List<String>> friends, List<String> visitors) {
        List<String> userIds = new ArrayList<>();
        for (List<String> users : friends) {
            UserVerifier.isEachElementLengthOf2(users);
            users.forEach(user -> {
                boolean result = userIds.stream()
                        .anyMatch(id -> Objects.equals(id, user));
                if (!result) {
                    userIds.add(user);
                }
            });
        }

        for (String visitor : visitors) {
            boolean result = userIds.stream()
                    .anyMatch(userId -> Objects.equals(visitor, userId));
            if (!result) {
                userIds.add(visitor);
            }
        }

        for (String userId : userIds) {
            result.put(userId, 0);
        }
    }

    private static void friendsVerifier(String myId, List<List<String>> friends) {
        saveMyFriends(myId, friends);
        for (List<String> users : friends) {
            checkFriendsOfOtherUser(users);
        }
        removeMyId(myId);
        calculationAFriendsWeNow();
    }

    private static void visitorsVerifier(List<String> visitors) {
        for (String user : visitors) {
            if (!isMyFriend(user)) {
                result.put(user, result.get(user) + 1);
            }
        }
    }

    private static void saveMyFriends(String myId, List<List<String>> friends) {
        for (List<String> users : friends) {
            for (int i = 0; i < users.size(); i++) {
                saveIfIsMyFriends(i, myId, users);
            }
        }
    }

    // 내 친구이면 저장
    private static void saveIfIsMyFriends(int i, String myId, List<String> users) {
        if (users.get(i).equals(myId)) {
            if (i == 0) {
                myFriends.add(users.get(1));
            } else {
                myFriends.add(users.get(0));
            }
        }
    }

    // 다른 유저의 친구 확인
    private static void checkFriendsOfOtherUser(List<String> users) {
        for (int i = 0; i < users.size(); i++) {
            String userId = users.get(i);
            for (String myFriendsId : myFriends) {
                saveIfIsUserKnowMyFriend(i, users, userId, myFriendsId);
            }
        }
    }

    // 만약 내 친구를 아는 유저면 저장
    private static void saveIfIsUserKnowMyFriend(int i, List<String> users, String userId, String myFriendsId) {
        if (Objects.equals(userId, myFriendsId)) {
            if (i == 0) {
                if (!isMyFriend(users.get(1))) {
                    aFriendWeKnow.add(users.get(1));
                }
            } else {
                if (!isMyFriend(users.get(0))) {
                    aFriendWeKnow.add(users.get(0));
                }
            }
        }
    }

    private static boolean isMyFriend(String userId) {
        for (String id : myFriends) {
            if (Objects.equals(id, userId)) {
                return true;
            }
        }
        return false;
    }

    private static void removeMyId(String myId) {
        for (int i = 0; i < aFriendWeKnow.size(); i++) {
            if (Objects.equals(aFriendWeKnow.get(i), myId)) {
                aFriendWeKnow.remove(i);
                i--;
            }
        }
    }

    private static void calculationAFriendsWeNow() {
        for (String user : aFriendWeKnow) {
            result.put(user, result.get(user) + 10);
        }
    }

    private static List<String> sortMapAndMapToList() {
        List<String> userRanking = new ArrayList<>();

        List<String> listKeySet = new ArrayList<>(result.keySet());
        listKeySet.sort((value1, value2) -> (result.get(value2).compareTo(result.get(value1))));
        for (String key : listKeySet) {
            if (result.get(key) != 0) {
                userRanking.add(key);
                if (userRanking.size() == 5) break;
            }
        }
        Collections.sort(userRanking);

        return userRanking;
    }
}
