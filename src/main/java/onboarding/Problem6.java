package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    private static final String VALID_DOMAIN = "email.com";
    private static final String EMAIL_AT_SIGN = "@";

    private static final int EMAIL_INDEX = 0;
    private static final int DOMAIN_INDEX = 1;
    private static final int NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {

        HashMap<String, String> separatedNameToEmail = new HashMap<>();
        HashSet<String> result = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX);
            String nickname = form.get(NICKNAME_INDEX);
            if (!isValidDomain(email)) {
                continue;
            }
        }

        return List.of();
    }

    private static boolean isValidDomain(String email) {
        String domain = splitEmail(email)[DOMAIN_INDEX];
        return domain.equals(VALID_DOMAIN);
    }

    private static String[] splitEmail(String email) {
        return email.split(EMAIL_AT_SIGN);
    }
}
