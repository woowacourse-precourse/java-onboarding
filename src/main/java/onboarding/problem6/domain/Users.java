package onboarding.problem6.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;
    
    public Users(final List<User> users) {
        this.users = users;
    }
    
    public void saveDuplicateAccounts(final DuplicateAccountEmails duplicateAccountEmails) {
        duplicateAccountEmails.saveDuplicateAccountEmails(parseTwoLetterNames());
    }
    
    private List<List<User>> parseTwoLetterNames() {
        return users.stream()
                .map(User::twoLetterNames)
                .collect(Collectors.toList());
    }
    
    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
