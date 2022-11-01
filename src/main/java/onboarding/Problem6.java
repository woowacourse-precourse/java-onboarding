package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new TreeSet<String>();
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
