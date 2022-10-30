package onboarding;

import onboarding.feature6.DuplicateFinder;
import onboarding.feature6.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        UserInfo userInfo = new UserInfo(forms);
        DuplicateFinder duplicateFinder = new DuplicateFinder(userInfo);
        Map<String, Set<String>> duplicates = duplicateFinder.getDuplicates();
        return duplicateFinder.getFilteredEmails(duplicates);
    }
}
