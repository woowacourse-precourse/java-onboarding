package onboarding;

import java.util.*;
import static onboarding.validation.NumberValidate.*;

public class Problem6 {

    private static boolean validateProblem(List<List<String>> forms) {
        return rangeValidate(1, forms.size(), 10000);
    }

    public static List<String> solution(List<List<String>> forms) {

        if (!validateProblem(forms)) return null;

        Map<String, Set<String>> split2_email = new HashMap<>();
        List<String> answer = new ArrayList<>();
        String word2, email;

        for (List<String> form : forms) {

            email = form.get(0);
            for (int j = 0; j < form.get(1).length() - 1; j++) {

                word2 = form.get(1).substring(j, j + 2);
                if (split2_email.containsKey(word2)) {

                    answer.add(email);
                    if (split2_email.get(word2).size() == 1) {
                        answer.addAll(split2_email.get(word2));
                    }
                    split2_email.get(word2).add(email);

                } else {
                    split2_email.put(word2, new HashSet<>(Collections.singletonList(email)));
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
