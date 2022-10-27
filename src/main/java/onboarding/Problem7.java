package onboarding;

import org.mockito.internal.util.collections.Sets;

import java.util.*;
import java.util.stream.Collectors;

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

        public User(String name, int score) {
            this.name = name;
            this.score = score;
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

        public List<String> getVisitor() {
            return visitor;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }

    public static Map<String, User> repository = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> newFriendMap = new HashMap<>(); // map 으로 구현하는게 좋을까 arrayList<User> 로 구현하는게 좋을까?
        List<String> answer;

        initFriend(friends);


        User userInstance = repository.get(user);
        userInstance.setVisitor(visitors); // init visitor

        calculateSameFriendScore(user, newFriendMap);
        calculateVisitorScore(user, newFriendMap);

        answer = getFilteredResult(newFriendMap);
        return answer;
    }

    private static List<String> getFilteredResult(Map<String, Integer> newFriendMap) {
        List<User> store = new ArrayList<>();

        for (String key : newFriendMap.keySet()){
            store.add(new User(key, newFriendMap.get(key)));
        }
        List<String> collect = store.stream()
                .filter(user -> user.getScore() > 0)
                .sorted(Comparator.comparing(User::getScore).reversed().thenComparing(Comparator.comparing(User::getName)))
                .map(User::getName)
                .collect(Collectors.toList());
        return collect;
    }

    private static void calculateVisitorScore(String user, Map<String, Integer> newFriendMap){
        User userInstance = repository.get(user);
        List<String> visitors = userInstance.getVisitor();

        for (String name : visitors){
            if (!userInstance.isFriend(name)){
                newFriendMap.put(name, newFriendMap.getOrDefault(name, 0) + 1);
            }
        }
    }

    private static void calculateSameFriendScore(String user, Map<String, Integer> newFriendMap) {
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
