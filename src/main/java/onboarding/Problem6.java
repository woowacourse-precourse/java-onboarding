package onboarding;

import java.util.*;

public class Problem6 {
    public static String parseNicknameWithIndex(
            String nickname, int startIndex, int endIndex, int destinationIndex
    ) {
        char[] sequentialNickname = new char[endIndex - startIndex + 1];
        nickname.getChars(startIndex, endIndex, sequentialNickname, destinationIndex);

        return String.valueOf(sequentialNickname);
    }

    public static boolean isDuplicated(String nickname, String targetNickname) {

    }


    public static List<String> getDuplicatedMemberEmails(List<List<String>> forms) {

    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicatedMemberEmails(forms);

        return answer;
    }
}
