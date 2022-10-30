package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> answer = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            for (int j = 0; j < nickName.length()-1; j++) {
                String twoGram = nickName.substring(j, j+2);
                if (map.get(twoGram) == null) {
                    map.put(twoGram, i);
                }
                else {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(map.get(twoGram)).get(0));
                }
            }
        }
        ArrayList<String> finalAnswer = new ArrayList<>(answer);
        Collections.sort(finalAnswer);

        return finalAnswer;
    }
}
