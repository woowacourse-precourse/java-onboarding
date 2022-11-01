package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> email = new ArrayList<>();
        List<String> name = new ArrayList<>();
        int length;

        for (int i = 0; i < forms.size(); i++) {
            length = name.size();
            extractName(forms.get(i).get(1), name);
            for (int j = 0; j < forms.size(); j++) {
                if (i != j) {
                    checkRedundant(forms.get(j), name, email, length);
                }
            }
        }

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
