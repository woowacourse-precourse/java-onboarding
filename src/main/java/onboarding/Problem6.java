package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        List<List<String>> l2 = new ArrayList<>();
        for (int i=0; i<forms.size(); i++) {
            String name = forms.get(i).get(1);
            List<String> l = new ArrayList<String>();
            for (int j=0; j<name.length()-1; j++) {
                // 두 글자씩 끊어서 list에 담는다.
                l.add(name.substring(j, j+2));
            }
            l2.add(l);
        }

        for (int i=0; i<l2.size(); i++) {
            List<String> l = l2.get(i);
            for (int j=0; j<l2.size(); j++) {
                if (i==j) continue;
                Boolean found = false;
                List<String> ll = l2.get(j);
                for (int k=0; k<l.size(); k++) {
                    if (ll.contains(l.get(k))) {
                        answer.add(forms.get(i).get(0));
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }
        Collections.sort(answer);

        return answer;
    }

}