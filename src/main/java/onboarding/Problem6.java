package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static List<String> getWord(String word,int index){
        List<String> words = new ArrayList<>();
        for(int i=0;i<word.length()-1;i++){
            words.add(word.substring(i,i+2));
        }
        return words;
    }
}
