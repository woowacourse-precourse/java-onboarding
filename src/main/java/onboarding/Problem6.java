package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> email = new ArrayList<>();
        List<String> name = new ArrayList<>();

        return answer;
    }

    public static void extractName(String name, List<String> output) {
        for (int i = 0; i < name.length() - 1; i++) {
            output.add(name.substring(i, (i + 2)));
        }
    }

    public static void checkRedundant(List<String> name, List<String> extracted, List<String> email, int index) {
        for (int i = index; i < extracted.size(); i++) {
            if (name.get(1).contains(extracted.get(i))) {
                email.add(name.get(0));
            }
        }
    }
}
