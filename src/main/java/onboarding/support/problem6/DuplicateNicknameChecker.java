package onboarding.support.problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNicknameChecker {

    private List<String> DuplicateUserEmails;

    public DuplicateNicknameChecker(List<List<String>> forms) {
        Set<String> duplicatedUserEmail = new HashSet<>();
    }

    private static void checkDuplicate(Set<String> duplicatedUserEmail, String firstName, String firstEmail, String secondName, String secondEmail) {
        for (int i = 0; i < firstName.length() - 1; i++) {
            for (int j = 0; j < secondName.length() - 1; j++) {
                if (isDuplicated(firstName, secondName, i, j)) {
                    duplicatedUserEmail.add(firstEmail);
                    duplicatedUserEmail.add(secondEmail);
                    return;
                }
            }
        }
    }

    private static boolean isDuplicated(String firstName, String secondName, int i, int j) {
        return firstName.charAt(i) == secondName.charAt(j) && firstName.charAt(i + 1) == secondName.charAt(j + 1);
    }

    public List<String> getDuplicateEmails() {
        return DuplicateUserEmails;
    }
}
