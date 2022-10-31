package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();
        for(int i=0; i<forms.size()-1; i++) {
            for(int j=i+1; j<forms.size(); j++) {
                if(checkDuplicateName(forms.get(i).get(1), forms.get(j).get(1))) {
                    emails.add(forms.get(i).get(0));
                    emails.add(forms.get(j).get(0));
                }
            }
        }
        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);
        return answer;
    }

    // 중복된 닉네임인지 검사
    private static boolean checkDuplicateName(String name1, String name2) {
        for(int i=0; i<name1.length(); i++) {
            int j = i;      // name1 인덱스
            int k = 0;      // name2 인덱스
            int cnt = 0;    // 중복 글자 수

            while(k < name2.length() && name1.charAt(j) != name2.charAt(k)) {
                k++;
            }
            if(k == name2.length()) {
                continue;
            }


            while(j < name1.length() && k < name2.length()
                    && name1.charAt(j) == name2.charAt(k)) {
                // 2번 중복되면 true 반환
                if(++cnt == 2) {
                    return true;
                }
                j++; k++;
            }

        }
        return false;
    }
}
