package onboarding;

import onboarding.feature6.DuplicateCharactersFinder;
import onboarding.feature6.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        UserInfo userInfo = new UserInfo(forms);
        DuplicateCharactersFinder duplicateCharactersFinder = new DuplicateCharactersFinder(userInfo);
        Map<String, Set<String>> duplicates = duplicateCharactersFinder.findDuplicateLetters();
        return duplicateCharactersFinder.getFilteredEmails(duplicates);
    }
}
