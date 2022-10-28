package onboarding;

import java.util.*;

public class Problem6 {
    public static final int LIMIT = 2;

    public static List<String> solution(List<List<String>> forms) {
        return getAnswer(forms);
    }

    public static List<String> getAnswer(List<List<String>> forms) {
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> form : forms) {
            makeMap(map, form.get(1), form.get(0));
        }
        return makeResult(map);
    }

    private static void makeMap(Map<String, Set<String>> map, String nickName, String email) {
        if (map.isEmpty()) {
            Set<String> set = new HashSet<>();
            set.add(email);
            map.put(nickName, set);
        }
        for (String s : map.keySet()) {
            String key = isDuplicated(s, nickName);
            if (key != null) {
                map.get(key).add(email);
            }
        }
    }

    public static String isDuplicated(String before, String after) {
        if (before.length() < LIMIT || after.length() < LIMIT) return null;
        if (isMatched(before, after)) {
            return before;
        }
        return null;
    }

    /**
     * 크기가 2인 윈도우로 밀고나가면서 중복되는 값이 있는지 확인
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isMatched(String str1, String str2) {
        for (int i = 0; i <= str2.length() - 2; i++) {
            if (str1.contains(str2.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    private static List<String> makeResult(Map<String, Set<String>> map) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> e : map.entrySet()) {
            if (e.getValue().size() >= 2) {
                result.addAll(e.getValue());
            }
        }
        Collections.sort(result);
        return result;
    }
}
