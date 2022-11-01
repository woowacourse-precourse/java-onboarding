package onboarding;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> dup_mail = new HashSet<>();
        HashMap<String,String> dup_word = new HashMap<>();

        for (int i = 0; i<forms.size(); i++){
            String Email = forms.get(i).get(0);
            String user_name = forms.get(i).get(1);

            for (int j = 0;j < user_name.length() - 1; j++){
                String word = user_name.substring(j, j+2);
                if (dup_word.get(word) == null){
                    dup_word.put(word, Email);
                }
                else if (dup_word.get(word) != Email){
                    dup_mail.add(Email);
                    dup_mail.add(dup_word.get(word));
                }
            }
        }
        List<String> answer = new ArrayList<>(dup_mail);
        Collections.sort(answer);
        return answer;
    }
}
