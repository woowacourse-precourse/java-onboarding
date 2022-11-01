package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<String> commonStringList = new ArrayList<String>();
        boolean isCommonStringExist = true;

        // 두 문자열씩 비교해가며 공통 문자열을 모두 찾는다.
        commonStringList = findAllCommonStrings(forms);
        // 공통 문자열이 존재한다면
        if (!commonStringList.isEmpty()) {
            // 공통 문자열이 포함된 모든 이메일 찾기
            answer = findAllCommonEmails(forms, commonStringList);

        }

        return answer;
    }

    static List<String> findAllCommonStrings (List<List<String>> forms) {
        List<String> commonStringList = new ArrayList<String>();
        return commonStringList;
    }

    static List<String> findAllCommonEmails (List<List<String>> forms, List<String> commonStringList) {
        List<String> emailList = new ArrayList<String>();
        return emailList;
    }

}
