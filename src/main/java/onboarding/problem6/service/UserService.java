package onboarding.problem6.service;

import onboarding.problem6.repository.UserRepository;
import onboarding.problem6.validation.UserInfoValidator;
import onboarding.problem6.vo.User;

import java.util.*;

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
        List<User> users = userRepository.findAll();
        Set<String> emailSet = new HashSet<>();

        users.forEach(user -> {
            String name = user.getName();
            for (int spellIndex = 0; spellIndex < name.length() - 1; spellIndex++) {
                String duplicatingWord = makeDuplicatingWord(name, spellIndex);
                users.forEach(target -> {
                    if (!isNameExactlySame(user, target) && hasDuplicatedName(duplicatingWord, target)) {
                        emailSet.add(user.getEmail());
                    }
                });
            }
        });

        List<String> resultList = new ArrayList<>(emailSet);
        Collections.sort(resultList);

        return resultList;
    }

    private static boolean hasDuplicatedName(String duplicatingWord, User target) {
        return target.getName().contains(duplicatingWord);
    }

    private static boolean isNameExactlySame(User user, User target) {
        return user.equals(target);
    }

    private static String makeDuplicatingWord(String name, int spellIndex) {
        return name.substring(spellIndex, spellIndex + 2);
    }
}
