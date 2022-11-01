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
            String name = forms.get(i).get(1);
            for (String word : duplicatedWords) {
                if (name.contains(word)) {
                    result.add(forms.get(i).get(0));
                }
            }
            List<String> twoLetterWords = getTwoLetterWords(name);
            for (int j = i + 1; j < forms.size(); j++) {
                for (String word : twoLetterWords) {
                    if (forms.get(j).get(1).contains(word)) {
                        result.add(forms.get(i).get(0));
                        result.add(forms.get(j).get(0));
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
