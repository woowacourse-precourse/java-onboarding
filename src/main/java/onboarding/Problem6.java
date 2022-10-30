package onboarding;

import onboarding.feature6.DuplicateLettersFinder;
import onboarding.feature6.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        UserInfo userInfo = new UserInfo(forms);
        DuplicateLettersFinder duplicateLettersFinder = new DuplicateLettersFinder(userInfo);
        Map<String, Set<String>> duplicates = duplicateLettersFinder.findDuplicateLetters();
        return duplicateLettersFinder.getFilteredEmails(duplicates);
    }
}
