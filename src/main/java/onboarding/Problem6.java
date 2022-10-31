package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = forms.stream().map(x -> x.get(0)).collect(Collectors.toList());
        List<String> usernames = forms.stream().map(x -> x.get(1)).collect(Collectors.toList());



        List<String> answer = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        return answer;
    }
}
