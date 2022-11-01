package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new TreeSet<String>();
        Set<String> duplicatedWords = new HashSet<String>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            String name = form.get(1);
            String email = form.get(0);
            for (String word : duplicatedWords) {
                if (name.contains(word)) {
                    result.add(email);
                }
            }
            List<String> twoLetterWords = getTwoLetterWords(name);
            for (int j = i + 1; j < forms.size(); j++) {
                List<String> target_form = forms.get(j);
                String target_name = target_form.get(1);
                String target_email = target_form.get(0);
                for (String word : twoLetterWords) {
                    if (target_name.contains(word)) {
                        result.add(email);
                        result.add(target_email);
                        duplicatedWords.add(word);
                    }
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    static List<String> getTwoLetterWords(String s) {
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < s.length() - 1; i++) {
            words.add(s.substring(i, i + 2));
        }
        return words;
    }
}
