package onboarding;

import onboarding.problem6.EmailListDto;
import onboarding.problem6.EmailSorting;
import onboarding.problem6.SimilarityChecker;
import onboarding.problem6.Users;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Users validUsers = new Users(forms);
        EmailListDto emails = new SimilarityChecker().getSimilarEmails(validUsers);
        return new EmailSorting(emails).toList();
    }
}
