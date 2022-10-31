package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> saveEmail = new HashSet<>();
        int formsSize = forms.size();

        for(int i = 0; i < formsSize-1; i++){
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            int nameLen = name.length();

            for(int j = 0; j < nameLen-1; j++){
                String word = name.substring(j, j+2);

                for (int k = i+1; k < formsSize; k++) {
                    String email2 = forms.get(k).get(0);
                    String name2 = forms.get(k).get(1);

                    if(name2.contains(word)){
                        saveEmail.add(email);
                        saveEmail.add(email2);
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(saveEmail);

        return answer;
    }
}
