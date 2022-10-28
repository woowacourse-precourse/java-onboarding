package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    // 두 닉네임을 입력받아서 중복이 있는지 확인하는 함수
    public static boolean checkDuplication(String firstNickname, String secondNickname) {
        for(int i = 0; i < firstNickname.length() - 1; i++) {
            for(int j = i + 2; j < firstNickname.length() + 1; j++) {
                if(secondNickname.contains(firstNickname.substring(i, j))) {
                    return true;    // 입력된 두 개의 닉네임에서 중복이 발생
                }
            }
        }

        return false;    // 입력된 두 개의 닉네임은 중복이 없음
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> emailSet = new TreeSet<>();    // 오름차순 정렬과 중복을 제거할 수 있습니다

        for(int i = 0; i < forms.size(); i++) {
            for(int j = 0; j < forms.size(); j++) {
                if(i == j) {
                    continue;
                }

                if(checkDuplication(forms.get(i).get(1), forms.get(j).get(1))) {
                    emailSet.add(forms.get(i).get(0));
                    emailSet.add(forms.get(j).get(0));
                }
            }
        }

        answer = new ArrayList<String>(emailSet); // 오름차순 정렬과 중복이 제거된 Set을 List로 변환

        return answer;
    }
}
