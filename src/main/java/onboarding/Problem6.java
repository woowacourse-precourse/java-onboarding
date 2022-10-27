package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> nicknames = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        for (List<String> crews : forms) {

            String email = crews.get(0);
            String nickname = crews.get(1);

            nicknames.add(nickname);
            emails.add(email);
        }

        String duplicatedString = getDuplicatedString(nicknames);

        for (int i = 0; i < nicknames.size(); i++) {
            String nickname = nicknames.get(i);
            if (nickname.contains(duplicatedString)) {
                String email = emails.get(i);
                if (!answer.contains(email)) answer.add(emails.get(i));
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static String getDuplicatedString(List<String> nicknames) {
        for (int i = 0; i < nicknames.size() - 1; i++) {
            String nickname = nicknames.get(i);
            for (int idx = 0; idx < nickname.length() - 1; idx++) {
                String substring = nickname.substring(idx, idx + 2);
                for (int j = i + 1; j < nicknames.size(); j++) {
                    String otherNickname = nicknames.get(j);

                    if (otherNickname.contains(substring)) return substring;
                }
            }
        }
        return null;
    }
}
