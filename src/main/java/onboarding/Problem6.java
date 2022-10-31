package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> nicknamePieces = new HashMap<>();

        for (List<String> crewInfo : forms) {
            String nickname = crewInfo.get(NICKNAME);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String piece = nickname.substring(i, i + 2);

                List<String> emailList = nicknamePieces.getOrDefault(piece, new ArrayList<>());
                String email = crewInfo.get(EMAIL);

                if (emailList.contains(email)) {
                    continue;
                }

                emailList.add(email);
                nicknamePieces.put(piece, emailList);
            }

        }

        return answer;
    }
}
