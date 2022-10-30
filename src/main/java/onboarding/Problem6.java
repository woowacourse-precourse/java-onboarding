package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> saveEmail = new ArrayList<>();
        HashSet<String> saveEmail = new HashSet<>();
        for(int i = 0; i<forms.size()-1;i++) {
            String nick = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            for (int k = 0; k < nick.length() - 1; k++) {
                String word = nick.substring(k, k + 2);

                for (int j = i + 1; j < forms.size(); j++) {
                    String email2 = forms.get(j).get(0);
                    String nick2 = forms.get(j).get(1);

                    if (nick2.contains(word)) {
                        saveEmail.add(email);
                        saveEmail.add(email2);
                    }
                }
            }
        }
        System.out.println(saveEmail);
        List<String> answer = new ArrayList<>(saveEmail);
        Collections.sort(answer);
        return answer;
    }
}
