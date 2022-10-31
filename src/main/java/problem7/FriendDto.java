package problem7;

import java.util.HashMap;
import java.util.List;

public class FriendDto {
    private HashMap<String, Integer> connection;
    private List<List<String>> friends;

    public FriendDto(HashMap<String, Integer> connection, List<List<String>> friendList) {
        this.connection = connection;
        this.friends = friendList;
    }

    public HashMap<String, Integer> getConnection() {
        return connection;
    }

    public List<List<String>> getFriends() {
        return friends;
    }
}
