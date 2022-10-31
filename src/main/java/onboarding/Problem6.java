package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = checkNicknameDuplication(forms);
        return answer;
    }

    private static List<String> checkNicknameDuplication(List<List<String>> memberList) {
        SortedSet<String> checkedEmail = new TreeSet<>();
        List<String> member, compareMember, nicknamePieces;
        String nickname, email, compareNickname, compareEmail;

        for (int i = 0; i < memberList.size() - 1; i++) {
            member = memberList.get(i);
            email = member.get(0);
            nickname = member.get(1);

            if (checkNicknameLength(nickname)) {
                continue;
            }
            nicknamePieces = seperateNickName(nickname);

            for (int j = i + 1; j < memberList.size(); j++) {
                compareMember = memberList.get(j);
                compareEmail = compareMember.get(0);
                compareNickname = compareMember.get(1);

                if (checkDuplication(compareNickname, nicknamePieces)) {
                    checkedEmail.addAll(Arrays.asList(email, compareEmail));
                }
            }
        }
        return new ArrayList<>(checkedEmail);
    }

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

    private static List<String> seperateNickName(String nickname) {
        List<String> nickNamePieces = new ArrayList<>();
        String piece;
        for (int i = 0; i < nickname.length() - 1; i++) {
            piece = nickname.substring(i, i + 2);
            nickNamePieces.add(piece);
        }
        return nickNamePieces;
    }

    private static boolean checkNicknameLength(String nickname) {
        if (nickname.length() < 2) {
            return true;
        }
        return false;
    }
}
