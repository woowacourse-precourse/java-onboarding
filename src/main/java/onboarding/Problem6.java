package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {

            for (List<String> form : forms) {

                if (form == forms.get(i)) {
                    continue;
                }

                if (isRepeated(forms.get(i).get(1), form.get(1))) {
                    emails.add(form.get(0));
                }

            }
        }

        emails = emails.stream().distinct().collect(Collectors.toList());
        Collections.sort(emails);

        return emails;

    }

    public static boolean checkRepeated(String longerWord, String shorterWord) {

        for (int i = 0; i < shorterWord.length()-1; i++) {

            if (longerWord.contains(shorterWord.substring(i, i + 2))) {
                return true;
            }

        }

        return false;
    }

    public static List<String> sortedByWordLength(String word1, String word2) {
        List<String> sortedWord = new ArrayList<>();

        if (word1.length() >= word2.length()) {
            sortedWord.add(word2);
            sortedWord.add(word1);
            return sortedWord;
        }

        sortedWord.add(word1);
        sortedWord.add(word2);
        return sortedWord;
    }

    public static boolean isRepeated(String word1, String word2) {
        List<String> sortedWord = sortedByWordLength(word1, word2);

        if (checkRepeated(sortedWord.get(0), sortedWord.get(1))) {
            return true;
        }

        return false;
    }
}
