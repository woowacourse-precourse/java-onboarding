package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        ArrayList<String> nicknames = new ArrayList<String>();
        HashSet<String> duplicate = new HashSet();

        for (int i = 0; i < forms.size(); i++) {
            String str = forms.get(i).get(1);

            for (int j = 2; j <= str.length(); j++) {
                if (nicknames.contains(str.substring(j - 2, j))) {
                    duplicate.add(str.substring(j - 2, j));
                }

                nicknames.add(str.substring(j - 2, j));
            }
        }

        Iterator<String> iter = duplicate.iterator();

        while (iter.hasNext()) {
            String word = iter.next();

            for (int i = 0; i < forms.size(); i++) {
                if(forms.get(i).get(1).contains(word))
                    answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);

        return answer;
    }
}