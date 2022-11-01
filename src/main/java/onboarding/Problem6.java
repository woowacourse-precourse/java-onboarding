package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, Integer> letters = makeLetter(forms);

        return answer;
    }

    private static HashMap<String, Integer> makeLetter(List<List<String>> forms) {
        HashMap<String, Integer> letters = new HashMap<>();
        for (List<String> crew : forms) {
            String nickname = crew.get(1);
            for (int j=0; j<nickname.length()-1; j++) {
                String nick = nickname.substring(j, j+2);
                letters.put(nick, letters.getOrDefault(nick, 0)+1);
            }
        }
        return letters;
    }
}
