package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 입력 데이터 검증 메소드 호출 후 반환값으로 데이터 상태 변경
        boolean isDataValid = validData(forms);

        if (!isDataValid) {
            answer.add("데이터가 적합하지 않습니다.");
        } else {
            answer = findDuplicatedNickCrew(forms);
        }

        return answer;
    }

    // 입력 데이터 검증 메소드
    private static boolean validData(List<List<String>> forms) {
        // 데이터가 올바른지 나타내는 상태
        boolean isDataValid = true;

        // 이메일과 닉네임의 정규 표현식
        String emailPattern = "^[_a-zA-Z0-9-\\\\.]+@email.com$";
        String nicknamePattern = "^[가-힣]+$";

        // 크루원의 숫자가 범위를 초과하는지 나타내는 상태
        boolean isDataLengthInRange = forms.size() <= 10000;

        for (List<String> crew: forms) {
            String email = crew.get(0);
            String nickname = crew.get(1);

            // 이메일이 형식을 지켰는지, 닉네임이 형식을 지켰는지를 나타내는 상태들
            boolean isEmailSuitable = Pattern.matches(emailPattern, email);
            boolean isNickSuitable = Pattern.matches(nicknamePattern, nickname);

            // 제한사항의 조건을 하나라도 만족시키지 못했을 경우 데이터 상태를 변경
            if (!isDataLengthInRange || !isEmailSuitable || !isNickSuitable || (email.length() < 11 || email.length() > 20) || nickname.length() > 19) {
                isDataValid = false;
                break;
            }
        }

        return isDataValid;
    }



    // 닉네임 중복 검사 메소드
    private static List<String> findDuplicatedNickCrew(List<List<String>> forms) {
        Map<String, HashSet<String>> nicknameHashMap = new HashMap<>();
        List<String> duplicatedCrewEmailList = new ArrayList<>();

        // 중복 닉네임을 식별하기 위해 크루원들의 닉네임을 파싱해서 HashSet에 저장 후 최종적으로 HashMap에 추가
        for (List<String> crew: forms) {
            String nickname = crew.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String splitChar = nickname.substring(i, i + 2);

                HashSet<String> targetCrewList;
                if (nicknameHashMap.containsKey(splitChar)) {
                    targetCrewList = nicknameHashMap.get(splitChar);
                } else {
                    targetCrewList = new HashSet<>();
                }
                targetCrewList.add(nickname);
                nicknameHashMap.put(splitChar, targetCrewList);
            }
        }

        // HashMap을 순회하며 중복된 닉네임을 가진 크루원들의 이메일을 duplicatedCrewEmailList에 추가
        for (List<String> crew: forms) {
            String nickname = crew.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String splitChar = nickname.substring(i, i + 2);
                HashSet<String> targetCrewList = nicknameHashMap.get(splitChar);
                if (targetCrewList.size() > 1) {
                    duplicatedCrewEmailList.add(crew.get(0));
                }
            }
        }

        // duplicatedCrewEmailList를 오름차순으로 정렬
        Collections.sort(duplicatedCrewEmailList);

        return duplicatedCrewEmailList;
    }
}
