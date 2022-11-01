// 문제해결 X

package onboarding;

import java.util.List;
import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<Integer> check = new ArrayList<Integer>();
        List<String> answer = new ArrayList<String>();
        List<String> w = new ArrayList<String>();
        for (int i = 0; i < forms.size(); i++) {
            String k = forms.get(i).get(1);
            for (int j = 0; j < k.length() - 1; j++) {
                String tmp1 = k.substring(j, j + 2);
                for (int a = 0; a < forms.size(); a++) {
                    if (a == i)
                        continue;
                    String k2 = forms.get(a).get(1);
                    for (int b = 0; b < k2.length() - 1; b++) {
                        String tmp2 = k2.substring(b, b + 2);
                        if (tmp1.equals(tmp2)) {
                            w.add(tmp1);
                            w.add(tmp2);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < w.size(); i++) {
            String k = w.get(i);
            for (int j = 0; j < w.size(); j++) {
                if (i == j)
                    continue;
                else if (k.equals(w.get(j)) && !k.equals("abc")) {
                    check.add(j);
                    w.set(j, "abc");
                }
            }
        }

        for (var c : check) {
            w.remove(c);

        }

        answer.add()
        return answer;
    }
}
