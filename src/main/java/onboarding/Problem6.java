package onboarding;

import java.lang.reflect.Member;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 solve = new Problem6();
        solve.procException(solve.hasException(forms));
        List<String> result = solve.findDuplMembers(forms);
        return result;
    }
    private void procException(Boolean isException) {
        if (isException) {
            throw new RuntimeException("Error Occur");
        }
    }

    private boolean hasException(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000)
            return true;
        for (List<String> member : forms) {
            String email = member.get(0);
            String nickname = member.get(1);
            if (!email.contains("@email.com") || email.length() < 11 || 19 < email.length())
                return true;
            else if (!nickname.replaceAll("[ㄱ-힣]", "").isEmpty() || nickname.length() < 1 || 19 < nickname.length()) {
                return true;
            }
        }
        return false;
    }

    private List<String> findDuplMembers(List<List<String>> forms) {
        List<String> duplWords = new ArrayList<>();
        List<String> nonDuplWords = new ArrayList<>();

        for (List<String> member : forms) {
            String nickname = member.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String word = nickname.substring(i, i + 2);
                if (duplWords.contains(word))
                    nonDuplWords.add(word);
                else
                    duplWords.add(word);
            }
        }
        return getEmailByDuplName(duplWords, nonDuplWords, forms);

    }

    private List<String> getEmailByDuplName(List<String> duplWords, List<String> nonDuplWords, List<List<String>> forms) {
        Set<String> duplMemebersEmails = new TreeSet<>();
        for (String letter : nonDuplWords) {
            for (List<String> member : forms) {
                if ((member.get(1)).contains(letter))
                    duplMemebersEmails.add(member.get(0));

            }
        }
        return new ArrayList<>(duplMemebersEmails);

    }
}
