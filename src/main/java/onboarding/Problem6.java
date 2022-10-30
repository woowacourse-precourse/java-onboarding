package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> crewDictionary = new HashMap<>();
        validateDuplicateEmail(forms, crewDictionary);
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void validateDuplicateEmail(List<List<String>> forms,HashMap<String, String> crewDictionary){
        for(int i=0; i< forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            if(crewDictionary.containsKey(email)){
                throw new IllegalArgumentException("이미 해당 이메일이 존재합니다");
            }
            crewDictionary.put(email, nickname);
      }
    }

    public static HashSet<String> getAllTwoLengthWords(String words){
        HashSet<String> twoLengthWords = new HashSet<>();
        for(int i=1; i<words.length(); i++){
            String twoWords = Character.toString(words.charAt(i-1)) + words.charAt(i);
            twoLengthWords.add(twoWords);
        }
      return twoLengthWords;
  }
}
