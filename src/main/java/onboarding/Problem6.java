package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Crews;
import onboarding.problem6.DuplicatedNicknameFilter;
import onboarding.problem6.NicknameSnippets;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crews crews = new Crews(forms);
        NicknameSnippets nicknameSnippets = new NicknameSnippets(crews);
        DuplicatedNicknameFilter duplicatedNicknameFilter = new DuplicatedNicknameFilter(nicknameSnippets, crews);

        return duplicatedNicknameFilter.filter();
    }
}
