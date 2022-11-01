package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<String> formsEmail = new ArrayList<String>();
        List<String> formsName = new ArrayList<String>();
        List<String> answerOverlap = new ArrayList<String>();

        for (int i = 0; i < forms.size(); i++) {
            String temp = new String();
            temp = forms.get(i).get(0);
            formsEmail.add(temp);
            temp = forms.get(i).get(1);
            formsName.add(temp);
        }

        for (int i = 0; i < formsName.size()-1; i++) {
            for (int j = i + 1; j < formsName.size(); j++) {
                String name1 = formsName.get(i);
                String name2 = formsName.get(j);
                for (int k = 0; k < name1.length(); k++) {
                    for (int l = 0; l < name2.length(); l++) {
                        if (k == name1.length()-1 || l == name2.length()-1) break;
                        if (name1.charAt(k) == name2.charAt(l) && name1.charAt(k+1) == name2.charAt(l+1)) {
                            answerOverlap.add(formsEmail.get(i));
                            answerOverlap.add(formsEmail.get(j));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < answerOverlap.size(); i++) {
            String compare = answerOverlap.get(i);
            if (!answer.contains(compare)) {
                answer.add(compare);
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
