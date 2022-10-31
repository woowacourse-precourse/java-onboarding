package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> findNicknameWordList(String nickname) {
        List<String> nicknameWordList = IntStream.range(0, nickname.length() - 1)
            .mapToObj(j -> nickname.substring(j, j + 2)).collect(Collectors.toList());
        return nicknameWordList;
    }
}
