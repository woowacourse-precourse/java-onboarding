package onboarding.problem6.service;

import onboarding.problem6.domain.NicknameChecker;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NicknameService {

    public static List<String> duplicateNicknameEmail(List<List<String>> applyList) {
        NicknameChecker nicknameChecker = new NicknameChecker(applyList);

        return sortList(nicknameChecker.duplicateEmails());
    }

    private static List<String> sortList(Set<String> result) {
        return result.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}
