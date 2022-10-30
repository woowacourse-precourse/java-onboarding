package onboarding;

import java.util.*;

/**
 * Problem 6
 *
 * 기능 요구 사항
 * 1. 크루들의 닉네임 중 같은 굴자가 연속적 포함되면 사용 제한
 * 2. 따라서 같은 글자가 연속이면 신청한 크루들에게 알려준다.
 * 3. 위 같은 글자를 연속적으로 포함한 크루들의 이메일 목록 return
 *
 * 제한 사항
 * 1. 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되면 중복
 * 2. 크루는 1~ 10,000명 이하
 * 3. 이메일은 이메일 형식에 부합, 길이는 11~19
 * 4. 신청 가능한 이메일은 오직 email.com
 * 5. 한글만 가능, 전체 길이 1~19
 * 6. 문자열을 오름차순, 중복은 제거
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();
        answer = findDup(forms);
        Collections.sort(answer);
        return answer;
    }

    /**
     * 입력 받은 form 리스트에서 중복된 값 찾는 함수
     * @param forms
     * @return 증복된 신청자의 이메일 리스트
     */
    public static List<String> findDup(List<List<String>> forms) {
        Set<String> emailList = new HashSet<String>();

        for (int i=0; i<forms.size(); i++) {
            for (int j=i+1; j<forms.size(); j++) {
                if (isDuplicate(forms.get(i).get(1), forms.get(j).get(1))) {
                    emailList.add(forms.get(i).get(0));
                    emailList.add(forms.get(j).get(0));
                }
            }
        }
        return new ArrayList<String>(emailList);
    }

    /**
     * 두 닉네임에서 연속으로 중복된 값이 있는지 확인하는 함수
     * @param origin
     * @param comp
     * @return 중복이면 True, 아니면 False
     */
    public static boolean isDuplicate(String origin, String comp) {
        int[][] cnt = new int[origin.length()][comp.length()];

        for (int i=0; i<origin.length(); i++) {
            if (origin.charAt(i) == comp.charAt(0)) {
                cnt[i][0] = 1;
            }
        }
        for (int i=0; i<comp.length(); i++) {
            if (comp.charAt(i) == origin.charAt(0)) {
                cnt[0][i] = 1;
            }
        }
        for (int i=1; i<origin.length(); i++) {
            for (int j=1; j<comp.length(); j++) {
                if (origin.charAt(i) == comp.charAt(j)) {
                    cnt[i][j] = cnt[i-1][j-1] + 1;
                } else {
                    cnt[i][j] = 0;
                }
                if (cnt[i][j] >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
