package onboarding;

import java.util.*;

public class Problem6 {
    public static final int LIMIT = 2;
    public static final String EMAIL_FORMAT = "@email.com";

    public static List<String> solution(List<List<String>> forms) {
        Map<String, Set<String>> nickAndEmail = new HashMap<>();
        for (List<String> form : forms) {
            makeMap(nickAndEmail, form.get(1), form.get(0).split("@")[0]);
        }
        List<String> answer = makeResult(nickAndEmail);
        for (int i = 0; i < answer.size(); i++) {
            answer.set(i, answer.get(i) + EMAIL_FORMAT);
        }
        return answer;
    }


    private static void makeMap(Map<String, Set<String>> nickAndEmail, String nickName, String email) {
        if (nickName.length() < LIMIT) return; // 한 글자면 처리를 하지 않아도 됨
        if (nickAndEmail.isEmpty()) {
            Set<String> set = new HashSet<>();
            set.add(email);
            nickAndEmail.put(nickName, set);
        }
        for (String s : nickAndEmail.keySet()) {
            String key = hasDuplicatedWords(s, nickName);
            if (key != null) {
                nickAndEmail.get(key).add(email);
            }
        }
    }

    protected static String hasDuplicatedWords(String key, String nickName) {
        if (isValid(key, nickName)) return key;
        return null;
    }

    private static boolean isValid(String s1, String s2) {
        for (int i = 0; i <= s2.length() - LIMIT; i++) {
            // s2의 2개의 연속된 단어를 s1이 가지고 있을 때
            if (s1.contains(s2.substring(i, i + LIMIT))) return true;
        }
        return false;
    }

    private static List<String> makeResult(Map<String, Set<String>> nickAndEmail) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> e : nickAndEmail.entrySet()) {
            if (e.getValue().size() >= LIMIT) {
                result.addAll(e.getValue());
            }
        }
        Collections.sort(result);
        return result;
    }
}
