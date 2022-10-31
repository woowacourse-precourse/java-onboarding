package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        final Comparator<String> COMPARATOR = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] str1 = o1.split("@");
                String[] str2 = o2.split("@");
                return str1[0].compareTo(str2[0]);
            }
        };

        boolean[] count = new boolean[forms.size()];
        for (int i = 0; i < forms.size() - 1; i++) {
            String wooaCrew = forms.get(i).get(1);

            for (int j = 0; j < wooaCrew.length() - 2; j++) {
                String str = wooaCrew.substring(j, j + 2);

                for (int k = i; k < forms.size(); k++) {
                    if (forms.get(k).get(1).contains(str))
                        count[k] = true;
                }

            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i]) {
                answer.add(forms.get(i).get(0));
            }
        }
        answer.sort(COMPARATOR);


        return answer;
    }

}
