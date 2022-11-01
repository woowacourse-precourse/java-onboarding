package onboarding;

import java.util.*;
/*
기능 구현 사항
1. 같은 글자가 연속적으로 포함되는 닉네임은 불가
2. 두 글자 이상의 문자가 연속인 경우 중복
3. 이메일은 11자 이상 20자 미만이고, 이메일 형식에 부합하며, email.com 도메인으로만 제한
4. 닉네임은 한글만 가능하고 1자 이상 20자 미만
5. 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬. 중복 제거
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, ArrayList<String>> duplicateNickname = checkDuplicateNickname(forms);
        Set<String> duplicateCrewEmail = findDuplicatedCrew(duplicateNickname);
        List<String> sortedCrewEmail = new ArrayList<>(duplicateCrewEmail);
        Collections.sort(sortedCrewEmail);
        return sortedCrewEmail;
    }

    private static Set<String> findDuplicatedCrew(Map<String, ArrayList<String>> duplicateNickname) {
        Set<String> duplicateCrewEmail = new HashSet<>();
        duplicateNickname.forEach((nickname, nicknameList) -> {
            if(nicknameList.size() > 1) {
                duplicateCrewEmail.addAll(nicknameList);
            }
        });
        return duplicateCrewEmail;
    }

    // map으로 변경하고 값이 존재하면 email 넣고 없으면 이름 조합 넣기
    private static Map<String, ArrayList<String>> checkDuplicateNickname(List<List<String>> forms) {
        Map<String, ArrayList<String>> duplicatedMap = new HashMap<>();
        for (List<String> crew : forms) {
            String crewEmail = crew.get(0);
            String crewNickname = crew.get(1);

            for (int j = 0; j < crewNickname.length() - 1; j++) {
                String splitNickname = crewNickname.substring(j, j + 2);
                if (!duplicatedMap.containsKey(splitNickname)) {
                    duplicatedMap.put(splitNickname, new ArrayList<>());
                }
                duplicatedMap.get(splitNickname).add(crewEmail);
            }
        }
        return duplicatedMap;
    }


    private static boolean isValidEmail(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            return false;
        }
        if (!email.matches("^[a-zA-Z0-9]+@email.com$")) {
            return false;
        }
        return true;
    }

    private static boolean isValidNickname(String nickname) {
        if (nickname.isBlank() || nickname.length() >= 20) {
            return false;
        }
        if (!nickname.matches("^[가-힣]*$")) {
            return false;
        }
        return true;
    }
}
