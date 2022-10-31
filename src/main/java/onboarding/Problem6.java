package onboarding;

import java.util.HashSet;
import java.util.List;

public class Problem6 {
    static HashSet<String> result = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void checkContainsSerialChar(String serialChar, int currentUserIdx, List<List<String>> forms) {
        for (int i = currentUserIdx+1; i < forms.size(); i++) {
            if (forms.get(i).get(1).contains(serialChar)) {
                result.add(forms.get(currentUserIdx).get(0));
                result.add(forms.get(i).get(0));
            }
        }
    }
}
