package onboarding;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

public class Problem6 {
    private static HashMap<String, String> TwoCharacterMap = new HashMap<>();

    public static List<String> splitNameEveryTwoCharacter(String name){
        List<String> twoCharacterList = new LinkedList<>();
        for(int i = 0; i < name.length() - 1; i++){
            String twoCharacters = name.substring(i, i + 2);
            twoCharacterList.add(twoCharacters);
        }
        return twoCharacterList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }
}
