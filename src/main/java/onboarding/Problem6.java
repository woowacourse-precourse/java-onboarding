package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {

            String str = forms.get(i).get(1);
            
            for (int j = 1; j < str.length(); j++) {
                
                //비교할 두 글자 불러오기
                String subNickName = str.substring(j-1,j+1);
                
                //중복시 이메일 추가
                if(!validateNickName(subNickName, i, forms)) set.add(forms.get(i).get(0));
            }
        }

        List<String> answer = new ArrayList<>(set);

        //오름차순 정렬
        Collections.sort(answer);

        return answer;
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
