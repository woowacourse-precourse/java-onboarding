package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (List<String> person : forms) {
            int emailLength = person.get(0).length();
            if (emailLength < 11 || emailLength >= 20) {
                break;
            }

            String nickname = person.get(1);
            int nameLength = nickname.length();
            if (nameLength < 1 || nameLength >= 20) {
                break;
            }
        }
        return answer;
    }
}
