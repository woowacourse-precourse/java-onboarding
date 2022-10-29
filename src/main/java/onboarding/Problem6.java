package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, List<String>> nicknames = createNicknameMap(forms);
        return answer;
    }

    private static Map<String, List<String>> createNicknameMap(List<List<String>> forms) {
        Map<String, List<String>> nicknames = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            List<String> twoLetterNicknames = splitTwoLetter(nickname);
            storeEmails(nicknames, email, twoLetterNicknames);
        }
        return nicknames;
    }

    private static List<String> splitTwoLetter(String nickname) {
        List<String> twoLetterNicknames = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetterNickname = nickname.substring(i, i + 2);
            twoLetterNicknames.add(twoLetterNickname);
        }

        return twoLetterNicknames;
    }

    private static void storeEmails(Map<String, List<String>> nicknames, String email, List<String> splitNicknames) {
        for (String nickname : splitNicknames) {
            List<String> emails = new ArrayList<>();
            if (nicknames.containsKey(nickname)) {
                emails = nicknames.get(nickname);
            }
            emails.add(email);
            nicknames.put(nickname, emails);
        }
    }
}
