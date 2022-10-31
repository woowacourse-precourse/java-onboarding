package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem6 {
    private static final String ALLOWED_DOMAIN = "email.com";
    private static final Map<String, List<String>> studentInfo = new HashMap<>();
    private static final Set<String> duplicateStudents = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> info : forms) {
            String email = info.get(0);
            String nickName = info.get(1);
            if (!isAllowedDomain(email)) {
                throw new NotAllowedDomainException("허용되지 않는 도메인입니다.");
            }
            addAllSubNickName(email, nickName);
        }
        findDuplicateNickNameUserEmail();
        return duplicateStudents.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean isAllowedDomain(String email) {
        return email.split("@")[1].equals(ALLOWED_DOMAIN);
    }

    private static void addAllSubNickName(String email, String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String subNickName = nickName.substring(i, i + 2);
            if (studentInfo.containsKey(subNickName)) {
                studentInfo.get(subNickName).add(email);
                continue;
            }
            List<String> initList = new ArrayList<>();
            initList.add(email);
            studentInfo.put(subNickName, initList);
        }
    }

    private static void findDuplicateNickNameUserEmail() {
        for(List<String> emails : studentInfo.values()) {
            if (emails.size() > 1) {
                duplicateStudents.addAll(emails);
            }
        }
    }

    private static class NotAllowedDomainException extends IllegalArgumentException {
        public NotAllowedDomainException(String s) {
            super(s);
        }
    }
}
