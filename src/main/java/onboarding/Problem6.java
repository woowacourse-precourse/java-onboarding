package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;

    private static Map<String, String> emailToNameMap;
    private static Set<String> emailSet;

    public static List<String> solution(List<List<String>> forms) {
        emailToNameMap = new HashMap<>();
        makeEmailToNameMap(forms);

        emailSet = new HashSet<>();
        makeEmailSetByDuplicatedName();

        return sortListByAsc(emailSet);
    }

    public static void makeEmailToNameMap(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(EMAIL);
            String nickName = form.get(NICK_NAME);
            emailToNameMap.put(email, nickName);
        }
    }

    public static void makeEmailSetByDuplicatedName() {
        emailToNameMap.forEach(
                (email, name) -> {
                    for (int i = 0; i <= name.length() - 2; i++) {
                        String word = name.substring(i, i + 2);
                        emailSet.addAll(emailToNameMap.entrySet().stream()
                                .filter(e -> !Objects.equals(e.getKey(), email))
                                .filter(e -> e.getValue().contains(word))
                                .map(Map.Entry::getKey).collect(Collectors.toSet()));
                    }
                });
    }

    public static List<String> sortListByAsc(Set<String> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }
}
