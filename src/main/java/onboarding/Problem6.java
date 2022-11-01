package onboarding;

import java.util.*;

/*
    요구사항 분석
    form 로 "이메일", "닉네임" 이 들어오며 닉네임 중 중복되는 글자가 두개 이상 연속적으로 포함될 경우 이메일을 리턴한다

    제한사항
    두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
    result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.

    이메일이 중복될 수 있다 이를 확인할것 만약 중복시 삭제

    프로그램 구현
    첫번째 닉네임에서 부터 두 글자씩 잡고, 모든 닉네임 중 중복되는 값이 있는지 확인한다
    ex) 제이엠은싫어 가나다 라마바
    첫번째 중복확인 제이 -> 가나 , 나다 , 라마, 마바
    두번쨰 중복확인 이엠 -> 가나, 나다 ,라마 ,마바

    Step1. 모든 form 에 대해서 중복 문자 비교하는 반복문 만들기 (이중반복문으로 구현)
    Step2. 두가지 폼에 대해 중복값이 있는지 확인하는 메서드 만들기
           중복값이 있다면 -1 리턴 없다면 1리턴
           -1 리턴시 두 값 모두 이메일에 넣기
    Step3. 결과값 오름차순 정렬하기 (정렬시 중복된 이메일 제거 -> hashSet으로 해결)

 */

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> answerSet = new TreeSet<>();
        String nickname;
        boolean result;
        boolean nicknameValid;

        for (int i = 0; i < forms.size(); i++) {
            nickname = forms.get(i).get(1);
            nicknameValid = nicknameValidCheck(forms, answerSet, nickname, i);
            if (nicknameValid == false) {
                answerSet.add(forms.get(i).get(0));
            }
        }

        List<String> answer = new ArrayList<>(answerSet);
        return answer;
    }

    private static boolean nicknameValidCheck(List<List<String>> forms, TreeSet<String> answerSet, String nickname, int i) {

        boolean duplicateResult;
        boolean nicknameValid = true;

        for (int j = i + 1; j < forms.size(); j++) {
            duplicateResult = duplicateCheck(nickname, forms.get(j).get(1));
            if (duplicateResult == true) {
                nicknameValid = false;
                answerSet.add(forms.get(j).get(0));
            }
        }
        return nicknameValid;
    }

    private static boolean duplicateCheck(String nickname1, String nickname2) {

        StringBuilder compare1 = new StringBuilder(2);
        StringBuilder compare2 = new StringBuilder(2);

        for (int i = 0; i < nickname1.length() - 1; i++) {
            compare1.delete(0, 2);
            compare1.append(nickname1.charAt(i));
            compare1.append(nickname1.charAt(i + 1));
            for (int j = 0; j < nickname2.length() - 1; j++) {
                compare2.delete(0, 2);
                compare2.append(nickname2.charAt(j));
                compare2.append(nickname2.charAt(j + 1));
                if (compare1.toString().equals(compare2.toString())) {
                    return true;
                }
            }
        }

        return false;
    }

}
