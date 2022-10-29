package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String,Set<String>> words = new HashMap<>();

        for(int i=0;i<forms.size();i++){
            List<String> word = getWord(forms.get(i).get(1));
            word.stream().map((w) -> words.put(w,))
        }
        return answer;
    }
    public static List<String> getWord(String word){
        List<String> words = new ArrayList<>();
        for(int i=0;i<word.length()-1;i++){
            words.add(word.substring(i,i+2));
        }
        return words;
    }
}
