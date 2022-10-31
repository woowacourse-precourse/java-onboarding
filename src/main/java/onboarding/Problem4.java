package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        List<String>list = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i);
            if(word.charAt(i)==32){
                list.add(String.valueOf((char) idx));
            }
            else if(word.charAt(i)>32&&word.charAt(i)<91){
                list.add(String.valueOf((char)(155-idx)));
            }
            else list.add(String.valueOf((char)(219-idx)));
        }
        for(int i=0;i<list.size();i++){
            answer.append(list.get(i));
        }

        return answer.toString();
    }
}