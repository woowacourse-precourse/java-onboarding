package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {

    private static Set<String> getNickname(List<List<String>> forms) {
        Set<String> dNickName = new HashSet<>();
        Map<String, Set<String>> nicknameWord = new HashMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String part = nickname.substring(i, i + 2);
                if (!nicknameWord.containsKey(part)) {
                    nicknameWord.put(part, new HashSet<>());
                }

                nicknameWord.get(part).add(nickname);

                if (nicknameWord.get(part).size() >= 2) {
                    dNickName.addAll(nicknameWord.get(part));
                }

            }
        }
        return dNickName;
    }

    private static Set<String> emailList(List<List<String>> forms,
                                               Set<String> dNickName) {
        Set<String> emailList = new TreeSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            if (dNickName.contains(nickName)) {
                emailList.add(email);
            }
        }
        return emailList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> dNickName = getNickname(forms);
        Set<String> emailList = emailList(forms, dNickName);

        answer = new ArrayList<>(emailList);
        return answer;
    }
}