package onboarding;

import java.util.*;

/**
 * 기능목록
 * 1. 중복되는 문자열이 있는 경우 해당 멤버와, 해쉬맵에 저장되는 크루를 answer 배열에 이매일 저장
 * 2. 각 멤버에 대해서 두글자씩 잘라 해쉬맵에 저장
 * 3. 이메일에 해당하는 부분의 문자열 오름차순 정렬하여 리턴
 */

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String,String> allSubNickname = new HashMap<>();
        HashSet<String> duplicateCrewEmail= new HashSet<>();

        for(int i=0;i<forms.size();i++){
            String nowCrewEmail = forms.get(i).get(0);
            String nowCrewNickname = forms.get(i).get(1);

            for(int j=0;j<nowCrewNickname.length()-1;j++){
                String subNickname = nowCrewNickname.substring(j,j+1);
                if(allSubNickname.containsKey(subNickname)){
                    //현재 닉네임과 그전에 저장된 닉네임을 duplicateCrewEmail 에 저장함
                    saveDuplicateSubNickname(nowCrewEmail,duplicateCrewEmail);
                    saveDuplicateSubNickname(allSubNickname.get(subNickname), duplicateCrewEmail);
                }
            }

        }
        return answer;
    }

    private static void saveDuplicateSubNickname(String email, HashSet<String> duplicateCrewEmail) {
        if(duplicateCrewEmail.contains(email)) return;
        else {
            duplicateCrewEmail.add(email);
        }
    }


}
