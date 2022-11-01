package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String,String> segments = new HashMap<>();
        List<String> emails = new ArrayList<>();

        for (List<String> crew : forms) {
            if ( crew.get(1).length() == 1) { continue; }
            checkDuplication(crew,emails,segments);
        }

        List<String> answers = removeDuplication(emails);
        Collections.sort(answers);
        return answers;
    }

    public static void checkDuplication (List<String> crew, List<String> emails, Map<String, String> segments) {
        String crewEmail = crew.get(0);
        String crewName = crew.get(1);
        for (int i=0; i<crewName.length()-1; i++) {
            String word = crewName.charAt(i) + "" + crewName.charAt(i+1);
            addDuplicateEmail(word,crewEmail,segments,emails);
        }
    }

    public static void addDuplicateEmail(String word, String crewEmail, Map<String,String> segments, List<String> emails) {
        if (segments.containsKey(word)) {
            emails.add(segments.get(word));
            emails.add(crewEmail);
        }
        if(!segments.containsKey(word)) {
            segments.put(word,crewEmail);
        }
    }

    public static List<String> removeDuplication(List<String> emails) {
        Set<String> removeDuplicateSet = new HashSet<String>(emails);
        return new ArrayList<>(removeDuplicateSet);
    }
}
