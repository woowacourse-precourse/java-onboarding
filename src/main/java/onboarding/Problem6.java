package onboarding;

import java.util.*;

public class Problem6 {

    private static Set<String> nicknamePieces;
    private static Set<String> duplicatedNicknamePieces;

    private static Set<String> createNicknamePieces(List<List<String>> forms) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String temp = nickname.substring(i, i+2);
                if (nicknamePieces.contains(temp)) {
                    duplicatedNicknamePieces.add(temp);
                }
                else {
                    nicknamePieces.add(temp);
                }
            }
        }
        return duplicatedNicknamePieces;
    }

    private static boolean isDuplicated(String nickname) {
        for (String piece : duplicatedNicknamePieces) {
            if (nickname.contains(piece)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        nicknamePieces = new HashSet<>();
        duplicatedNicknamePieces = new HashSet<>();
        List<String> answer = new ArrayList<>();

        duplicatedNicknamePieces = createNicknamePieces(forms);

        for (List<String> form : forms) {
            String nickname = form.get(1);
            if (isDuplicated(nickname)) {
                answer.add(form.get(0));
            }
        }
        Collections.sort(answer);

        return answer;
    }
}
