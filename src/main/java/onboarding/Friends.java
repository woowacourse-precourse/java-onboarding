package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Friends {
    private List<String> friends = new ArrayList<>();

    public Friends() {
    }

    public Friends(List<String> friends) {
        this.friends = friends;
    }

    public void add(String friend) {
        friends.add(friend);
    }

    public int sameFriendsCount(Friends other) {
        List<String> copy = new ArrayList<>(friends);
        copy.retainAll(other.friends);
        return copy.size();
    }

    public boolean notContains(String user) {
        return !friends.contains(user);
    }
}
