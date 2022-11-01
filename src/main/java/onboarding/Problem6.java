package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        HashSet<String> commonStringList = new HashSet<String>();

        // 두 문자열씩 비교해가며 공통 문자열을 모두 찾는다.
        commonStringList = findAllCommonStrings(forms);

        // 공통 문자열이 존재한다면
        if (!commonStringList.isEmpty()) {
            // 공통 문자열이 포함된 모든 이메일 찾기
            answer = findAllCommonEmails(forms, commonStringList);
        }

        // 이메일 오름차순 정렬하기
        Collections.sort(answer);

        return answer;
    }

    static HashSet<String> findAllCommonStrings (List<List<String>> forms) {
        HashSet<String> commonStringList = new HashSet<String>();
        List<String> nickNameList = new ArrayList<String>();;

        // 닉네임 추출
        for (int i = 0; i < forms.size(); i++) {
            nickNameList.add(forms.get(i).get(1));
        }

        // 모든 조합
        for (int i = 0; i < nickNameList.size() - 1; i++) {
            for (int j = i + 1; j < nickNameList.size(); j++) {
                // 두 문자열의 공통 문자열 찾기
                String commonString = findCommonString(nickNameList.get(i), nickNameList.get(j));
                // 공통 문자열이 있다면
                if (commonString.length() > 0)
                    commonStringList.add(commonString);

            }
        }

        return commonStringList;
    }

    static String findCommonString(String str1, String str2) {
        String commonString = "";

        // 마지막 문자는 다음에 연속으로 올 문자가 없으므로 비교하지 않음
        for (int i = 0; i < str1.length() - 1; i++) {
            for (int j = 0; j < str2.length() - 1; j++) {

                // 연속된 문자열인 경우
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (str1.charAt(i + 1) == str2.charAt(j + 1)) {
                        commonString = String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i + 1));
                        break;
                    }
                }

            }
        }

        return commonString;
    }

    static List<String> findAllCommonEmails (List<List<String>> forms, HashSet<String> commonStringList) {
        List<String> emailList = new ArrayList<String>();

        for (int i = 0; i < forms.size(); i++) {
            Iterator iter = commonStringList.iterator();
            while(iter.hasNext()) {
                if(forms.get(i).get(1).contains(iter.next()+"")) {
                    emailList.add(forms.get(i).get(0));
                }
            }
        }

        return emailList;
    }

}
