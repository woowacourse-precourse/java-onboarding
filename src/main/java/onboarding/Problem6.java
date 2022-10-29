package onboarding;

import onboarding.problem6.repository.UserRepository;
import onboarding.problem6.service.UserService;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        userService.saveAllUsers(forms);
        return userService.findAllEmailByUserHavingInvalidName();
    }
}
