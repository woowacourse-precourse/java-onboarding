package onboarding.problem6.repository;

import onboarding.problem6.vo.User;

import java.util.ArrayList;
import java.util.List;

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
}
