package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    private static String getEmail(List<String> form) {
        return form.get(EMAIL);
    }

    private static String getNickName(List<String> form) {
        return form.get(NICKNAME);
    }

    private static Set<String> getDuplicateNickname(List<List<String>> forms) {
        Set<String> duplicateNickname = new HashSet<>();
        Map<String, Set<String>> nicknameByword = new HashMap<>();

        for (List<String> form : forms) {
            String nickname = getNickName(form);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String part = nickname.substring(i, i + 2);
                if (!nicknameByword.containsKey(part)) {
                    nicknameByword.put(part, new HashSet<>());
                }
                nicknameByword.get(part).add(nickname);
                if (nicknameByword.get(part).size() >= 2) {
                    duplicateNickname.addAll(nicknameByword.get(part));
                }
            }
        }
        return duplicateNickname;
    }

    private static Set<String> createEmailList(List<List<String>> forms,
                                               Set<String> duplicateNickname) {
        Set<String> emailList = new TreeSet<>();

        for (List<String> form : forms) {
            String email = getEmail(form);
            String nickName = getNickName(form);
            if (duplicateNickname.contains(nickName)) {
                emailList.add(email);
            }
        }
        return emailList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> duplicateNickname = getDuplicateNickname(forms);
        Set<String> emailList = createEmailList(forms, duplicateNickname);

        answer = new ArrayList<>(emailList);
        return answer;
    }
}
