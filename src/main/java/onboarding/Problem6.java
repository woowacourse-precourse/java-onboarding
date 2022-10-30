package onboarding;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private final static int EMAIL = 0;
    private final static int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> emailToSplitNickname = extractedSplitNickname(forms);
        return getSimilarNicknameCrewEmails(forms, emailToSplitNickname);
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

        emailToSplitNicknames.entrySet().stream()
                .forEach(emailToSplitNickname -> addSimilarNicknameCrewEmails(forms, answer, atomic, emailToSplitNickname));

        return removeDuplicateAndSort(answer);
    }


    private static void addSimilarNicknameCrewEmails(List<List<String>> forms,
                                                     List<String> answer,
                                                     AtomicInteger atomic,
                                                     Map.Entry<String, List<String>> emailToSplitNickname) {
        IntStream.range(atomic.getAndIncrement(), forms.size())
                .filter(idx -> emailToSplitNickname.getValue().stream()
                        .anyMatch(splitNickname -> forms.get(idx).get(NICKNAME).contains(splitNickname))
                )
                .forEach(idx -> {
                    answer.add(forms.get(idx).get(EMAIL));
                    answer.add(emailToSplitNickname.getKey());
                });
    }

    private static List<String> removeDuplicateAndSort(List<String> answer) {
        return answer.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }



}
