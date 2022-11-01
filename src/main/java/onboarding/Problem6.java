package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class Problem6 {

    private final static int EMAIL_INDEX = 0;
    private final static int NICKNAME_INDEX = 1;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkNameDuplication(forms,addTwoLettersFromName(forms));

        return answer;
    }
    private static HashMap<String,Integer> addTwoLettersFromName(List<List<String>> forms){
        HashMap<String,Integer> twoLettersFromName = new HashMap<>();
        for(List<String> form: forms){
            for(int i=0; i<form.get(1).length()-1;i++ ){
                String twoLetters = form.get(NICKNAME_INDEX).substring(i,i+2);
                twoLettersFromName.put(twoLetters,
                        twoLettersFromName.getOrDefault(twoLetters,0)+1);
            }
        }
        return twoLettersFromName;
    }

    private static List<String> checkNameDuplication (List<List<String>> forms,
                                                      HashMap<String,Integer> duplicatedTwoLettersFromName){
    List<String> resultEmail = new ArrayList<>();
    for(List<String> form : forms){
        for(int i=0; i<form.get(NICKNAME_INDEX).length()-1;i++){
            String twoLetters = form.get(NICKNAME_INDEX).substring(i,i+2);
            if(duplicatedTwoLettersFromName.get(twoLetters)>1)
                resultEmail.add(form.get(EMAIL_INDEX));
        }
    }
    return resultEmail;
    }
}
