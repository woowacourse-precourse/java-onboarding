/*
 * 우테코 1주차 프리코스 미션 - 문제 6
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM6.md]
 *
 */
package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * isCompare : forms에 속한 크루들의 닉네임과 이메일을 두 개씩 짝지어 비교하기 위한 메서드
 **/

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer;
        answer = isCompare(forms);
        
        return answer;
    }

    static List<String> isCompare(List<List<String>> forms){
        List<String> answer = new ArrayList<>();

        /* 중복해서 비교하는 부분은 굳이 for문 대상에 넣지 않아도 되므로, i의 범위를 줄여준다. */
        for (int i = 0; i < forms.size() - 2; i++){
            for (int j = i + 1; j < forms.size() - 1; j++) {
                /* 본인끼리 비교하는 상황은 예외 처리 */
                if(i == j) {
                    continue;
                }
                String aMail = forms.get(i).get(0);
                String bMail = forms.get(j).get(0);
                String aName = forms.get(i).get(1);
                String bName = forms.get(j).get(1);
            }
        }

        return answer;
    }
}