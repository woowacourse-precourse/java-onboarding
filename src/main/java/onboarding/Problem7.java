package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class User{
    private String id;
    private List<User> friends = new ArrayList<>();
    private int point;

    public User(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public String getId() {
        return id;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addOnePoint() {
        this.point += 1;
    }

    public void addTenPoint() {
        this.point += 10;
    }

    public int getPoint() {
        return point;
    }

}
