package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nicknames = collectNicknames(forms);

        return answer;
    }

    private static List collectNicknames(List<List<String>> name) {
        List<String> collection = new ArrayList<>();
        for (List target : name) {
            collection.add((String)target.get(1));
        }
        return collection;
    }
}
