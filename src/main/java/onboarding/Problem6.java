package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        boolean[] flags = new boolean[forms.size()];
        String comparingWord = "";
        String comparedWord = "";
        for (int i = 0; i < forms.size(); i++) {
            if (!flags[i]) {
                comparingWord = forms.get(i).get(1);
            } else {
                continue;
            }
            List<String> sub = makeSubWords(comparingWord);
            for (int j = 0; j < forms.size(); j++) {
                if (i != j && !flags[j]) {
                    comparedWord = forms.get(j).get(1);
                } else {
                    continue;
                }
                for (int k = 0; k < sub.size(); k++) {
                    if (comparedWord.contains(sub.get(k))) {
                        flags[j] = true;
                        if (i==0 && !flags[0]){
                            answer.add(forms.get(0).get(0));
                            flags[0] =true;
                        }
                        answer.add(forms.get(j).get(0));
                        break;
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static List<String> makeSubWords(String word) {
        List<String> result = new ArrayList<>();
        int count = 0;
        while (count + 1 != word.length()) {
            result.add(word.substring(count, count + 2));
            count++;
        }
        return result;
    }
}
