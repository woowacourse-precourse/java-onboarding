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

    public void create(List<String> names) {
        for(String name : names) {
            users.add(new User(name, 0, false));
        }
    }

    public List<String> getRecommendFriendsRankingFive() {
        return users.stream()
                .takeWhile(Objects::nonNull)
                .filter(user -> !user.isFriends())
                .sorted(Comparator.comparing(User::getVisits).reversed())
                .limit(5)
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
