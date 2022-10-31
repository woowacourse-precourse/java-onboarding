package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (int i = 0; i < forms.size(); i++) {
            if (isNotEmail(forms.get(i).get(0))) {
                forms.remove(i);
                i--;
            }
        }
        return answer;
    }
    public static boolean isNotEmail(String emailAddress) {
        return !emailAddress.endsWith("@email.com");
    }
}
