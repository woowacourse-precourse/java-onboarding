package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, List<String>> nicknamePartsMap = new HashMap<>();
        Set<String> answerSet = new HashSet<>();


        for (var form:forms) {
            String eMail = form.get(0);
            List<String> nicknameParts = getNicknameParts(form.get(1));
            for (var nicknamePart : nicknameParts) {
                try{
                    nicknamePartsMap.get(nicknamePart).add(eMail);
                }catch (NullPointerException e) {
                    List<String> eMails = new ArrayList<>();
                    eMails.add(eMail);
                    nicknamePartsMap.put(nicknamePart, eMails);
                }
            }
        }

        for (var key:nicknamePartsMap.keySet()) {
            List<String> eMails = nicknamePartsMap.get(key);
            if (eMails.size() < 2)
                continue;
            answerSet.addAll(eMails);
        }
        answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        return answer;
    }
    public static List<String> getNicknameParts(String nickname) {
        ArrayList<String> nicknameParts = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            nicknameParts.add(nickname.substring(i, i + 2));
        }
        return nicknameParts;
    }
}
