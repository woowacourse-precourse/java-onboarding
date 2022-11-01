package onboarding.problem7;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {

    private Set<User> users = new HashSet<>();

    public Users(List<List<String>> friends) {
        users = friends.stream().flatMap(Collection::stream).map(User::new).collect(Collectors.toSet());
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getName().equals(username))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 사용자 입니다.");
                });
    }

    public Set<User> getUsers() {
        return users;
    }
}
