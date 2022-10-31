package onboarding.support.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateNicknameChecker {

    private List<String> duplicateUserEmails;
    private static final int EMAIL_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int MINIMUM_DUPLICATE_RANGE = 1;

    public DuplicateNicknameChecker(List<List<String>> forms) {
        duplicateUserEmails = new ArrayList<>();
        checkForms(forms);
        toSortedList();
    }

    private void checkForms(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                checkDuplicate(forms.get(i).get(EMAIL_INDEX), forms.get(i).get(NAME_INDEX),
                        forms.get(j).get(EMAIL_INDEX), forms.get(j).get(NAME_INDEX));
            }
        }
    }

    private void checkDuplicate(String firstEmail, String firstName, String secondEmail, String secondName) {
        for (int i = 0; i < firstName.length() - MINIMUM_DUPLICATE_RANGE; i++) {
            for (int j = i + 1; j < secondName.length() - MINIMUM_DUPLICATE_RANGE; j++) {
                if (isDuplicated(firstName, secondName, i, j)) {
                    this.duplicateUserEmails.add(firstEmail);
                    this.duplicateUserEmails.add(secondEmail);
                    return;
                }
            }
        }
    }

    private static boolean isDuplicated(String firstName, String secondName, int firstNameIndex, int secondNameIndex) {
        return firstName.charAt(firstNameIndex) == secondName.charAt(secondNameIndex)
                && firstName.charAt(firstNameIndex + MINIMUM_DUPLICATE_RANGE) == secondName.charAt(secondNameIndex + MINIMUM_DUPLICATE_RANGE);
    }

    private void toSortedList() {
        duplicateUserEmails = duplicateUserEmails.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<String> getDuplicateEmails() {
        return this.duplicateUserEmails;
    }
}
