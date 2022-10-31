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
        HashMap<String, String> allSubNickname = new HashMap<>();
        HashSet<String> duplicateCrewEmail = new HashSet<>();

        for (List<String> crew : forms) {
            String crewEmail = crew.get(0), crewNickname = crew.get(1);
            //중복되는 문자가 있는 크루인 경우 이메일 저장
            checkingDuplicateNickname(allSubNickname, duplicateCrewEmail, crewEmail, crewNickname);
        }

        return changeEmailhashToSortarray(duplicateCrewEmail);
    }

    //중복 닉네임이 있는 이메일을 추가한다.
    private static void checkingDuplicateNickname(HashMap<String, String> allSubNickname, HashSet<String> duplicateCrewEmail, String crewEmail, String crewNickname) {
        for (int i = 0; i < crewNickname.length() - 1; i++) {
            String subNickname = crewNickname.substring(i, i + 2);
            //같은 부분닉네임이 이미 존재한다면 크루의 이메일을 저장한다.
            if (allSubNickname.containsKey(subNickname)) {
                saveDuplicateCrewsEmail(allSubNickname, duplicateCrewEmail, crewEmail, subNickname);
            }
            //모든 부분닉네임저장
            saveSubNickname(subNickname, crewEmail, allSubNickname);
        }
    }

    private static void saveDuplicateCrewsEmail(HashMap<String, String> allSubNickname, HashSet<String> duplicateCrewEmail, String crewEmail, String subNickname) {
        saveDuplicateCrewEmail(crewEmail, duplicateCrewEmail);
        saveDuplicateCrewEmail(allSubNickname.get(subNickname), duplicateCrewEmail);
    }

    //이메일 정렬 및 리스트 변환
    private static List<String> changeEmailhashToSortarray(HashSet<String> duplicateCrewEmail) {
        List<String> answer = new ArrayList<>(duplicateCrewEmail);
        Collections.sort(answer);
        return answer;
    }

    //모든 부분닉네임 저장
    private static void saveSubNickname(String subName, String email, HashMap<String, String> allSubNickname) {
        allSubNickname.put(subName, email);
    }

    //이메일 저장
    private static void saveDuplicateCrewEmail(String email, HashSet<String> duplicateCrewEmail) {
        duplicateCrewEmail.add(email);
    }

}
