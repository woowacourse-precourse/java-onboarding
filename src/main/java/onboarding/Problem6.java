package onboarding;

import onboarding.problem6.DuplicateChecker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        DuplicateChecker checker = new DuplicateChecker(forms);
        return checker.getDuplicates();
    }
}
