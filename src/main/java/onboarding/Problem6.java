package onboarding;

import onboarding.problem6.domain.Manager;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        final Manager manager = new Manager(forms);
        manager.saveDuplicateAccounts();
        return manager.getDuplicateAccountEmails();
    }
}
