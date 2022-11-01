package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    // 크루 정보를 담은 Map 생성
    private static Map<String, String> crewInfoMap = new HashMap<>();
    // 겹치는 대상자의 email을 저장할 Set
    private static TreeSet<String> duplEmailSet = new TreeSet();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> crewInfoList : forms) {
            String email = crewInfoList.get(0);
            String name = crewInfoList.get(1);
            if (checkNickName(name)) {
                duplEmailSet.add(email);
            }

            crewInfoMap.put(name, email);
        }
        return duplEmailSet.stream().collect(Collectors.toList());
    }

    /**
     * 전달 받은 닉네임이 두글자이상 중복되는지 확인하는 메소드
     * @param name
     * @return {boolean}
     */
    public static boolean checkNickName(String name) {
        for (int i = 0; i < name.length() -1; i++) {
            String twoCharName = name.substring(i, i+2);

            for (String keys : crewInfoMap.keySet()) {
                if (keys.contains(twoCharName)) {
                    duplEmailSet.add(crewInfoMap.get(keys));
                    return true;
                }
            }
        }
        return false;
    }
}

