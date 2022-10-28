package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        Set<String> duplicate = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            List<String> words = new ArrayList<>();
            for (int j = 0; j < nickname.length() - 1; j++) {
                words.add(nickname.substring(j, j + 2));
            }

            for (int j = i + 1; j < forms.size(); j++) {
                String email2 = forms.get(j).get(0);
                String nickname2 = forms.get(j).get(1);

                for (String word : words) {
                    if (nickname2.contains(word)) {
                        duplicate.add(email);
                        duplicate.add(email2);
                        break;
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(duplicate);
        Collections.sort(answer);
        return answer;
    }
}
