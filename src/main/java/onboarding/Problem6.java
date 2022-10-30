package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        int form_size = forms.size();
        String x = "  b ";
        System.out.println(x.indexOf('z'));

        for (int i = 0; i < form_size - 1; i++) {
            for (int j = i + 1; j < form_size; j++) {
                String first_kor = forms.get(i).get(1);
                String second_kor = forms.get(j).get(1);
                int first_len = first_kor.length();
                int second_len = second_kor.length();
                boolean dummy = lcs(first_kor, second_kor, first_len, second_len);
                if (dummy) {
                    String first_email = forms.get(i).get(0);
                    String second_email = forms.get(j).get(0);

                    if (!answer.contains(first_email))
                        answer.add(first_email);

                    if (!answer.contains(second_email))
                        answer.add(second_email);

                }
            }

        }
        Collections.sort(answer);
        return answer;
    }

    static boolean lcs(String X, String Y, int m, int n) {
        char[] xArr = X.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<Character>();
        for (int i = 0; i < m; i++)
            set.add(xArr[i]);
        Object[] sSetArr = set.toArray();
        int setLen = set.size();

        char[] yArr = Y.toCharArray();
        for (int i = 0; i < setLen; i++) {
            char target_char = (char) sSetArr[i];
            int idx = X.indexOf(target_char);
            List<String> subStrs = new ArrayList<String>();
            while (idx >= 0) {
                try {
                    String subStr = xArr[idx] +""+ xArr[idx + 1];
                    idx = X.indexOf(target_char, idx + 1);
                    subStrs.add(subStr);
                } catch (Exception e) {
                    break;
                }
            }
            int sub_cnt = subStrs.size();
            for (int j = 0; j < sub_cnt; j++) {
                System.out.println(subStrs.get(j));
                if(Y.contains(subStrs.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
