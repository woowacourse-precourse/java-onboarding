package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import onboarding.problem6.DuplicateNickname;

public class Problem6 {

    private final static int USER_EMAIL = 0;

    static ArrayList<String> duplicateEmail(Set<Integer> duplicateIndex, List<List<String>> forms) {
        ArrayList<String> result = new ArrayList<>();

        for (int i : duplicateIndex) {
            result.add(forms.get(i).get(USER_EMAIL));
        }
        return result;
    }

    static void sortEmail(List<String> email) {
        Collections.sort(email);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        DuplicateNickname duplicateNickname = new DuplicateNickname(forms);
        answer = duplicateEmail(duplicateNickname.getDuplicateNickname(), forms);
        sortEmail(answer);

        return answer;
    }
}
