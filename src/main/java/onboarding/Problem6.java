package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static final Map<String, Integer> nicknameMap = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        saveNicknameToMap(forms);
        List<String> duplicateNicknameList = getDuplicateNicknameList(forms);
        Collections.sort(duplicateNicknameList);

        return duplicateNicknameList;
    }

    private static void saveNicknameToMap(List<List<String>> forms) {
        for (List<String> crew : forms) {
            String nickname = crew.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String subStr = nickname.substring(i, i + 2);
                if (!nicknameMap.containsKey(subStr)) {
                    nicknameMap.put(subStr, 1);
                } else {
                    nicknameMap.put(subStr, nicknameMap.get(subStr) + 1);
                }
            }
        }
    }

    private static List<String> getDuplicateNicknameList(List<List<String>> forms) {
        //중복 제거
        Set<String> duplicateNicknameList = new HashSet<>();

        for (List<String> crew : forms) {
            String nickname = crew.get(1);
            if (checkDuplicateNickname(nickname)){
                String email = crew.get(0);
                duplicateNicknameList.add(email);
            }
        }

        return new ArrayList<>(duplicateNicknameList);
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
