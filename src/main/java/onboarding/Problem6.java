package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Problem6 {
    private static HashMap<Character, HashSet<Character>> nameMap = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> validCrewInfo = new LinkedList<>(); // info = name/email

        for (List<String> crew: forms){
            String email = crew.get(0), name = crew.get(1);
            String dSentence = getDuplicateSentenceOrBlank(name);

            if (dSentence != ""){
                break;
            }

            validCrewInfo.add(name + "/" + email);
        }
        return answer;
    }

    private static List<String> getInvalidCrews(List<String> validCrewInfo, String dSentence){
        List<String> invalidCrews = new ArrayList<>();
        for (String info: validCrewInfo){
            String name = info.split("/")[0];
            if (name.contains(dSentence)){
                invalidCrews.add(info);
            }
        }
        return invalidCrews;
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