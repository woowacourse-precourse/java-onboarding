package onboarding;

import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class Problem6 {
    private static HashMap<Character, HashSet<Character>> nameMap = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static String getDuplicateSentenceOrBlank(String name) {
        String result = "";
        HashSet<Character> nextCharacters = getNextCharacters(name.charAt(0));
        char previous = name.charAt(0);

        for (int i = 1; i < name.length(); i++) {
            char current = name.charAt(i);

            if (nextCharacters.contains(current)) {
                result = "" + previous + current;
                break;
            }
            nextCharacters.add(current);
            nextCharacters = getNextCharacters(current);
            previous = current;
        }
        return result;
    }

    private static HashSet<Character> getNextCharacters(char currentCharacter){
        if (!nameMap.containsKey(currentCharacter)){
            nameMap.put(currentCharacter, new HashSet<>());
        }
        return nameMap.get(currentCharacter);
    }
}