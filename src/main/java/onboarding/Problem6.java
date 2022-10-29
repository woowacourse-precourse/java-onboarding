package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> getNicknamesInForms(List<List<String>> forms) {
        return forms.stream()
                .map(form -> form.get(1))
                .collect(Collectors.toList());
    }

    private static List<String> getSplitNicknames(String nickname) {
        List<String> splitNicknames = new ArrayList<>();

        int length = nickname.length();
        int sequence = 0;
        while (sequence < length) {
            String splitNickname = nickname.substring(sequence, sequence + 1);
            splitNicknames.add(splitNickname);
            sequence++;
        }

        return splitNicknames;
    }
}
