package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < forms.size()-1; i++) {
            List<String> A = new ArrayList<>();
            String firstName = forms.get(i).get(1);

            if (i >= forms.size()-1) {
                continue;
            }

            for (int j=0; j<firstName.length();j++) {
                if (j > firstName.length()-2) {
                    continue;
                }
                String splitName = firstName.substring(j, j + 2);
                A.add(splitName);
            }

            //A가 만들어졌어. 이제 B를 만들어야해.
            for (int k = i+1; k < forms.size(); k++) {
                String secondName = forms.get(k).get(1);
                List<String> B = new ArrayList<>();

                for (int j=0; j<secondName.length();j++) {
                    if (j > secondName.length()-2) {
                        continue;
                    }
                    String splitName = secondName.substring(j, j + 2);
                    B.add(splitName);
                }
                B.retainAll(A);
                if (B.size()>=1) {
                    result.add(forms.get(i).get(0));
                    result.add(forms.get(k).get(0));
                }
            }
        }
        HashSet<String> resultHash = new HashSet<String>(result);
        List <String> answer = new ArrayList<>(resultHash);
        return answer;
    }
}
