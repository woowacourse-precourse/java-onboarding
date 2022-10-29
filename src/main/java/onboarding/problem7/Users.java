package onboarding.problem7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static onboarding.problem7.Constance.*;
import static onboarding.problem7.User.*;

public class Users {

    private final List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public List<String> getRecommendFriendsRankingFive(List<String> userFriends) {
        return users.stream()
                .takeWhile(Objects::nonNull)
                .filter(user -> !userFriends.contains(user.getName()))
                .sorted(Comparator.comparing(User::getScore).reversed())
                .limit(RANKING_MAX_SIZE)
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public User findUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElseGet(() -> {
                    User user = createUser(name);
                    users.add(user);
                    return user;
                });
    }
}
