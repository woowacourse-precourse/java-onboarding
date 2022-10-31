package onboarding;
/*
    기능 목록
    1. 중복되는 닉네임을 추려내는 기능 -> dupCheck
    2. 몇글자가 중복되는지 체크하는 기능 -> dupCnt
 */
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.size(); j++) {
                if (i != j && dupCheck(forms.get(i).get(1), forms.get(j).get(1))) {
                    answer.add(forms.get(i).get(0));
                    break ;
                }
            }
        }
       Collections.sort(answer);
        return answer;
    }

    private static boolean dupCheck(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    if (dupCnt(str1.substring(i), str2.substring(j)) > 1)
                        return true;
            }
        }
        return false;
    }

    private static int dupCnt(String str1, String str2) {
        int cnt;

        for (cnt = 0; cnt < Math.min(str1.length(), str2.length())
                && str1.charAt(cnt) == str2.charAt(cnt); cnt++);
        return cnt;
    }
}
