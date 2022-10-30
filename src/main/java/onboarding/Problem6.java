/*
 * 클래스명: Problem2
 *
 * 시작 날짜: 2022-10-30
 */

package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}

class IsOverlap {
    public boolean isOverlap (String crew1, String crew2) {

        int crew1Length = crew1.length();
        int crew2Length = crew2.length();
        int[][] LCS = new int[crew1Length+1][crew2Length];
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