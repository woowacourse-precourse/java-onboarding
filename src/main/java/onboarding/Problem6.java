package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }
    private static HashMap<String,Integer> checkNicknameDuplication(List<List<String>> forms){
        HashMap<String,Integer> nicknameDuplication = new HashMap<>();
        for(List<String> form: forms){
            for(int i=0; i<form.get(1).length();i++ ){
                String twoWords = form.get(1).substring(i,i+2);
                nicknameDuplication.put(twoWords,
                        nicknameDuplication.getOrDefault(twoWords,0)+1);
            }
        }
        return nicknameDuplication;
    }
}
