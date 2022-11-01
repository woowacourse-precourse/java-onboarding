package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static Map<String, Integer> nicknameMap;
    public static List<String> solution(List<List<String>> forms) {
        initMap();
        saveNicknameToMap(forms);
        List<String> duplicateNicknameList = getDuplicateNicknameList(forms);
        Collections.sort(duplicateNicknameList);

        return duplicateNicknameList;
    }

    private static void initMap() {
        nicknameMap = new HashMap<>();
    }

    private static void saveNicknameToMap(List<List<String>> forms) {
        //연속된 닉네임을 식별하기 위해서 두 글자씩 잘라 저장한다.
        for (List<String> crew : forms) {
            String nickname = crew.get(1);
            List<String> nicknameUnits = getNicknameUnits(nickname);
            saveNicknameUnitsToMap(nicknameUnits);
        }
    }

    private static List<String> getNicknameUnits(String nickname) {
        Set<String> nickNameUnits = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String nicknameUnit = nickname.substring(i, i + 2);
            nickNameUnits.add(nicknameUnit);
        }

        return new ArrayList<>(nickNameUnits);
    }

    private static void saveNicknameUnitsToMap(List<String> nicknameUnits) {
        for (String nicknameUnit : nicknameUnits) {
            if (!nicknameMap.containsKey(nicknameUnit)) {
                nicknameMap.put(nicknameUnit, 1);
            } else {
                nicknameMap.put(nicknameUnit, nicknameMap.get(nicknameUnit) + 1);
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
