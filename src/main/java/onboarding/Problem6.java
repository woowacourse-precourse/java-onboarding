package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import onboarding.prob6.domain.Judge;
import onboarding.prob6.domain.Transformer;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<List<String>> processed = Transformer.encodeDecodLists(forms);
        Judge judge = new Judge(processed);
        return getSortedStrings(judge);
    }

    private static List<String> getSortedStrings(Judge judge) {
        List<String> answer;
        answer = judge.getListOfSameNickName().stream().sorted().collect(Collectors.toList());
        return answer;
    }
}
