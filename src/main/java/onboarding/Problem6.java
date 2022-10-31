package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, List<String>> FragmentsMap = new HashMap<>();

        makeFragmentsMap(forms, FragmentsMap);
        return answer;
    }
    private static void makeFragmentsMap(List<List<String>> forms,
        Map<String, List<String>> nickNameFragmentsMap) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            for (int i = 0; i < nickName.length() - 1; i++) {
                String nickNameFragment = "" + nickName.charAt(i) + nickName.charAt(i + 1);
                putValue(nickNameFragmentsMap, email, nickNameFragment);
            }
        }
    }

    private static void putValue(Map<String, List<String>> nickNameFragmentsMap, String email,
        String nickNameFragment) {
        if (nickNameFragmentsMap.containsKey(nickNameFragment)) {
            List<String> emails = nickNameFragmentsMap.get(nickNameFragment);
            emails.add(email);
            nickNameFragmentsMap.put(nickNameFragment, emails);
            return;
        }
        nickNameFragmentsMap.put(nickNameFragment, new ArrayList<>(List.of(email)));
    }

}

}
