package onboarding;

import java.util.*;

/**
 * 기능목록
 * 1. 중복되는 문자열이 있는 경우 해당 멤버와, 해시맵에 저장되는 크루를 answer 배열에 이매일 저장
 * 2. 각 멤버에 대해서 두글자씩 잘라 해시맵에 저장
 * 3. 이메일에 해당하는 부분의 문자열 오름차순 정렬하여 리턴
 */

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        HashMap<String,String> allSubNickname = new HashMap<>();
        HashSet<String> duplicateCrewEmail= new HashSet<>();

        for (List<String> form : forms) {
            String crewEmail = form.get(0);
            String crewNickname = form.get(1);

            for (int j = 0; j < crewNickname.length() - 1; j++) {
                String subNickname = crewNickname.substring(j, j + 2);

                if (allSubNickname.containsKey(subNickname)) {
                    //현재 닉네임과 그전에 저장된 닉네임을 duplicateCrewEmail 에 저장함
                    saveDuplicateCrewEmail(crewEmail, duplicateCrewEmail);
                    saveDuplicateCrewEmail(allSubNickname.get(subNickname), duplicateCrewEmail);
                }
                //모든 부분 닉네임 저장
                saveSubNickname(subNickname, crewEmail, allSubNickname);
            }

        }
        answer = new ArrayList<>(duplicateCrewEmail);
        Collections.sort(answer);

        return answer;
    }

    private static void saveSubNickname(String subName, String email, HashMap<String, String> allSubNickname) {
        allSubNickname.put(subName,email);
    }

    private static void saveDuplicateCrewEmail(String email, HashSet<String> duplicateCrewEmail) {
        duplicateCrewEmail.add(email);
    }

}
