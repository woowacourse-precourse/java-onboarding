package onboarding.problem7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public List<String> getRecommendFriendsRankingFive() {
        return users.stream()
                .takeWhile(Objects::nonNull)
                .sorted(Comparator.comparing(User::getVisits).reversed())
                .limit(5)
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public User findUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElseGet(() -> {
                    User user = new User(name);
                    users.add(user);
                    return user;
                });
    }
}
