package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int EMAIL_LENGTH = 10;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (List<String> form : forms) {
            for (List<String> anotherForm : forms) {
                if (form.equals(anotherForm)) {
                    continue;
                }
                String nickname = form.get(1);
                String anotherNickname = anotherForm.get(1);
                IntStream.range(0, nickname.length() - 1)
                    .mapToObj(index -> nickname.substring(index, index + 2))
                    .filter(anotherNickname::contains)
                    .map(piece -> form.get(0))
                    .forEach(answer::add);
            }
        }
        return answer.stream().distinct().sorted(
            Comparator.comparing(o -> o.substring(0, o.length() - EMAIL_LENGTH))).collect(Collectors.toList());
    }
}
