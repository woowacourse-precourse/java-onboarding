package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> answer = new HashSet<>();

        for (List<String> form : forms) {

            String testEmail = form.get(0);
            String testName = form.get(1);

            for (int i = 0; i < testName.length() - 1 ; i++) {
                String test = testName.substring(i, i+2);

                for (List<String> formTest : forms) {

                    if (formTest.get(1).contains(test)) {

                        if (!formTest.get(0).equals(testEmail)) {
                            answer.add(formTest.get(0));
                        }

                    }

                }

            }
        }

        List<String> result = new ArrayList<>(answer);
        result.sort(String.CASE_INSENSITIVE_ORDER);

        return result;
    }
}
