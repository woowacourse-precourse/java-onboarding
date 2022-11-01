package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static boolean isDup (String n1, String n2) {
        String target;
        for(int i = 0; i < n1.length()-1; i++) {
            target = n1.substring(i, i+2);
            for(int j = 0; j < n2.length()-1; j++) {
                if(target.equals(n2.substring(j, j+2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        boolean[] dupcheck = new boolean[forms.size()];
        for(int i = 0; i < forms.size(); i++) {
            for(int j = 0; j < forms.size(); j++) {
                if(i != j && !dupcheck[j] && isDup(forms.get(i).get(1), forms.get(j).get(1))) {
                    dupcheck[i] = true;
                    dupcheck[j] = true;
                }
            }
        }
        for(int i = 0; i < forms.size(); i++) {
            if(dupcheck[i]) {
                answer.add(forms.get(i).get(0));
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
