package onboarding;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Problem6 {
    private static HashMap<Character, HashSet<Character>> nameMap = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> validCrewInfo = new LinkedList<>(); // info = name/email
        Set<String> invalidCrewEmails = new TreeSet<>();

        for (List<String> crew: forms){
            String email = crew.get(0), name = crew.get(1);
            String dSentence = getDuplicateSentenceOrBlank(name); //중복된 문자열

            if (dSentence.isBlank()){
                validCrewInfo.add(name + "/" + email);
                continue;
            }

            while (!dSentence.isBlank()){
                invalidCrewEmails.add(email);

                for (String crewInfo: getInvalidCrews(validCrewInfo, dSentence)){
                    String crewEmail = crewInfo.split("/")[1];
                    invalidCrewEmails.add(crewEmail);
                    validCrewInfo.remove(crewInfo);
                }
                dSentence = getDuplicateSentenceOrBlank(nextString(name, dSentence));
            }
        }

        answer.addAll(invalidCrewEmails);
        return answer;
    }

    private static String nextString(String name, String substring){
        int beginIndex = name.indexOf(substring) + 1;
        return name.substring(beginIndex);
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