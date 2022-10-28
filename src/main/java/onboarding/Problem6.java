package onboarding;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

    private final static int EMAIL = 0;
    private final static int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> emailToSplitNickname = extractedSplitNickname(forms);

        int loopStartIdx = 1;

        for (String email : emailToSplitNickname.keySet()) {
            List<String> list = emailToSplitNickname.get(email);
            for (int i = loopStartIdx; i < forms.size(); i++) {
                for (String splitNickname : list) {
                    if (forms.get(i).get(NICKNAME).contains(splitNickname)) {
                        answer.add(forms.get(i).get(EMAIL));
                        answer.add(email);
                    }
                }
            }
            loopStartIdx++;
        }

        return answer.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }

    private static Map<String, List<String>> extractedSplitNickname(List<List<String>> forms) {
        Map<String, List<String>> emailToSplitNickname = new LinkedHashMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(NICKNAME);
            List<String> splitNicknames = new ArrayList<>();
            for (int i = 0; i < nickname.length() - 1; i++) {
                splitNicknames.add(nickname.substring(i, i + 2));
            }
            emailToSplitNickname.put(form.get(EMAIL), splitNicknames);
        }

        return emailToSplitNickname;
    }

}
