package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> crewDictionary = new HashMap<>();
        validateDuplicateEmail(forms, crewDictionary);
        List<String> allDuplicateWords = findAllDuplicateWords(crewDictionary);
        List<String> answer = findCrewApplyingDuplicateWordsInNickname(crewDictionary, allDuplicateWords);
        return answer;
    }

    public static void validateDuplicateEmail(List<List<String>> forms, HashMap<String, String> crewDictionary){
        for(int i=0; i< forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            if(crewDictionary.containsKey(email)){
                throw new IllegalArgumentException("이미 해당 이메일이 존재합니다");
            }
            crewDictionary.put(email, nickname);
      }
    }

    public static List<String> findCrewApplyingDuplicateWordsInNickname(HashMap<String, String> crewDictionary, List<String> allDuplicateWords){
        return crewDictionary.keySet()
                      .stream()
                      .filter(email -> findDuplicateNickname(crewDictionary.get(email), allDuplicateWords))
                      .collect(Collectors.toList());

    }

    public static boolean findDuplicateNickname(String nickname, List<String> allDuplicateWords){
        for(String words: allDuplicateWords){
            if(nickname.contains(words)){
                return true;
            }
        }
        return false;
    }

    public static List<String> findAllDuplicateWords(HashMap<String, String> crewDictionary){
        HashMap<String, Integer> countDuplicateWords = new HashMap<>();
        for(String words: crewDictionary.values()){
            HashSet<String> allTwoWords = getAllTwoLengthWords(words);
            allTwoWords.forEach(twoWords -> addWordsInDuplicateWords(twoWords, countDuplicateWords));
        }
        return filterDuplicateUsed(countDuplicateWords);
    }

    public static void addWordsInDuplicateWords(String words, HashMap<String, Integer> countDuplicateWords){
        countDuplicateWords.put(words, countDuplicateWords.getOrDefault(words,0) + 1);
    }

    public static HashSet<String> getAllTwoLengthWords(String words){
        HashSet<String> twoLengthWords = new HashSet<>();
        for(int i=1; i<words.length(); i++){
            String twoWords = Character.toString(words.charAt(i-1)) + words.charAt(i);
            twoLengthWords.add(twoWords);
        }
      return twoLengthWords;
  }

    public static List<String> filterDuplicateUsed(HashMap<String, Integer> countDuplicateWords){
        return countDuplicateWords.keySet().stream().filter(words -> countDuplicateWords.get(words)>1).collect(Collectors.toList());
    }
}
