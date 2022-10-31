package problem7;

import java.util.*;

public class FriendConnectionRepository {
    private static final Map<String, Set<String>> friendConnection = new HashMap<>();

    private FriendConnectionRepository() {}

    public static void create(List<List<String>> friends) {
        friendConnection.clear();

        preprocessFriendConnection(friends);

        configureFriendConnection(friends);
    }

    private static void preprocessFriendConnection(List<List<String>> friendsList) {
        friendsList.stream()
                .flatMap(Collection::stream)
                .distinct()
                .filter(user -> !friendConnection.containsKey(user))
                .forEach(user -> friendConnection.put(user, new HashSet<>()));
    }

    private static void configureFriendConnection(List<List<String>> friendsList) {
        friendsList.forEach(friends -> {
                    var first = friends.get(0);
                    var second = friends.get(1);

                    friendConnection.get(first).add(second);
                    friendConnection.get(second).add(first);
                });
    }

    public static void addUsers(List<String> users) {
        users.stream()
                .filter(user -> !friendConnection.containsKey(user))
                .forEach(user -> friendConnection.put(user, new HashSet<>()));
    }

    public static Set<String> getFriends(String user) {
        return friendConnection.get(user);
    }

    public static Set<String> getUsers() {
        return friendConnection.keySet();
    }
}
