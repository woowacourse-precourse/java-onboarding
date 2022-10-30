package onboarding.problem6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class NickNameSystem {
    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;
    private static final Map<String, String> hashMap = new HashMap<>();
    private static final TreeSet<String> emailTree = new TreeSet<>();

    private void selectForm(List<List<String>> forms) {
        for (List<String> form : forms) {
            checkNickName(form);
        }
    }

    private void checkNickName(List<String> form) {
        String selectedName = form.get(NICK_NAME);
        String email = form.get(EMAIL);
        for (int idx = 0; idx < selectedName.length() - 1; idx++) {
            String subStr = selectedName.substring(idx, idx + 2);
            checkSubStr(email, subStr);
        }
    }

    private void checkSubStr(String email, String subStr) {
        if (hashMap.containsKey(subStr)) {
            String hashMapEmail = hashMap.get(subStr);
            addDuplicateNickNameEmail(email, hashMapEmail);
        }
        hashMap.put(subStr, email);
    }

    private void addDuplicateNickNameEmail(String email, String hashMapEmail) {
        if (!email.equals(hashMapEmail)) {
            emailTree.add(hashMapEmail);
            emailTree.add(email);
        }
    }
}
