package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        LinkedList<List<String>> formLinkedList = new LinkedList<>(forms);

        List<String> emailList = getEmailListOfSimilarNickname(formLinkedList);

        return emailList;
    }

    private static List<String> getEmailListOfSimilarNickname(LinkedList<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        int targetIdx = 0;

        while (targetIdx < forms.size()) {
            List<List<String>> similarNicknameForms = getSimilarNicknameFormList(forms, targetIdx);

            if (similarNicknameForms.isEmpty()) {
                targetIdx++;
                continue;
            }

            for (List<String> similarNicknameForm : similarNicknameForms) {
                emailList.add(similarNicknameForm.get(0));
            }

            forms.removeAll(similarNicknameForms);
        }

        return emailList.stream().
                distinct().
                sorted().
                collect(Collectors.toList());
    }

    private static List<List<String>> getSimilarNicknameFormList(List<List<String>> forms, int targetIdx) {
        String targetNickname = forms.get(targetIdx).get(1);

        if (targetNickname.length() < 2) {
            return Collections.emptyList();
        }

        List<String> nicknameSubstringList = getTwoLetterSubstringList(targetNickname);

        List<List<String>> similarNicknameForms = new ArrayList<>();
        
        for (String nicknameSubstring : nicknameSubstringList) {
            similarNicknameForms.addAll(
                    forms.stream()
                            .skip(targetIdx + 1)
                            .filter(form -> form.get(1).contains(nicknameSubstring))
                            .collect(Collectors.toList()));
        }

        if (!similarNicknameForms.isEmpty()) {
            similarNicknameForms.add(forms.get(targetIdx));
        }

        return similarNicknameForms;
    }

    private static List<String> getTwoLetterSubstringList(String nickname) {
        List<String> substrings = new ArrayList<>();
        for (int idx = 0; idx < nickname.length() - 1; idx++) {
            substrings.add(nickname.substring(idx, idx + 2));
        }
        return substrings;
    }
}
