package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> words = new HashSet<>();

        for (List<String> form : forms) {

            String name = form.get(1);

            int currentIndex = 0;

            while (currentIndex < name.length() - 1) {

                words.add(name.substring(currentIndex, currentIndex + 2));
                currentIndex++;
            }

        }

        return answer;
    }
}
