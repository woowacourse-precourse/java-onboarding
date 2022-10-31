package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/*
Brute-Force 방식을 사용했습니다.
첫번째 문자열을 for문을 통해 순회하면서 각 문자가 두번째 문자열의 어디에 있는지 전부 파악한 뒤, 그 문자 다음 문자에 어떤 문자가 오는지 확인 후,
첫번째 문자열에서 뽑은 문자의 다음 문자와 같은 것이 나왔다면, 그 두 문자열은 같은 글자가 연속적으로 포함된 것입니다.
*/

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        int form_size = forms.size();
        String x = "  b ";

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
                if(Y.contains(subStrs.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
