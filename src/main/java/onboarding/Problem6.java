/*
 * 클래스명: Problem2
 *
 * 시작 날짜: 2022-10-30
 */

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        IsOverlap isOverlap = new IsOverlap();

        int totalCrews = forms.size();
        for (int i=0; i<totalCrews-1; i++) {
            for (int j=i+1; j<totalCrews; j++) {
                String crew1 = forms.get(i).get(1);
                String crew2 = forms.get(j).get(1);
                if (isOverlap.isOverlap(crew1, crew2)) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        return answer;
    }
}

class IsOverlap {
    public boolean isOverlap (String crew1, String crew2) {

        int crew1Length = crew1.length();
        int crew2Length = crew2.length();
        int[][] LCS = new int[crew1Length+1][crew2Length+1];
        char[] crew1Array = crew1.toCharArray();
        char[] crew2Array = crew2.toCharArray();

        for (int i=1; i<=crew1Length; i++) {
            for (int j=1; j<=crew2Length; j++) {
                if(crew1Array[i-1] == crew2Array[j-1] && LCS[i-1][j-1] >= 1) {// 두개 이상 중복이라면
                    return true;
                }
                if(crew1Array[i-1] == crew2Array[j-1]) {
                    LCS[i][j] = 1;
                }
            }
        }

        return false;
    }
}

class IsCorrect {
    public boolean isCorrect (String email) {
        int emailLength = email.length();
        if (emailLength < 11 || 20 <= emailLength) {
            return false;
        }

        return true;
    }
}