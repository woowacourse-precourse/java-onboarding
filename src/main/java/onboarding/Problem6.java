package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static final int EMAIL = 0;
    public static final int NICKNAME = 1;

    public static HashMap<String, String> crews;
    public static List<String> answer;
    public static HashSet<String> keywords;

    public static List<String> solution(List<List<String>> forms) {
        answer = new ArrayList<>();
        crews = toHashMap(forms);
        keywords = new HashSet<>();

        findRepeatedWords(crews.keySet());
        findSimilar(crews.keySet());
        trim();
        
        return answer;
    }

    public static HashMap<String, String> toHashMap(List<List<String>> forms) {
        HashMap<String, String> crewInfo = new HashMap<>();
        for(List<String> crew : forms) {
            crewInfo.putIfAbsent(crew.get(NICKNAME), crew.get(EMAIL));
        }
        return crewInfo;
    }

    public static void findRepeatedWords(Set<String> nicknames) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        for(String nickname : nicknames) {
            for(int i = 0; i < nickname.length() - 1; i++) {
                String word = nickname.substring(i, i+2);
                wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
            }
        }

        wordCount.forEach((word, count) -> {
            if(count > 1)
                keywords.add(word);
        });
    }

    public static void findSimilar(Set<String> nicknames) {
        for(String nickname : nicknames) {
            for(String keyword : keywords) {
                if(nickname.contains(keyword)){
                    saveEmail(nickname);
                    break;
                }
            }
        }
    }

    public static void saveEmail(String nickname) {
        answer.add(crews.get(nickname));
    }

    public static void trim() {
        answer = answer.stream().distinct().sorted().collect(Collectors.toList());
    }

}
