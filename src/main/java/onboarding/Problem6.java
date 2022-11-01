package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static final int INDEX_OF_NICKNAME = 1;
    public static final int INDEX_OF_EMAIL = 0;

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> crewsWithSimilarNickname = findCrewsWithSimilarNickname(forms);
        List<String> emailsOfDuplicatedCrews = getEmails(crewsWithSimilarNickname);
        Collections.sort(emailsOfDuplicatedCrews);
        return emailsOfDuplicatedCrews;
    }

    private static List<String> getEmails(List<List<String>> forms) {
        return forms.stream()
            .map(form -> form.get(INDEX_OF_EMAIL))
            .collect(Collectors.toList());
    }

    private static List<List<String>> findCrewsWithSimilarNickname(List<List<String>> forms) {
        HashSet<List<String>> crewsWithSimilarNicknames = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            addCrewWithSimilarNickName(forms, crewsWithSimilarNicknames, i);
        }
        return new ArrayList<>(crewsWithSimilarNicknames);
    }

    private static void addCrewWithSimilarNickName(List<List<String>> forms, HashSet<List<String>> crewsWithSimilarNicknames, int i) {
        List<String> form = forms.get(i);
        String nickName = form.get(INDEX_OF_NICKNAME);
        for (int j = i + 1; j < forms.size(); j++) {
            List<String> formToCompare = forms.get(j);
            String nickNameToCompare = formToCompare.get(INDEX_OF_NICKNAME);
            if (containsSimilarLetters(nickName, nickNameToCompare)) {
                crewsWithSimilarNicknames.add(form);
                crewsWithSimilarNicknames.add(formToCompare);
            }
        }
    }

    private static boolean containsSimilarLetters(String nickName, String nickNameToCompare) {
        for (int i = 1; i < nickName.length(); i++) {
            String lettersToCompare = nickName.substring(0, i + 1);
            if (nickNameToCompare.contains(lettersToCompare)) {
                return true;
            }
        }
        return false;
    }
}
