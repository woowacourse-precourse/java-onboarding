package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    static final Integer USER_A = 0;
    static final Integer USER_B = 1;
    static final Integer MAX_LENGTH = 5;
    static final Integer VISIT_SCORE = 1;
    static final Integer FRIEND_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        UserDatabase.insert(user);

        // 친구 관계 데이터 가공
        for (List<String> friendPair : friends) {
            String nameA = friendPair.get(USER_A);
            String nameB = friendPair.get(USER_B);

            UserDatabase.saveFriendRelationship(nameA, nameB);
        }

        // 방문 기록 데이터에 따라 점수 반영
        for (String visitorName : visitors) {

            User findUser = UserDatabase.findByName(visitorName);

            if (findUser == null) {
                findUser = UserDatabase.insert(visitorName);
            }

            findUser.score += VISIT_SCORE;
        }

        List<User> userFriends = UserDatabase.getFriends(user);
        List<User> allUsers = UserDatabase.getAllUsers();

        for (User u : allUsers) {
            if (u.name != user) {
                List<User> uFriends = u.friends;
                // 'user의 친구 목록'과 '비교 대상의 친구 목록'을 교집합 -> 공통으로 아는 친구 목록 도출
                uFriends.retainAll(userFriends);
                u.score += uFriends.size() * FRIEND_SCORE;
            }
        }

        List<User> candidates = new ArrayList<>();

        for (User u : allUsers) {
            if (u.name != user) {
                Integer uScore = u.score;
                // 비교 대상이 user와 직접 친구가 아니고, 비교 대상의 점수가 0점이 아니면 후보 목록에 추가
                if (!userFriends.contains(u) && uScore != 0) {
                    candidates.add(u);
                }
            }
        }

        UserDatabase.clear();
        candidates.sort(new ResultComparator());

        if (candidates.size() > MAX_LENGTH) {
            candidates = candidates.subList(0, MAX_LENGTH - 1);
        }

        return candidates.stream().map(result -> result.name).collect(Collectors.toList());
    }

    static class UserDatabase {
        static Map<String, User> userDatabase = new HashMap<>();

        static User insert(String username) {
            User user = new User(username);

            userDatabase.put(username, user);

            return user;
        }

        static void saveFriendRelationship(String nameA, String nameB) {
            User userA = findByName(nameA);
            User userB = findByName(nameB);

            if (userA == null) {
                userA = insert(nameA);
            }

            if (userB == null) {
                userB = insert(nameB);
            }

            userA.addFriend(userB);
            userB.addFriend(userA);
        }

        static void clear() {
            userDatabase = new HashMap<>();
        }

        static User findByName(String username) {
            return userDatabase.get(username);
        }

        static List<User> getFriends(String username) {
            return findByName(username).friends;
        }

        public static List<User> getAllUsers() {
            List<User> users = new ArrayList<>();
            for (User user : userDatabase.values()) {
                users.add(user);
            }
            return users;
        }
    }

    static class User {
        private String name;
        private List<User> friends;
        private Integer score;


        public User(String name) {
            this.name = name;
            this.friends = new ArrayList<>();
            this.score = 0;
        }

        public void addFriend(User friend) {
            this.friends.add(friend);
        }
    }

    static class ResultComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            if (o1.score > o2.score) {
                return -1;
            } else if (o1.score < o2.score) {
                return 1;
            } else if (o1.score == o2.score) {
                return (o1.name.compareTo(o2.name));
            }
            return 0;
        }
    }
}
