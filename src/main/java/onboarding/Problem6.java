package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static HashMap<String, ArrayList<String>> findDuplicateNickname(String nickname, List<List<String>> forms, HashMap<String, ArrayList<String>> map) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String partialNickname = getPartialNicknameToValidate(i, nickname);
        }

        return map;
    }

    private static String getPartialNicknameToValidate(int idx, String nickname) {
        StringBuilder sb = new StringBuilder();

        for (int i = idx; i < idx + 2; i++) {
            sb.append(nickname.charAt(i));
        }

        String partialNicknameToValidate = sb.toString();
        return partialNicknameToValidate;
    }
}
