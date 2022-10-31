package onboarding.support.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateNicknameChecker {

    private List<String> duplicateUserEmails;
    private static final int BASE_INDEX = 0;

    public DuplicateNicknameChecker(List<List<String>> forms) {
        this.duplicateUserEmails = new ArrayList<>();
        checkForms(forms, BASE_INDEX, BASE_INDEX + 1);
        this.duplicateUserEmails = toSortedList();
    }

    private void checkForms(List<List<String>> forms, int firstIndex, int secondIndex) {
        if (isNotFormIndexValid(forms, firstIndex, secondIndex)) {
            return;
        }

        List<String> first = forms.get(firstIndex);
        List<String> second = forms.get(secondIndex);

        checkDuplicate(first.get(BASE_INDEX), first.get(BASE_INDEX + 1),
                second.get(BASE_INDEX), second.get(BASE_INDEX + 1), BASE_INDEX, BASE_INDEX + 1);

        checkForms(forms, firstIndex, secondIndex + 1);
    }

    private boolean isNotFormIndexValid(List<List<String>> forms, int firstIndex, int secondIndex) {
        if (firstIndex >= forms.size()) {
            return true;
        }
        if (secondIndex >= forms.size()) {
            checkForms(forms, firstIndex + 1, firstIndex + 2);
            return true;
        }
        return false;
    }

    private void checkDuplicate(String firstEmail, String firstName,
                                String secondEmail, String secondName, int firstIndex, int secondIndex) {
        if (isNotNameIndexValid(firstEmail, firstName, secondEmail, secondName, firstIndex, secondIndex)) {
            return;
        }

        if (isDuplicated(firstName, secondName, firstIndex, secondIndex)) {
            this.duplicateUserEmails.add(firstEmail);
            this.duplicateUserEmails.add(secondEmail);
            return;
        }
        checkDuplicate(firstEmail, firstName, secondEmail, secondName, firstIndex, secondIndex + 1);
    }

    private boolean isNotNameIndexValid(String firstEmail, String firstName,
                                        String secondEmail, String secondName, int firstIndex, int secondIndex) {
        if (firstIndex >= firstName.length() - 1) {
            return true;
        }
        if (secondIndex >= secondName.length() - 1) {
            checkDuplicate(firstEmail, firstName, secondEmail, secondName, firstIndex + 1, firstIndex + 2);
            return true;
        }
        return false;
    }

    private static boolean isDuplicated(String firstName, String secondName, int firstNameIndex, int secondNameIndex) {
        return firstName.charAt(firstNameIndex) == secondName.charAt(secondNameIndex)
                && firstName.charAt(firstNameIndex + 1) == secondName.charAt(secondNameIndex + 1);
    }

    private List<String> toSortedList() {
        return duplicateUserEmails.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<String> getDuplicateEmails() {
        return this.duplicateUserEmails;
    }
}
