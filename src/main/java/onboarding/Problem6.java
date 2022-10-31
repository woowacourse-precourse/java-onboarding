package onboarding;

import java.util.*;

public class Problem6 {

    public static Set<String> parseTwoLetterWords(String name) {
        // substring = O(n) -> 단어 하나에 O(n^2)
        // charAt = O(1) -> 단어 하나에 O(n)
        Set<String> words = new HashSet<>();
        for (int i = 0; i < name.length() - 1; ++i) {
            String word = "" + name.charAt(i) + name.charAt(i + 1); // substring 보단 빠를듯?
//            String word = name.substring(i, i+1);
            words.add(word);
        }
        return words;
    }

    public static List<String> toSortedArray(Set<String> resultSet) {
        List<String> result = new ArrayList<>(List.copyOf(resultSet));
        Collections.sort(result);
        return result;
    }

    public static List<String> solution(List<List<String>> forms) {

        Map<String, String> twoLetterWordDict = new HashMap<>();
        Set<String> similarParticipants = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            Set<String> twoLetterWords = parseTwoLetterWords(name);

            twoLetterWords.forEach(twoLetterWord -> {
                if (twoLetterWordDict.containsKey(twoLetterWord)) {
                    similarParticipants.add(twoLetterWordDict.get(twoLetterWord));
                    similarParticipants.add(email);
                }

                twoLetterWordDict.put(twoLetterWord, email);
            });
        }

        return toSortedArray(similarParticipants);
    }
}