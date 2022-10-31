package onboarding;

import java.util.*;

public class Problem6 {
    public static Map<String,Integer> nicknameTokensToCount = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> crew : forms) {
            tokenizeNickname(crew.get(1));
        }
        List<String> answer = getEmailsOfDuplicatedNickname(forms);
        return answer;
    }

    public static void tokenizeNickname(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i ,i + 2);
            if (nicknameTokensToCount.containsKey(token)) {
                nicknameTokensToCount.put(token, nicknameTokensToCount.get(token) + 1);
            } else {
                nicknameTokensToCount.put(token, 1);
            }
        }
    }

    public static List<String> getEmailsOfDuplicatedNickname(List<List<String>> forms) {
        List<String> emailsOfDuplicatedNickname = new ArrayList<>();
        for (String token : nicknameTokensToCount.keySet()) {
            if (nicknameTokensToCount.get(token) >= 2) {
                for (List<String> crew : forms) {
                    if (crew.get(1).contains(token)) {
                        emailsOfDuplicatedNickname.add(crew.get(0));
                    }
                }
            }
        }
        Collections.sort(emailsOfDuplicatedNickname);
        return emailsOfDuplicatedNickname;
    }
}
