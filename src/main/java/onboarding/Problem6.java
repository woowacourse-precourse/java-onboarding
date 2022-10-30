package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int FORM_MIN_LENGTH = 1;
    private static final int FORM_MAX_LENGTH = 10000;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // forms에서 email 리스트를 추출하는 기능
    public static List<String> extractEmailList(List<List<String>> forms) {
        return forms.stream()
            .map(form -> form.get(0))
            .collect(Collectors.toList());
    }

    // forms에서 nickname 리스트를 추출하는 기능
    public static List<String> extractNicknameList(List<List<String>> forms) {
        return forms.stream()
            .map(form -> form.get(1))
            .collect(Collectors.toList());
    }

    // form의 길이가 1이상 10,000이하인지 검증하는 기능
    public static boolean checkFormsLength(List<List<String>> forms) {
        return FORM_MIN_LENGTH <= forms.size() && forms.size() <= FORM_MAX_LENGTH;
    }
}
