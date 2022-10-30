package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static Map<String, Set<String>> limitedNicknameMap = new HashMap<>();
    private static Set<String> answer = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        init();

        // 제한할 닉네임 목록 정리
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (nickname.length() < 2)
                continue;

            for (int i = 0; i < nickname.length() - 1; i++) {
                String splitNickname = nickname.substring(i, i+2);

                if (limitedNicknameMap.containsKey(splitNickname)) {
                    limitedNicknameMap.get(splitNickname).add(email);
                } else {
                    Set<String> emailListSet = new HashSet<>(Arrays.asList(email));
                    limitedNicknameMap.put(splitNickname, emailListSet);
                }
            }
        }

        // 전송할 이메일 목록 정리
        for (String key : limitedNicknameMap.keySet()) {
            Set<String> emailListSet = limitedNicknameMap.get(key);

            if (emailListSet.size() <= 1)
                continue;

            for (String email : emailListSet) {
                String splitEmail = email.split("@")[0];
                answer.add(splitEmail);
            }
        }

        List<String> retAnswer = new ArrayList<>(answer);
        Collections.sort(retAnswer);

        for (int i = 0; i < retAnswer.size(); i++) {
            retAnswer.set(i, retAnswer.get(i) + "@email.com");
        }

        return retAnswer;
    }

    private static void init() {
        limitedNicknameMap = new HashMap<>();
        answer = new HashSet<>();
    }
}
