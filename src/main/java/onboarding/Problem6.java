package onboarding;

import onboarding.problem6.repository.UserRepository;
import onboarding.problem6.validation.UserInfoValidator;
import onboarding.problem6.vo.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        UserInfoValidator.validate(forms);

        UserRepository userRepository = new UserRepository();

        forms.forEach(form -> userRepository.save(User.of(form.get(0), form.get(1))));
        List<User> users = userRepository.findAll();

        Set<String> result = new HashSet<>();

        users.forEach(user -> {
            String name = user.getName();
            for (int spellIndex = 0; spellIndex < name.length() - 1; spellIndex++) {
                String duplicatingWord = makeDuplicatingWord(name, spellIndex);
                users.forEach(target -> {
                    if (!isNameExactlySame(user, target) && hasDuplicatedName(duplicatingWord, target)) {
                        result.add(user.getEmail());
                    }
                });
            }
        });

        List<String> resultList = new ArrayList<>(result);
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
