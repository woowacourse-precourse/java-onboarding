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

    static final int EMAIL_START_RANGE = 11;
    static final int EMAIL_END_RANGE = 20;
    static final String EMAIL_SUFFIX = "@email.com";

    static final int NICKNAME_START_RANGE = 1;
    static final int NICKNAME_END_RANGE = 20;

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = fillDuplicateNameOwners(fillNameFragmentOwners(forms));

        Collections.sort(answer);
        return deduplicateInEmails(answer);
    }

    private static List<String> deduplicateInEmails(List<String> answer) {
        if(!isValidLength(answer, LIST_START_RANGE,LIST_END_RANGE)) {
            throw new InputMismatchException("리스트의 범위가 올바르지 않습니다.");
        }

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            deduplicateInEmail(answer, ret, i);
        }
        return ret;
    }

    private static void deduplicateInEmail(List<String> answer, List<String> ret, int i) {
        if (isDuplicatedEmail(answer, i)) {
            return;
        }

        ret.add(answer.get(i));
    }

    private static boolean isDuplicatedEmail(List<String> answer, int i) {
        return i != 0 && answer.get(i).equals(answer.get(i - 1));
    }

    private static List<String> fillDuplicateNameOwners(Map<String, List<String>> nameFragmentOwners) {
        List<String> ret = new ArrayList<>();
        for (List<String> owners : nameFragmentOwners.values()) {
            addDuplicateNameOwners(ret, owners);
        }
        return ret;
    }

    private static void addDuplicateNameOwners(List<String> ret, List<String> owners) {
        if (!isDuplicateNameFor(owners)) {
            return;
        }
        ret.addAll(owners);
    }

    private static boolean isDuplicateNameFor(List<String> owners) {
        return owners.size() != 1;
    }

    private static Map<String, List<String>> fillNameFragmentOwners(List<List<String>> forms) {
        Map<String, List<String>> nameFragmentOwners = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            addFragmentsOwner(nameFragmentOwners, email, nickname);
        }
        return nameFragmentOwners;
    }

    private static void addFragmentsOwner(Map<String, List<String>> nameFragmentOwners, String email, String nickname) {
        if(!isValidEmail(email)) {
            throw new InputMismatchException("유효하지 않은 이메일 형식입니다.");
        }
        if(!isValidNickname(nickname)) {
            throw new InputMismatchException("유효하지 않은 닉네임 형식입니다.");
        }
        for (int j = 0; j < nickname.length() - 1; ++j) {
            addFragmentOwner(nameFragmentOwners, email, getNameFragment(nickname, j));
        }
    }

    private static void addFragmentOwner(Map<String, List<String>> nameFragmentOwners, String email,
            String nicknameFragment) {
        if (isEmptyList(nameFragmentOwners, nicknameFragment)) {
            nameFragmentOwners.put(nicknameFragment, new ArrayList<>());
        }

        nameFragmentOwners.get(nicknameFragment).add(email);
    }

    private static String getNameFragment(String nickname, int j) {
        return nickname.substring(j, j + 2);
    }

    private static boolean isEmptyList(Map<String, List<String>> nameFragmentOwners, String nicknameFragment) {
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

    private static boolean isValidEmail(String email) {
        if(!isValidLength(email, EMAIL_START_RANGE, EMAIL_END_RANGE -1))
            return false;

        return isEmailSuffixValid(email.substring(email.length() - EMAIL_SUFFIX.length()), EMAIL_SUFFIX);
    }

    private static boolean isEmailSuffixValid(String email, String emailSuffix) {
        return email.equals(emailSuffix);
    }

}
