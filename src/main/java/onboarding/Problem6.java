package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {

    private static Set<String> duplicatedMembers = new HashSet<>();
    private static List<String> joinedMembers = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicateMemberList(forms);

        try {
            validateData(forms);
        } catch (IllegalArgumentException e) {
            return null;
        }

        Collections.sort(answer);
        return answer;
    }

    private static void validateData(List<List<String>> forms) throws IllegalArgumentException {
        validateCrewSize(forms);
        validateEmail(forms);
        validateNickname(forms);
    }

    private static void validateCrewSize(List<List<String>> forms) throws IllegalArgumentException {
        if (!(1 <= forms.size()) && (forms.size() >= 10000)) {
            throw new IllegalArgumentException("올바른 크루원의 수가 아닙니다");
        }
    }
    private static void validateEmail(List<List<String>> forms) throws IllegalArgumentException {
        for (List<String> form : forms) {
            String email = form.get(0);
            if (!((11 <= email.length()) && (email.length() < 20))) {
                throw new IllegalArgumentException("올바른 이메일의 길이는 11 이상 20 미만입니다.");
            }

            final String EMAIL_REGEX  = "^\\w+@email\\.com";
            if (!Pattern.matches(EMAIL_REGEX, email)) {
                throw new IllegalArgumentException("유효한 이메일 형태가 아닙니다.");
            }
        }
    }

    private static void validateNickname(List<List<String>> forms) throws IllegalArgumentException {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            if (!((1 <= nickname.length()) && (nickname.length() < 20))) {
                throw new IllegalArgumentException("올바른 닉네임의 길이는 1 이상 20 미만입니다.");
            }

            final String NICKNAME_REGEX = "[가-힣]+$";
            if (!Pattern.matches(NICKNAME_REGEX, nickname)) {
                throw new IllegalArgumentException("유효한 이메일 형태가 아닙니다.");
            }
        }
    }

    private static List<String> getDuplicateMemberList(List<List<String>> forms) {
        for (List<String> form : forms) {
            String name = form.get(1);
            join(name);
        }

        return getDuplicateMemberEmailList(forms);
    }

    private static void join(String searchName) {
        findDuplicateMember(searchName);
        joinedMembers.add(searchName);
    }

    private static void findDuplicateMember(String searchName) {
        List<String> searchingNicknamePieces = getDividableNicknameList(searchName);

        for (String joinedMember : joinedMembers) {
            for (String searchingNicknamePiece : searchingNicknamePieces) {
                if (joinedMember.contains(searchingNicknamePiece)) {
                    duplicatedMembers.add(searchName);
                    duplicatedMembers.add(joinedMember);
                }
            }
        }
    }

    private static List<String> getDividableNicknameList(String nickname) {
        List<String> nicknameSlices = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            nicknameSlices.add(nickname.substring(i, i + 2));
        }
        return nicknameSlices;
    }

    private static List<String> getDuplicateMemberEmailList(List<List<String>> forms) {
        List<String> duplicateMemberEmailList = new ArrayList<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            String email = form.get(0);

            if (duplicatedMembers.contains(name)) {
                duplicateMemberEmailList.add(email);
            }
        }
        return duplicateMemberEmailList;
    }

}
