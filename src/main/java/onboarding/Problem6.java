package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int[] count = new int[forms.size()];
        for(int i = 0; i < forms.size(); i++) {
            String name1 = forms.get(i).get(1);
            for(int j = i+1; j < forms.size(); j++) {
                String name2 = forms.get(j).get(1);
                if(checkDuplicate(name1, name2)) {
                    count[i]++;
                    count[j]++;
                }
            }
        }

        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static boolean checkDuplicate(String str1, String str2) {
        for(int i = 0; i < str1.length() - 1; i++) {
            for(int j = 0; j < str2.length() - 1; j++) {
                if(str1.substring(i, i + 2).equals(str2.substring(j, j + 2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
