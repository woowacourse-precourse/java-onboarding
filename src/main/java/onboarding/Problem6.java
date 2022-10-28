package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 폼 검증
     * @param forms 폼
     * @return 검증 결과 값
     */
    private static boolean validateForm(List<List<String>> forms) {
        int sizeForms = forms.size();
        return sizeForms > 0 && sizeForms <= 10_000;
    }

    /**
     * 크루 검증
     * @param crew 등록된 크루
     * @return 검증 결과 값
     */
    private static boolean validateCrew(List<String> crew) {
        String email = crew.get(0);
        String nickname = crew.get(1);

        if(!Pattern.matches("^[.A-Za-z0-9_-]{1,9}+@email.com$", email)) {
            return false;
        }

        if (!Pattern.matches("^[가-힣]{1,19}$", nickname)) {
            return false;
        }

        return true;
    }
}
