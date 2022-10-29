package onboarding.problem6.repository;

import onboarding.problem6.vo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }

    public List<User> findAllByNameContaining(String word) {
        return users.stream()
                .filter(user -> user.getName().contains(word))
                .collect(Collectors.toList());
    }
}
