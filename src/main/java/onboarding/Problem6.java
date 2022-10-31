package onboarding;

import static java.util.stream.Collectors.toCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import onboarding.problem6.DuplicatedNicknameUserEmailFinder;
import onboarding.problem6.EmailFinder;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        EmailFinder emailFinder = new DuplicatedNicknameUserEmailFinder();

        return emailFinder.findDuplicatedNicknameUserEmail(forms);
    }

}
