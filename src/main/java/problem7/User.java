package problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    private void checkHaveSameFriends(FriendDto friendDto, boolean[] isFriend, HashMap<String, Integer> score) {
        if (hasConnection(name, getConnection(friendDto))) {
            check(isFriend, score, friendDto);
        }
    }

    private void check(boolean[] isFriend, HashMap<String, Integer> score, FriendDto friendDto) {
        HashMap<String, Integer> connection = getConnection(friendDto);
        List<List<String>> friends = getFriends(friendDto);
        int userId = getUserId(name, connection);
        isFriend[userId] = true;
        List<String> userFriends = friends.get(userId);
        
        for (int i = 0; i < userFriends.size(); i++) {
            int friendId = getUserId(getFriend(userFriends, i), connection);
            isFriend[friendId] = true;
            List<String> friendFriends = friends.get(friendId);

            addScore(score, friendFriends);
        }
    }

    private void addScore(HashMap<String, Integer> score, List<String> friendFriends) {
        for (int j = 0; j < friendFriends.size(); j++) {
            String friend = getFriend(friendFriends, j);
            score.put(friend, score.getOrDefault(friend, 0) + 10);
        }
    }

    private int addFriends(List<List<String>> friends, FriendDto friendDto, int cnt) {
        for (List<String> relationship : friends) {
            String leftUser = getFriend(relationship, 0);
            String rightUser = getFriend(relationship, 1);

            cnt = setConnection(friendDto, cnt, leftUser);
            cnt = setConnection(friendDto, cnt, rightUser);

            addFriend(friendDto, leftUser, rightUser);
            addFriend(friendDto, rightUser, leftUser);
        }
        return cnt;
    }

    private String getFriend(List<String> friends, int index) {
        return friends.get(index);
    }

    private Integer getUserId(String user, HashMap<String, Integer> connection) {
        return connection.get(user);
    }

    private void addFriend(FriendDto friendDto, String leftUser, String rightUser) {
        getFriends(friendDto).get(getUserId(leftUser, getConnection(friendDto))).add(rightUser);
    }

    private int setConnection(FriendDto friendDto, int cnt, String User) {
        HashMap<String, Integer> connection = getConnection(friendDto);

        if (!hasConnection(User, connection)) {
            connection.put(User, cnt++);
            getFriends(friendDto).add(new ArrayList<>());
        }
        return cnt;
    }

    private boolean hasConnection(String User, HashMap<String, Integer> connection) {
        return connection.containsKey(User);
    }

    private HashMap<String, Integer> getConnection(FriendDto friendDto) {
        return friendDto.getConnection();
    }

    private List<List<String>> getFriends(FriendDto friendDto) {
        return friendDto.getFriends();
    }
}
