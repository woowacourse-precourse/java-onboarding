package onboarding;

import java.util.*;

public class Problem6 {
    private static final int SEPERATE_STANDARD = 2;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = checkNicknameDuplication(forms);
        return answer;
    }

    // 전체 맴버 닉네임 중복 검증
    private static List<String> checkNicknameDuplication(List<List<String>> memberList) {
        SortedSet<String> duplicateMemberEmail = new TreeSet<>();
        List<String> member, compareMember, nicknamePieces;
        String nickname, email, compareNickname, compareEmail;

        for (int i = 0; i < memberList.size() - 1; i++) {
            member = memberList.get(i);
            email = member.get(0);
            nickname = member.get(1);

            if (checkNicknameLength(nickname)) {
                continue;
            }
            nicknamePieces = seperateNickname(nickname);

            for (int j = i + 1; j < memberList.size(); j++) {
                compareMember = memberList.get(j);
                compareEmail = compareMember.get(0);
                compareNickname = compareMember.get(1);

                if (checkDuplication(compareNickname, nicknamePieces)) {
                    duplicateMemberEmail.addAll(Arrays.asList(email, compareEmail));
                }
            }
        }
        return new ArrayList<>(duplicateMemberEmail);
    }

    // 입력받은 닉네임과 중복 검사 단위로 나눈 문자열의 중복 사항 검증
    private static boolean checkDuplication(String nickname, List<String> nicknamePieces) {
        boolean sign = false;
        for (String piece : nicknamePieces) {
            if (nickname.contains(piece)) {
                sign = true;
                break;
            }
        }
        return sign;
    }

    // 닉네임을 2글자씩 분리
    private static List<String> seperateNickname(String nickname) {
        List<String> nickNamePieces = new ArrayList<>();
        String piece;
        for (int i = 0; i < nickname.length() - 1; i++) {
            piece = nickname.substring(i, i + SEPERATE_STANDARD);
            nickNamePieces.add(piece);
        }
        return nickNamePieces;
    }

    private static boolean checkNicknameLength(String nickname) {
        if (nickname.length() < SEPERATE_STANDARD) {
            return true;
        }
        return false;
    }
}
