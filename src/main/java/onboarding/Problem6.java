package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Collections;

public class Problem6 {
    private static boolean check(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    if (count(str1.substring(i), str2.substring(j)) > 1)
                        return true;
            }
        }
        return false;
    }
    private static int count(String str1, String str2) {
        int cnt;

        cnt = 0;
        while (cnt < Math.min(str1.length(), str2.length()) && str1.charAt(cnt) == str2.charAt(cnt))
            cnt++;
        return cnt;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.size(); j++) {
                if (i != j && check(forms.get(i).get(1), forms.get(j).get(1))) {
                    answer.add(forms.get(i).get(0));
                    break ;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
