package problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    String name;

    public User(String name) {
        this.name = name;
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

        if (needConnection(User, connection)) {
            connection.put(User, cnt++);
            getFriends(friendDto).add(new ArrayList<>());
        }
        return cnt;
    }

    private boolean needConnection(String User, HashMap<String, Integer> connection) {
        return !connection.containsKey(User);
    }

    private HashMap<String, Integer> getConnection(FriendDto friendDto) {
        return friendDto.getConnection();
    }

    private List<List<String>> getFriends(FriendDto friendDto) {
        return friendDto.getFriends();
    }
}
