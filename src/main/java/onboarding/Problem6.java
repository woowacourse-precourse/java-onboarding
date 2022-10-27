package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    public static final int EMAIL = 0;
    public static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, Integer> twoLetterHashMap = new HashMap<>();

        for (List<String> form : forms) {
            twoLetterHashMap = putTwoLetters(form, twoLetterHashMap);
        }

        answer = getRepetitionEmail(forms, twoLetterHashMap);
        
        return answer;
    }

    public static HashMap<String, Integer> putTwoLetters(List<String> form, HashMap<String, Integer> twoLetterHashMap) {
        String targetNickname = form.get(NICKNAME);

        for (int i = 0; i < targetNickname.length() - 1; i++) {
            String twoLetter = targetNickname.substring(i, i + 2);
            twoLetterHashMap.put(twoLetter, twoLetterHashMap.getOrDefault(twoLetter, 0) + 1);
        }

        return twoLetterHashMap;
    }

    public static List<String> getRepetitionEmail(List<List<String>> forms, HashMap<String, Integer> twoLetterHashMap) {
        List<String> emailList = new ArrayList<>();

        String targetNickname;
        String targetEmail;

        for (List<String> form : forms) {
            targetNickname = form.get(NICKNAME);
            targetEmail = form.get(EMAIL);

            for (int i = 0; i < targetNickname.length() - 1; i++) {
                String twoLetter = targetNickname.substring(i, i+2);
                if(twoLetterHashMap.get(twoLetter) > 1) {
                    emailList.add(targetEmail);
                }
            }
        }

        return emailList;
    }

}
