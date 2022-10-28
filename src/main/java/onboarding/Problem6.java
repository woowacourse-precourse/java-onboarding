package onboarding;


import java.util.*;
import onboarding.problem6.DuplicateNickname;

public class Problem6 {

    final static int USER_EMAIL = 0;
    static ArrayList<String> DuplicateEmail(Set<Integer> duplicateIndex, List<List<String>> forms) {
        ArrayList<String> result = new ArrayList<>();

        for(int i : duplicateIndex) {
            result.add(forms.get(i).get(USER_EMAIL));
        }
        return result;
    }
    static List<String> EmailSort(List<String> email) {
        List<String> result = email;

        Collections.sort(email);
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        DuplicateNickname duplicateNickname = new DuplicateNickname(forms);
        answer = DuplicateEmail(duplicateNickname.DuplicateNicknameIndex(), forms);
        EmailSort(answer);

        return answer;
    }
}
