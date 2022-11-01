package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static final String DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        Map<String, Set<String>> substringToId = getSubstringToIdMap(forms);

        List<String> duplicatedIdList = getDuplicatedIds(substringToId);

        return getEmailsFromIdsOrderByEmail(duplicatedIdList);
    }

    public static Map<String, Set<String>> getSubstringToIdMap(List<List<String>> forms) {
        Map<String, Set<String>> substringToId = new HashMap<>();

        for (List<String> form : forms) {
            String id = getIdFromEmail(form.get(0));
            String nickName = form.get(1);

            get2LengthSubstrings(nickName)
                    .forEach(s -> substringToId
                            .computeIfAbsent(s, k -> new HashSet<>())
                            .add(id));
        }

        return substringToId;
    }

    public static String getIdFromEmail(String email) {
        return email.substring(0, email.length() - DOMAIN.length());
    }


    public static List<String> get2LengthSubstrings(String nickname) {
        List<String> substrings = new ArrayList<>();

        for (int i = 2; i < nickname.length() + 1; i++) {
            substrings.add(nickname.substring(i - 2, i));
        }
        return substrings;
    }

    public static List<String> getDuplicatedIds(Map<String, Set<String>> substringToId) {
        Set<String> duplicatedIds = new HashSet<>();

        for (String substring : substringToId.keySet()) {
            if (substringToId.get(substring).size() >= 2) {
                duplicatedIds.addAll(substringToId.get(substring));
            }
        }

        return new ArrayList<>(duplicatedIds);
    }

    public static List<String> getEmailsFromIdsOrderByEmail(List<String> ids) {
        return ids
                .stream()
                .map(id -> id + DOMAIN)
                .sorted()
                .collect(Collectors.toList());

    }

}
