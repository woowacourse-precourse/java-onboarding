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

        allUsers
                .stream().map(user -> findAllInvalidEmailsFromUser(user))
                .forEach(emailSet::addAll);

        return new ArrayList<>(emailSet);
    }

    private Set<String> findAllInvalidEmailsFromUser(User user) {
        TreeSet<String> result = new TreeSet<>();
        String name = user.getName();
        for (int spellIndex = 0; spellIndex < name.length() - 1; spellIndex++) {
            String invalidWord = makeInvalidWord(name, spellIndex);
            Set<String> invalidEmails = findInvalidEmails(user, invalidWord);
            result.addAll(invalidEmails);
        }
        return result;
    }

    private Set<String> findInvalidEmails(User user, String duplicatingWord) {
        return userRepository.findAllByNameContaining(duplicatingWord)
                .stream().filter(find -> !user.equals(find))
                .map(find -> find.getEmail())
                .collect(Collectors.toSet());
    }

    private static String makeInvalidWord(String name, int index) {
        return name.substring(index, index + 2);
    }
}
