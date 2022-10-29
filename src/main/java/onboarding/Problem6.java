package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getEmailList(forms);
        return answer;
    }

    static List<String> getEmailList(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> twoCharList = new ArrayList<>();
        for (int i=0;i<forms.size();i++) {
            String name = forms.get(i).get(1);
            if (name.length() == 1 && !twoCharList.contains(name)) {
                twoCharList.add(name);
                answer.add(forms.get(i).get(0));
            } else {
                for (int j=1;j<name.length();j++) {
                    String twoChar = name.substring(j-1,j+1);

                    if (twoCharList.contains(twoChar)
                        && !answer.contains(forms.get(i).get(0))) {
                        answer.add(forms.get(i).get(0));
                        if (answer.size()==1) {
                            for (int k=0;k<i;k++) {
                                if (forms.get(k).get(1).contains(twoChar)) {
                                    answer.add(forms.get(k).get(0));
                                    break;
                                }
                            }
                        }
                    }
                    if (twoCharList.contains(twoChar)) continue;
                    twoCharList.add(twoChar);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
