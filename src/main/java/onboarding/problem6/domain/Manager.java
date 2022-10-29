package onboarding.problem6.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Manager {
    private final Users users;
    private final DuplicateAccountEmails duplicateAccountEmails;
    
    public Manager(final List<List<String>> users) {
        this(initUsers(users));
    }
    
    public Manager(final Users users) {
        this.users = users;
        this.duplicateAccountEmails = new DuplicateAccountEmails();
    }
    
    private static Users initUsers(final List<List<String>> users) {
        return new Users(parseUsers(users));
    }
    
    private static List<User> parseUsers(final List<List<String>> users) {
        return users.stream()
                .map(Manager::initUser)
                .collect(Collectors.toList());
    }
    
    private static User initUser(final List<String> user) {
        return new User(user.get(1), user.get(0));
    }
    
    public void saveDuplicateAccounts() {
        users.saveDuplicateAccounts(duplicateAccountEmails);
    }
    
    public List<String> getDuplicateAccountEmails() {
        return duplicateAccountEmails.getDuplicateAccountEmails();
    }
    
    @Override
    public String toString() {
        return "Manager{" +
                "users=" + users +
                ", duplicateAccountEmails=" + duplicateAccountEmails +
                '}';
    }
}
