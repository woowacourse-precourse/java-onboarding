package onboarding;

import org.mockito.internal.util.collections.Sets;

import java.util.*;

public class Problem7 {
    static class User{
        private final String name;
        private List<String> friends;
        private List<String> visitor;
        private int score;

        public User(String name) {
            this.name = name;
            this.friends = new ArrayList<>();
            this.visitor = new ArrayList<>();
            this.score = 0;
        }

        public boolean isFriend(String name){
            if (friends.contains(name)){
                return true;
            }
            return false;
        }

        public void addFriend(String name){
            friends.add(name);
        }

        public void setVisitor(List<String> visitor) {
            this.visitor = visitor;
        }

        public List<String> getFriends() {
            return friends;
        }

    }

    public static Map<String, User> repository = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> newFriendMap = new HashMap<>();

        initFriend(friends);


        User userInstance = repository.get(user);
        userInstance.setVisitor(visitors); // init visitor

        setSameFriendScore(user, newFriendMap);


        return answer;
    }

    private static void setVisitorScore(String user, Map<String, Integer> newFriendMap){

    }

    private static void setSameFriendScore(String user, Map<String, Integer> newFriendMap) {
        User userInstance = repository.get(user);
        repository.forEach((name, userObj) -> {
            if (!name.equals(user) && !userObj.isFriend(name)){
                newFriendMap.put(name, getSameFriendCount(userInstance, userObj) * 10);
            }
        });
    }

    private static int getSameFriendCount(User userA, User userB){
        List<String> userAFriends = userA.getFriends();
        List<String> userBFriends = userB.getFriends();
        List<String> mergeFriends = new ArrayList<>();

        mergeFriends.addAll(userAFriends);
        mergeFriends.addAll(userBFriends);
        Set<String> nameSet = new HashSet<>(mergeFriends);
        return mergeFriends.size() - nameSet.size();
    }

    private static setFriendScore()

    private static void initFriend(List<List<String>> friends) {
        for (List<String> friend : friends){
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            setFriendToMap(friendA, friendB);
        }
    }

    private static void setFriendToMap(String friendA, String friendB) {
        User tmpUser;

        tmpUser = repository.getOrDefault(friendA, new User(friendA));
        tmpUser.addFriend(friendB);
        repository.put(friendA, tmpUser);

        tmpUser = repository.getOrDefault(friendB, new User(friendB));
        tmpUser.addFriend(friendA);
        repository.put(friendB, tmpUser);
    }
}
