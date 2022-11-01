package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem6 {
    private static final String ALLOWED_DOMAIN = "email.com";
    private static Map<String, List<String>> STUDENTS_INFO;
    private static Set<String> DUPLICATE_STUDENTS;

    public static List<String> solution(List<List<String>> forms) {
        init();
        for (List<String> info : forms) {
            String email = info.get(0);
            String nickName = info.get(1);
            if (!isAllowedDomain(email))
                throw new NotAllowedDomainException("허용되지 않는 도메인입니다.");
            addAllSubNickName(email, nickName);
        }
        findDuplicateNickNameUserEmail();
        return DUPLICATE_STUDENTS.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void init() {
        STUDENTS_INFO = new HashMap<>();
        DUPLICATE_STUDENTS = new HashSet<>();
    }

    private static boolean isAllowedDomain(String email) {
        return email.split("@")[1].equals(ALLOWED_DOMAIN);
    }

    private static void addAllSubNickName(String email, String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String subNickName = nickName.substring(i, i + 2);
            if (STUDENTS_INFO.containsKey(subNickName)) {
                STUDENTS_INFO.get(subNickName).add(email);
                continue;
            }
            List<String> initList = new ArrayList<>();
            initList.add(email);
            STUDENTS_INFO.put(subNickName, initList);
        }
    }

    private static void findDuplicateNickNameUserEmail() {
        for(List<String> emails : STUDENTS_INFO.values()) {
            if (emails.size() > 1)
                DUPLICATE_STUDENTS.addAll(emails);
        }
    }

    private static class NotAllowedDomainException extends IllegalArgumentException {
        public NotAllowedDomainException(String s) {
            super(s);
        }
    }
}
