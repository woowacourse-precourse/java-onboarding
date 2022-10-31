package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i = 0 ; i < forms.size() - 1 ; i++) {
            for(int j = i + 1 ; j < forms.size() ; j++) {
                if(isDuplicated(forms.get(i).get(1).toCharArray(), forms.get(j).get(1).toCharArray())) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        answer = new ArrayList<>(new HashSet<>(answer));
        return answer;
    }

    public static boolean isDuplicated(char[] name1, char[] name2) {
        for(int k = 0 ; k < name1.length - 1 ; k += 1) {
            for(int l = 0 ; l < name2.length - 1 ; l += 1) {
                if(name1[k] == name2[l] && name1[k + 1] == name2[l + 1])  return true;
            }
        }
        return false;
    }
}
