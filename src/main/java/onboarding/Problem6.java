package onboarding;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Problem6 {

    private final static int EMAIL = 0;
    private final static int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> emailToSplitNickname = extractedSplitNickname(forms);
        List<String> similarNicknameCrewEmails = getSimilarNicknameCrewEmails(forms, emailToSplitNickname);
        return removeDuplicateAndSort(similarNicknameCrewEmails);
    }

    private static Map<String, List<String>> extractedSplitNickname(List<List<String>> forms) {
        Map<String, List<String>> emailToSplitNicknames = new LinkedHashMap<>();

        for (List<String> form : forms) {
            List<String> splitNicknames = new ArrayList<>();
            String nickname = form.get(NICKNAME);
            for (int i = 0; i < nickname.length() - 1; i++) {
                splitNicknames.add(nickname.substring(i, i + 2));
            }
            emailToSplitNicknames.put(form.get(EMAIL), splitNicknames);
        }
        return emailToSplitNicknames;
    }

    private static List<String> getSimilarNicknameCrewEmails(List<List<String>> forms,
                                                             Map<String, List<String>> emailToSplitNicknames) {
        List<String> answer = new ArrayList<>();
        AtomicInteger atomic = new AtomicInteger(1);

        for (Map.Entry<String, List<String>> emailToSplitNickname : emailToSplitNicknames.entrySet()) {
            for (int i = atomic.getAndIncrement(); i < forms.size(); i++) {
                addSimilarNicknameCrewEmails(forms, answer, emailToSplitNickname, i);
            }
        }
        return answer;
    }

    private static void addSimilarNicknameCrewEmails(List<List<String>> forms,
                                                     List<String> answer,
                                                     Map.Entry<String, List<String>> emailToSplitNickname,
                                                     int idx) {
        for (String nicknameSplit : emailToSplitNickname.getValue()) {
            if (forms.get(idx).get(NICKNAME).contains(nicknameSplit)) {
                answer.add(forms.get(idx).get(EMAIL));
                answer.add(emailToSplitNickname.getKey());
            }
        }
    }

    private static List<String> removeDuplicateAndSort(List<String> answer) {
        return answer.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

}
