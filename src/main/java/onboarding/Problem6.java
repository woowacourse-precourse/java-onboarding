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
        for (int i = 0; i < nickname.length() - 1; i++) {
            String parsedCharacter = parseNicknameWithIndex(nickname, i, i+2, 0);
            if (targetNickname.contains(parsedCharacter.trim())) {
                System.out.println("Hello");
                return true;
            }
        }

        return false;
    }


    public static List<String> getDuplicatedMemberEmails(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); j++) {
                String targetEmail = forms.get(j).get(0);
                String targetNickname = forms.get(j).get(1);

                if (isDuplicated(nickname, targetNickname)) {
                    emails.add(email);
                    emails.add(targetEmail);
                }
            }
        }

        List<String> sortedEmails = new ArrayList<>(emails);
        Collections.sort(sortedEmails);

        return sortedEmails;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicatedMemberEmails(forms);

        return answer;
    }
}
