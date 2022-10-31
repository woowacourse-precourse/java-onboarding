package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class Problem6 {

    static final int LIST_START_RANGE = 1;
    static final int LIST_END_RANGE = 10_000;


    static final int NICKNAME_START_RANGE = 1;
    static final int NICKNAME_END_RANGE = 20;

    public static List<String> solution(List<List<String>> forms) {

        List<Email> emailList = fillDuplicateNameOwners(fillNameFragmentOwners(forms));

        Collections.sort(emailList);
        return deduplicateInEmails(emailList);
    }

    private static List<String> deduplicateInEmails(List<Email> answer) {
        if (!isValidLength(answer, LIST_START_RANGE, LIST_END_RANGE)) {
            throw new InputMismatchException("리스트의 범위가 올바르지 않습니다.");
        }

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            deduplicateInEmail(answer, ret, i);
        }
        return ret;
    }

    private static void deduplicateInEmail(List<Email> answer, List<String> ret, int i) {
        if (isDuplicatedEmail(answer, i)) {
            return;
        }

        ret.add(answer.get(i).getValue());
    }

    private static boolean isDuplicatedEmail(List<Email> answer, int i) {
        return i != 0 && answer.get(i).equals(answer.get(i - 1));
    }

    private static List<Email> fillDuplicateNameOwners(Map<String, List<Email>> nameFragmentOwners) {
        List<Email> ret = new ArrayList<>();
        for (List<Email> owners : nameFragmentOwners.values()) {
            addDuplicateNameOwners(ret, owners);
        }
        return ret;
    }

    private static void addDuplicateNameOwners(List<Email> ret, List<Email> owners) {
        if (!isDuplicateNameFor(owners)) {
            return;
        }
        ret.addAll(owners);
    }

    private static boolean isDuplicateNameFor(List<Email> owners) {
        return owners.size() != 1;
    }

    private static Map<String, List<Email>> fillNameFragmentOwners(List<List<String>> forms) {
        Map<String, List<Email>> nameFragmentOwners = new HashMap<>();

        for (List<String> form : forms) {
            Email email = makeEmail(form.get(0));
            String nickname = form.get(1);

            addFragmentsOwner(nameFragmentOwners, email, nickname);
        }
        return nameFragmentOwners;
    }

    private static void addFragmentsOwner(Map<String, List<Email>> nameFragmentOwners, Email email, String nickname) {
        if (!isValidNickname(nickname)) {
            throw new InputMismatchException("유효하지 않은 닉네임 형식입니다.");
        }
        for (int j = 0; j < nickname.length() - 1; ++j) {
            addFragmentOwner(nameFragmentOwners, email, getNameFragment(nickname, j));
        }
    }

    private static void addFragmentOwner(Map<String, List<Email>> nameFragmentOwners, Email email,
            String nicknameFragment) {
        if (isEmptyList(nameFragmentOwners, nicknameFragment)) {
            nameFragmentOwners.put(nicknameFragment, new ArrayList<>());
        }

        nameFragmentOwners.get(nicknameFragment).add(email);
    }

    private static String getNameFragment(String nickname, int j) {
        return nickname.substring(j, j + 2);
    }

    private static boolean isEmptyList(Map<String, List<Email>> nameFragmentOwners, String nicknameFragment) {
        return nameFragmentOwners.get(nicknameFragment) == null;
    }

    private static boolean isValidLength(String str, int start, int end) {
        return start <= str.length() && str.length() <= end;
    }

    private static boolean isValidLength(List<?> list, int start, int end) {
        return start <= list.size() && list.size() <= end;
    }

    private static boolean isValidNickname(String nickname) {
        if (!isValidLength(nickname, NICKNAME_START_RANGE, NICKNAME_END_RANGE - 1)) {
            return false;
        }
        if (isHangul(nickname.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"))) {
            return false;
        }

        return true;
    }

    private static boolean isHangul(boolean nickname) {
        return !nickname;
    }

    public static Email makeEmail(String email) {
        return new Email(email);
    }

    static class Email implements Comparable<Email> {
        
        final int EMAIL_START_RANGE = 11;
        final int EMAIL_END_RANGE = 20;
        final String EMAIL_SUFFIX = "@email.com";

        private String value;

        public Email(String value) {
            if (!isValidEmail(value)) {
                throw new InputMismatchException("유효하지 않은 이메일 형식입니다.");
            }

            this.value = value;
        }


        public String getValue() {
            return value;
        }

        private boolean isValidEmail(String email) {
            if (!isValidLength(email, EMAIL_START_RANGE, EMAIL_END_RANGE - 1)) {
                return false;
            }

            return isEmailSuffixValid(email.substring(email.length() - EMAIL_SUFFIX.length()));
        }

        private boolean isEmailSuffixValid(String email) {
            return email.equals(EMAIL_SUFFIX);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Email email = (Email) o;
            return getValue().equals(email.getValue());
        }

        @Override
        public int compareTo(Email o) {
            return getValue().compareTo(o.getValue());
        }
    }

}
