package onboarding;

import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static HashSet<String> makeLetterSet(List<List<String>> forms) {
        HashSet<String> letters = new HashSet<>();
        for(List<String> crew : forms){
            String nickname = crew.get(1);
            for(int i = 0; i < nickname.length() - 1; i++){
                letters.add(nickname.substring(i, i + 2));
            }
        }
        return letters;
    }
}
