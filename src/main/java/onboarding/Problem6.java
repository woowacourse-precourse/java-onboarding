package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static final int MIN_CREW_NUM = 1;
    private static final int MAX_CREW_NUM = 10000;
    private static final int MIN_EMAIL_SIZE = 11;
    private static final int MAX_EMAIL_SIZE = 20;
    private static final int MIN_NICKNAME_SIZE = 1;
    private static final int MAX_NICKNAME_SIZE = 20;
    private static final String FIXED_DOMAIN = "email.com";
    private static final String EMAIL_PATTERN = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-z]{2,6}$";
    private static final String HANGEUL_PATTERN = "^[가-힣]*$";
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void sortDuplicatedEmail(List<String> duplicatedEmail) {
        Collections.sort(duplicatedEmail);
    }
    private static List<String> makeDuplicatedEmails(List<List<String>> forms) {
        List<String> duplicatedEmail = new ArrayList<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                String nickname1 = forms.get(i).get(1);
                String nickname2 = forms.get(j).get(1);
                String email1 = forms.get(i).get(0);
                String email2 = forms.get(j).get(0);
                if (checkDuplication(nickname1, nickname2)) {
                    addDuplicatedEmail(duplicatedEmail, email1);
                    addDuplicatedEmail(duplicatedEmail, email2);
                }
            }
        }
        return duplicatedEmail;
    }

    private static void addDuplicatedEmail(List<String> duplicatedEmail, String email) {
        if (!duplicatedEmail.contains(email)) {
            duplicatedEmail.add(email);
        }
    }
    private static boolean checkDuplication(String nickname1, String nickname2) {
        for (int i = 0; i < nickname1.length() - 1; i++) {
            for (int j = 0; j < nickname2.length() - 1; j++) {
                if (checkEquals(nickname1, nickname2, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkEquals(String nickname1, String nickname2, int i, int j) {
        if (nickname1.substring(i, i + 2).equals(nickname2.substring(j, j + 2))) {
            return true;
        }
        return false;
    }
    private static void validateNickName(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            if (!Pattern.matches(HANGEUL_PATTERN, nickName)) {
                throw new IllegalArgumentException("한글 닉네임만 사용 가능합니다");
            }
            if (nickName.length() < MIN_NICKNAME_SIZE || nickName.length() >= MAX_NICKNAME_SIZE) {
                throw new IllegalArgumentException("닉네임은 1자 이상 20자 미만입니다");
            }
        }
    }

    private static void validateEmailExpression(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            if (!Pattern.matches(EMAIL_PATTERN, email)) {
                throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
            }
        }
    }

    private static void validateEmailSize(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            if (email.length() < MIN_EMAIL_SIZE || email.length() >= MAX_EMAIL_SIZE) {
                throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 미만이어야 합니다");
            }
        }
    }

    private static void validateDomain(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String domain = email.substring(email.length() - 9);
            if (!domain.equals(FIXED_DOMAIN)) {
                throw new IllegalArgumentException("\"email.com\" 형식의 도메인만 가능합니다");
            }
        }
    }

    private static void validateCrewMemberNum(List<List<String>> forms) {
        if (forms.size() < MIN_CREW_NUM || forms.size() > MAX_CREW_NUM) {
            throw new IllegalArgumentException("크루는 1명 이상 10000명 이하여야 합니다");
        }
    }
}
