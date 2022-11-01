package onboarding;

import java.util.*;

/**
 * 1. 모든 사용자의 친구 리스트를 만든다.
 * 2. 타겟 사용자의 친구 리스트를 뒤져, 그 친구의 친구라면 10점씩 더한다.
 */
public class Problem7 {
    static Map<String, User> friendMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

       friendMap = new HashMap<>();

        for (List<String> friend : friends) {
            if (isNotExistUser(friend.get(0))) {
                friendMap.put(friend.get(0), new User(friend.get(0)));
            }
            if (isNotExistUser(friend.get(1))) {
                friendMap.put(friend.get(1), new User(friend.get(1)));
            }

            friendMap.get(friend.get(0)).addFriend(friend.get(1));
            friendMap.get(friend.get(1)).addFriend(friend.get(0));
        }

        List<User> targetFriends = friendMap.get(user).getFriends();
        List<User> userList = new ArrayList<>(friendMap.values());

        for (String visitor : visitors) {
            if (isNotExistUser(visitor)) friendMap.put(visitor, new User(visitor));
            if (!userList.contains(friendMap.get(visitor))) userList.add(friendMap.get(visitor));
            friendMap.get(visitor).addVisitorScore();
        }

        for (User targetFriend : targetFriends) {
            // fSF : friend's friend
            for (User fsF : targetFriend.getFriends()) {
                fsF.addFriendScore();
            }
            userList.remove(targetFriend);
        }

        Collections.sort(userList);
        List<String> answer = new ArrayList<>();

        int cnt = 0;
        for (User tf : userList) {
            if (tf.isZeroScore()) continue;
            if (tf.equals(friendMap.get(user))) continue;
            answer.add(tf.name);
            if (cnt == 5) break;
        }

        return answer;
    }

    public static boolean isNotExistUser(String name) {
        return !friendMap.containsKey(name);
    }

    static class User implements Comparable<User>{
        private String name;
        private List<User> friends;
        private int score;

        public User(String name) {
            this.name = name;
            this.friends = new ArrayList<>();
            this.score = 0;
        }

        public void addFriend(String friendName) {
            if (!friendMap.containsKey(friendName)) friendMap.put(friendName, new User(friendName));

            User friend = friendMap.get(friendName);
            friends.add(friend);
        }

        public void addVisitorScore() {
            this.score += 1;
        }

        public void addFriendScore() {
            this.score += 10;
        }

        public List<User> getFriends() {
            return friends;
        }

        public boolean isZeroScore() {
            return this.score == 0;
        }


        @Override
        public int compareTo(User u) {
            if (this.score < u.score) return 1;
            if (this.score > u.score) return -1;
            if (this.score == u.score) {
                if (this.name.compareTo(u.name) < 0) return -1;
                return 1;
            }
            return 0;
        }
    }
}
