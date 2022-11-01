package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> duplicatedEmailSet = new HashSet<String>();
        HashMap<String, List<String>> duplicatedNicknameMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            int nicknameLength = nickname.length();

            if (nicknameLength > 1) {
                for (int i = 0; i < nicknameLength - 1; i++) {
                    String bannedNickname = nickname.substring(i, i + 2);
                    if (!duplicatedNicknameMap.containsKey(bannedNickname)) {
                        ArrayList<String> bannedEmailList = new ArrayList<String>();
                        bannedEmailList.add(email);
                        duplicatedNicknameMap.put(bannedNickname, bannedEmailList);
                    } else {
                        duplicatedNicknameMap.get(bannedNickname).add(email);
                    }
                }
            }
        }

        duplicatedNicknameMap.forEach((key, value) -> {
            if (value.size() > 1) {
                value.forEach((email) -> {
                    duplicatedEmailSet.add(email);
                });
            }
        });

        ArrayList<String> answer = new ArrayList<String>(duplicatedEmailSet);
        Collections.sort(answer);

        return answer;
    }
}
