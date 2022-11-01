package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateNickMemberFinder {
    private final TreeSet<Member> notCrewTree = new TreeSet<>();

    public List<String> findDuplicateNick(List<List<String>> forms) {
        notCrewTree.addAll(getTemp(forms));
        return notCrewTree.stream()
                .map(Member::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Member> getTemp(List<List<String>> forms) {
        return forms.stream()
                .map(Member::new)
                .collect(Collectors.toList());
    }

}
