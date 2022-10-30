package problem7;

import java.util.ArrayList;
import java.util.List;

public class Friend {

    private final List<String> friends;

    public Friend() {
        friends = new ArrayList<>();
    }

    public void add(String userId) {
        friends.add(userId);
    }

    public boolean hasFriend(String userId) {
        return friends.contains(userId);
    }
}
