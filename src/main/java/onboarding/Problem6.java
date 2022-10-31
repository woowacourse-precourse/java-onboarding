package onboarding;

import java.util.*;


public class Problem6 {
    // 두 닉네임을 입력받아서 중복이 있는지 확인하는 함수
    public static boolean checkDuplication(String firstNickname, String secondNickname) {
        for(int i = 0; i < firstNickname.length() - 1; i++) {
            if (secondNickname.contains(firstNickname.substring(i, i + 2))) {
                return true;                           // 입력된 두 개의 닉네임에서 중복이 발생
            }
        }
        return false;                                  // 입력된 두 개의 닉네임은 중복이 없음
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> emailSet = new HashSet<>();        // 입력되는 이메일의 중복을 제거한다

        for(int i = 0; i < forms.size() - 1; i++) {
            for(int j = i + 1; j < forms.size(); j++) {
                if(checkDuplication(forms.get(i).get(1), forms.get(j).get(1))) {
                    emailSet.add(forms.get(i).get(0));
                    emailSet.add(forms.get(j).get(0));
                }
            }
        }

        answer = new ArrayList<String>(emailSet);        // 중복이 제거된 Set -> List
        Collections.sort(answer);                        // 리스트 오름차순 정렬

        return answer;
    }
}
