package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        Map<String, List<String>> nicknamePieces = new HashMap<>();

        for (List<String> crewInfo : forms) {
            String nickname = crewInfo.get(NICKNAME);

            if (nickname.length() < 2) {
                continue;
            }

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

        answer = arrangeEmails(nicknamePieces);
        return answer;
    }

    private static List<String> arrangeEmails(Map<String, List<String>> nicknamePieces) {
        Set<String> emails = new TreeSet<>();

        for (String piece : nicknamePieces.keySet()) {
            List<String> emailList;

            if ((emailList = nicknamePieces.get(piece)).size() > 1) {
                emails.addAll(new TreeSet<>(emailList));
            }
        }

        return new ArrayList<>(emails);
    }
}
