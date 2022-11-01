package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new TreeSet<String>();
        Iterator<String> iterator;
        String curString;
        String curTarget;
        ArrayList<String> answer = new ArrayList<String>();
        for (int i = 0; i < forms.size(); i++) { //form만큼 루프
            curString = forms.get(i).get(1);
            for (int j = 0; j < curString.length() - 1; j++) //현재 문자열길이만큼 루프
                for (int k = i + 1; k < forms.size(); k++) {
                    curTarget = forms.get(k).get(1);
                    for (int l = 0; l < curTarget.length() - 1; l++) {
                        if (curString.substring(j, j + 2).equals(curTarget.substring(l, l + 2))) {
                            answer.add(forms.get(i).get(0));
                            answer.add(forms.get(k).get(0));
                        }
                    }
                }
        }
        for (int i = 0; i < answer.size(); i++) {
            set.add(answer.get(i));
        }

        answer = new ArrayList<String>(set);
        return answer;
    }
}
