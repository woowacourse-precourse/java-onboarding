package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
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
