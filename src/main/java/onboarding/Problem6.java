package onboarding;

import java.util.*;

public class Problem6 {
    public static final String DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        Map<String, Set<String>> substringToId = getSubstringToIdMap(forms);

        return null;
    }

    public static Map<String, Set<String>> getSubstringToIdMap(List<List<String>> forms) {
        Map<String, Set<String>> substringToId = new HashMap<>();

        for (List<String> form : forms) {
            String id = form.get(0).substring(0, form.get(0).length() - 9);
            String nickName = form.get(1);

            get2LengthSubstrings(nickName)
                    .forEach(s -> substringToId
                            .computeIfAbsent(s, k -> new HashSet<>())
                            .add(id));
        }

        return substringToId;
    }


    public static List<String> get2LengthSubstrings(String nickname) {
        List<String> substrings = new ArrayList<>();

        for (int i = 2; i < nickname.length() + 1; i++) {
            substrings.add(nickname.substring(i - 2, i));
        }
        return substrings;
    }


}
