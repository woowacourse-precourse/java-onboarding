package onboarding;

import onboarding.problem6.CrewException;
import onboarding.problem6.DuplicateNickMemberFinder;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        checkJoinNumber(forms);
        DuplicateNickMemberFinder finder = new DuplicateNickMemberFinder();
        return finder.findDuplicateNick(forms);
    }

    private static void checkJoinNumber(List<List<String>> forms) {
        checkMin(forms);
        checkMax(forms);
    }

    private static void checkMax(List<List<String>> forms) {
        if (forms.size() > 10_000) {
            throw new CrewException("최대 인원을 초과했습니다.");
        }
    }

    private static void checkMin(List<List<String>> forms) {
        if (forms.isEmpty()) {
            throw new CrewException("최소 1명의 크루 멤버가 필요합니다.");
        }
    }
}
