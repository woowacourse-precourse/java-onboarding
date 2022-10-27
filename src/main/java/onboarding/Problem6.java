package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = duplicateNickNameList(forms);

        //오름차순 정렬
        Collections.sort(answer);

        return answer;
    }

    // 중복 리스트 생성 메소드
    private static List<String> duplicateNickNameList(List<List<String>> forms) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {

            String str = forms.get(i).get(1);

            for (int j = 0; j < str.length()-1; j++) {

                //비교할 두 글자 불러오기
                String subNickName = str.substring(j,j+2);

                //중복시 이메일 추가
                if(!validateNickName(subNickName, i, forms)) set.add(forms.get(i).get(0));
            }
        }

        return new ArrayList<>(set);
    }

    //중복 확인 메소드
    private static boolean validateNickName(String str, int n, List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {

            //현재 위치 발견시 컨티뉴
            if(i == n) continue;

            //중복확인
            if(forms.get(i).get(1).contains(str)) return false;
        }

        return true;
    }

}
