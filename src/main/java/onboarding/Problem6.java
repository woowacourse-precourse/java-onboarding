package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Problem6 {
    private static final String VALID_DOMAIN = "email.com";
    private static final String EMAIL_AT_SIGN = "@";

    private static final int EMAIL_INDEX = 0;
    private static final int DOMAIN_INDEX = 1;
    private static final int NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {

        HashMap<String, String> separatedNameToEmail = new HashMap<>();

        return forms.stream()
                .map(form -> getInvalidEmails(separatedNameToEmail, form))
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .collect(toList());
    }

    private static List<String> getInvalidEmails(HashMap<String, String> separatedNameToEmail, List<String> form) {
        String email = getEmail(form);
        String nickname = getNickname(form);

        if (!isValidDomain(email)) {
            return List.of();
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String separatedNickName = nickname.substring(i, i + 2);
            String invalidEmail = separatedNameToEmail.putIfAbsent(separatedNickName, email);
            if (invalidEmail != null) {
                result.add(invalidEmail);
            }
        }

        if (!result.isEmpty()) {
            result.add(email);
        }

        return result;
    }

    private static String getNickname(List<String> form) {
        return form.get(NICKNAME_INDEX);
    }

    private static String getEmail(List<String> form) {
        return form.get(EMAIL_INDEX);
    }

    private static boolean isValidDomain(String email) {
        String domain = splitEmail(email)[DOMAIN_INDEX];
        return domain.equals(VALID_DOMAIN);
    }

    private static String[] splitEmail(String email) {
        return email.split(EMAIL_AT_SIGN);
    }
}
