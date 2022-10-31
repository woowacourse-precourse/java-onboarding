package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> twoWords = getTwoWords(forms);
        Set<String> duplicatedWords = findDuplicatedWords(twoWords);

        return getEmailList(forms, duplicatedWords);
    }

    public static List<String> getTwoWords(List<List<String>> forms) {
        List<String> twoWords = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            if (nickname.length() == 1) continue;

            for (int j = 0; j < nickname.length() - 1; j++) {
                twoWords.add(nickname.substring(j, j + 2));
            }
        }

        return twoWords;
    }

    public static Set<String> findDuplicatedWords(List<String> twoWords) {
        Set<String> duplicatedWords = new HashSet<>();

        for (String str : twoWords) {
            if (twoWords.indexOf(str) != twoWords.lastIndexOf(str)) duplicatedWords.add(str);
        }

        return duplicatedWords;
    }

    public static List<String> getEmailList(List<List<String>> forms, Set<String> duplicatedWords) {
        TreeSet<String> emailList = new TreeSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (String duplicatedWord : duplicatedWords) {
                if (nickname.contains(duplicatedWord)) emailList.add(email);
            }
        }

        return new ArrayList<>(emailList);
    }
}
