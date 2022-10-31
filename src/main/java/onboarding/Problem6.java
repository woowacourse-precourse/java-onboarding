package onboarding;

import onboarding.support.problem6.DuplicateNicknameChecker;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        DuplicateNicknameChecker duplicateNicknameChecker = new DuplicateNicknameChecker(forms);
        return duplicateNicknameChecker.getDuplicateEmails();
    }
}
