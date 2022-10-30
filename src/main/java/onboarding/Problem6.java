package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> infoMap = parseUserInfo(forms);
        return answer;
    }

    private static HashMap<String, String> parseUserInfo(List<List<String>> forms) {
        Map<String, String> result = forms.stream()
                .collect(Collectors.toMap(
                        form -> form.get(1),
                        form -> form.get(0)
                ));
        return new HashMap<>(result);
    }
}
