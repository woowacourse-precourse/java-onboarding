package onboarding.problem7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private static final String ID_REGEX = "^[a-z]*$";
    private static final int ID_MAX_LENGTH = 30;
    private static final int ID_MIN_LENGTH = 1;

    private final String id;
    private final Set<User> friends;
    private final Map<String, Integer> visitors;

    public User(String id) {
        this.id = validateId(id);
        this.friends = new HashSet<>();
        this.visitors = new HashMap<>();
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            if (!id.equals(visitor)) {
                Integer visitScore = this.visitors.getOrDefault(visitor, 0);
                this.visitors.put(visitor, visitScore + 1);
            }
        }
    }

    public Set<User> getFriends() {
        return friends;
    }

    public Map<String, Integer> getVisitors() {
        return visitors;
    }

    public String getId() {
        return id;
    }

    private String validateId(String id) {
        if (id.length() < ID_MIN_LENGTH || id.length() > ID_MAX_LENGTH) {
            throw new IllegalArgumentException("Id 는 1자 이상 30자 이하의 길이만 가능합니다.");
        }
        if (!id.matches(ID_REGEX)) {
            throw new IllegalArgumentException("Id 는 소문자만 사용 가능합니다.");
        }
        return id;
    }
}
