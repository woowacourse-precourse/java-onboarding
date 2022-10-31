package onboarding;

import java.util.*;

public class Problem6 {

    // 중복인 닉네임을 가진 유저의 이메일 집합 set
    public static Set<String> set = new HashSet<>();

    // 리스트에서 닉네임을 한개씩 뽑아 다른 닉네임과 비교
    public static void getDuplicateNickNameList(List<List<String>> forms){
        for(int i=0; i<forms.size(); i++) {
            String nickName = forms.get(i).get(1);

            // 닉네임을 두글자씩 쪼개서 다른 닉네임들과 비교후 set에 추가
            for(int j=0; j<nickName.length()-1; j++) {
                String subString = nickName.substring(j, j+2);

                // 중복 체크
                if(isContain(forms, i, subString)) set.add(forms.get(i).get(0));
            }
        }
    }

    // 2글자씩 쪼갠 문자열이 다른 닉네임에 속해 있는지 중복 체크
    public static boolean isContain(List<List<String>> forms, int idx, String subString) {
        for(int i =0; i< forms.size(); i++) {
            if(i == idx) continue;

            // 중복시 true 리턴
            if(forms.get(i).get(1).contains(subString)) return true;
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        getDuplicateNickNameList(forms);

        List<String> answer = new ArrayList<>(set);

        // 이메일 오름차 정렬
        Collections.sort(answer);

        return answer;
    }
}
