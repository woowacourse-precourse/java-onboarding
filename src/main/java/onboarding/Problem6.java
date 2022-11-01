/*
 * 우테코 1주차 프리코스 미션 - 문제 6
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM6.md]
 *
 */
package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Comparator;

/**
 * isCompare : forms에 속한 크루들의 닉네임과 이메일을 두 개씩 짝지어 비교하기 위한 메서드
 * isContinuous : 두 개씩 짝지은 크루원들의 닉네임 중 같은 글자가 연속적으로 포함되는 지 확인하는 메서드
 **/

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer;
        answer = isCompare(forms);

        /* set을 이용해 중복을 제거 */
        HashSet<String> hashSet = new HashSet<>();
        for(String mail : answer){
            hashSet.add(mail);
        }

        /* naturalOrder()를 이용해 오름차순 정렬 */
        answer = new ArrayList<>(hashSet);
        answer.sort(Comparator.naturalOrder());

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
                String iMail = forms.get(i).get(0);
                String jMail = forms.get(j).get(0);
                String aName = forms.get(i).get(1);
                String bName = forms.get(j).get(1);

                if (isContinuous(aName, bName)) {
                    answer.addAll(List.of(iMail, jMail));
                }
            }
        }
        return answer;
    }

    static boolean isContinuous(String nameA, String nameB) {
        int lenA = nameA.length();
        int lenB = nameB.length();

        ArrayList<String> listA = new ArrayList<>();
        ArrayList<String> listB = new ArrayList<>();

        for (int i = 0; i < lenA - 1; i++) {
            listA.add(nameA.substring(i, i + 2));
        }
        for (int i = 0; i < lenB-1; i++) {
            listB.add(nameB.substring(i, i + 2));
        }
        for (int i = 0; i < listA.size(); i++) {
            if (listB.contains(listA.get(i))) {
                return true;
            }
        }
        return false;
    }
}