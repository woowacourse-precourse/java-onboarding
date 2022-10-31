package onboarding;

import java.util.*;

public class Problem6 {
    private static Map<String, Integer> nicknameMap = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        saveNicknameToMap(forms);
        List<String> duplicateNicknameList = getDuplicateNicknameList(forms);
        Collections.sort(duplicateNicknameList);

        return duplicateNicknameList;
    }

    private static void saveNicknameToMap(List<List<String>> forms) {
        for (List<String> crew : forms) {
            String nickname = crew.get(1);

            //TODO: 이 알고리즘에 대한 설명 적기
            for (int i = 0; i < nickname.length() - 1; i++) {
                String subStr = nickname.substring(i, i + 2);
                if (!nicknameMap.containsKey(subStr)) {
                    nicknameMap.put(subStr, 1);
                } else {
                    //TODO replace 로 바꿔야 할듯
                    nicknameMap.put(subStr, nicknameMap.get(subStr) + 1);
                }
            }
        }
    }

    private static List<String> getDuplicateNicknameList(List<List<String>> forms) {
        List<String> duplicateNicknameList = new ArrayList<>();

        for (List<String> crew : forms) {
            String nickname = crew.get(1);
            if (checkDuplicateNickname(nickname)){
                String email = crew.get(0);
                duplicateNicknameList.add(email);
            }
        }

        return duplicateNicknameList;
    }

    private static boolean checkDuplicateNickname(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String subStr = nickname.substring(i, i + 2);
            if (nicknameMap.get(subStr) > 1) {
                return true;
            }
        }

        return false;
    }
}
