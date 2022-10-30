package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

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
}
