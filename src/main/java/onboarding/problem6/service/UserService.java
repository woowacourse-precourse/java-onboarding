package onboarding.problem6.service;

import onboarding.problem6.repository.UserRepository;
import onboarding.problem6.validation.UserInfoValidator;
import onboarding.problem6.vo.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveAllUsers(List<List<String>> users) {
        UserInfoValidator.validate(users);
        users.forEach(form -> userRepository.save(User.of(form.get(0), form.get(1))));
    }

    public List<String> findAllEmailByUserHavingInvalidName() {
        List<User> allUsers = userRepository.findAll();
        Set<String> emailSet = new TreeSet<>();

        allUsers.forEach(user -> {
            String name = user.getName();
            for (int spellIndex = 0; spellIndex < name.length() - 1; spellIndex++) {
                String duplicatingWord = makeDuplicatingWord(name, spellIndex);
                emailSet.addAll(
                        userRepository.findAllByNameContaining(duplicatingWord)
                                .stream().filter(find -> !user.equals(find))
                                .map(find -> find.getEmail())
                                .collect(Collectors.toSet())
                );
            }
        });

        return new ArrayList<>(emailSet);
    }

    private static String makeDuplicatingWord(String name, int index) {
        return name.substring(index, index + 2);
    }
}
