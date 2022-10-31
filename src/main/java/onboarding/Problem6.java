package onboarding;

import java.util.*;


public class Problem6 {
    private static final String ALLOWED_DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> info : forms) {
            String email = info.get(0);
            String nickName = info.get(1);
            if (!isAllowedDomain(email)) {
                throw new NotAllowedDomainException("허용되지 않는 도메인입니다.");
            }
        }
        return new ArrayList<>();
    }

    private static boolean isAllowedDomain(String email) {
        return email.split("@")[1].equals(ALLOWED_DOMAIN);
    }

    private static class NotAllowedDomainException extends IllegalArgumentException {
        public NotAllowedDomainException(String s) {
            super(s);
        }
    }
}
