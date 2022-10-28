package onboarding.problem6.domain;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateAccountEmails {
    private final Set<UserEmail> duplicateAccountEmails;
    
    public DuplicateAccountEmails() {
        duplicateAccountEmails = new HashSet<>();
    }
    
    public void saveDuplicateAccountEmails(final List<List<User>> users) {
        Map<UserName, UserEmail> checkDuplicateAccounts = new HashMap<>();
        
        for (List<User> twoLetterNameAccounts : users) {
            saveDuplicateTwoLetterNameAccountEmails(checkDuplicateAccounts, twoLetterNameAccounts);
        }
    }
    
    private void saveDuplicateTwoLetterNameAccountEmails(final Map<UserName, UserEmail> checkDuplicateAccounts, final List<User> twoLetterNameAccounts) {
        for (User twoLetterNameAccount : twoLetterNameAccounts) {
            saveDuplicateTwoLetterNameAccountEmail(checkDuplicateAccounts, twoLetterNameAccount);
        }
        
        checkDuplicateAccounts.putAll(parseCheckDuplicateAccounts(twoLetterNameAccounts));
    }
    
    private void saveDuplicateTwoLetterNameAccountEmail(final Map<UserName, UserEmail> checkDuplicateAccounts, final User twoLetterNameAccount) {
        final UserName twoLetterName = twoLetterNameAccount.userName();
        
        if (checkDuplicateAccounts.containsKey(twoLetterName)) {
            duplicateAccountEmails.add(checkDuplicateAccounts.get(twoLetterName));
            duplicateAccountEmails.add(twoLetterNameAccount.userEmail());
        }
    }
    
    private Map<UserName, UserEmail> parseCheckDuplicateAccounts(final List<User> twoLetterNameUsers) {
        return twoLetterNameUsers.stream()
                .collect(Collectors.toMap(User::userName, User::userEmail, (firstUserEmail, secondUserEmail) -> firstUserEmail));
    }
    
    public List<String> duplicateAccountEmails() {
        return duplicateAccountEmails.stream()
                .map(UserEmail::userEmail)
                .sorted()
                .collect(Collectors.toList());
    }
    
    @Override
    public String toString() {
        return "DuplicateAccountEmails{" +
                "duplicateAccountEmails=" + duplicateAccountEmails +
                '}';
    }
}
