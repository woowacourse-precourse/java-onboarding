package onboarding;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
    );

    @Test
    void nameMatchingTest() {
        String str1 = "제이엠";
        String str2 = "이엠제";
        String str3 = "제엠이";
        String str4 = "크롱";
        String str5 = "크크크크크크크크크크크롱";
        assertThat(isDuplicated(str1, str2)).isEqualTo("제이엠");
        assertThat(isDuplicated(str2, str3)).isNull();
        assertThat(isDuplicated(str2, str4)).isNull();
        assertThat(isDuplicated(str4, str5)).isEqualTo("크롱");
    }

    @Test
    void mapTest() {
        Map<String, Set<String>> map = new HashMap<>();
        map.put("제이엠", new HashSet<>());
        map.get("제이엠").add("jm@email.com");
        map.get("제이엠").add("jm@email.com");
        map.get("제이엠").add("abc@email.com");
        assertThat(map.get("제이엠").size()).isEqualTo(2);
        assertThat(map.get("제이엠")).containsExactly("abc@email.com", "jm@email.com");
    }

    @Test
    void formsTest() {
        assertThat(getAnswer(forms)).isEqualTo(List.of("jason@email.com", "jm@email.com", "mj@email.com"));
    }

    public static final int LIMIT = 2;

    public static String isDuplicated(String before, String after) {
        if (before.length() < LIMIT || after.length() < LIMIT) return null;
        if (isValid(before, after)) {
            return before;
        }
        return null;
    }

    private static boolean isValid(String str1, String str2) {
        for (int i = 0; i <= str2.length() - 2; i++) {
            if (str1.contains(str2.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getAnswer(List<List<String>> forms) {
        Map<String, Set<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (List<String> form : forms) {
            String nickName = form.get(1);
            String email = form.get(0);
            makeMap(map, nickName, email);
        }
        for (Map.Entry<String, Set<String>> e : map.entrySet()) {
            makeResult(result, e);
        }
        Collections.sort(result);
        return result;
    }

    private static void makeResult(List<String> result, Map.Entry<String, Set<String>> e) {
        if (e.getValue().size() >= 2) {
            result.addAll(e.getValue());
        }
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
}