package onboarding;

import java.util.*;

public class Problem6 {
    static int NICKNAME = 1;
    static int EMAIL = 0;
    private static List<String> emailListAddEmail (List<String> emailList, String email) {
        if (emailList == null)
            emailList = new LinkedList<>();
        emailList.add(email);
        return emailList;
    }

    private static String returnNicknameOrEmail (List<String> userInfo, int data) {
        return userInfo.get(data);
    }

    private static void divideNickName (Map<String, List<String>> nicknameSectionMap, List<String> userInfo) {
        String nickname = returnNicknameOrEmail(userInfo, NICKNAME);
        String email = returnNicknameOrEmail(userInfo, EMAIL);
        for (int i = 0; i < nickname.length() - 1; i++) {
            putNicknameMap(nicknameSectionMap, nickname.substring(i, i+2), email);
        }
    }

    private static void putNicknameMap (Map<String, List<String>> nicknameMap, String nicknameSection, String email) {
        if (!nicknameMap.containsKey(nicknameSection)) {
            List<String> indexList = emailListAddEmail(null, email);
            nicknameMap.put(nicknameSection, indexList);
        }
        else {
            List<String> indexList = emailListAddEmail(nicknameMap.get(nicknameSection), email);
            nicknameMap.replace(nicknameSection, indexList);
        }
    }

    private static Set<String> findDuplicatedNickname(Map<String, List<String>>nicknameMap) {
        Set<String> emailSet = new HashSet<>();
        for (List<String> emailList : nicknameMap.values()) {
            if (emailList.size() > 1) {
                emailSet.addAll(emailList);
            }
        }
        return emailSet;
    }

    private static List<String> formsGetList(List<List<String>> forms) {
        Map<String, List<String>> nicknameMap = new HashMap<>();
        for (List<String> userInfo : forms) {
            divideNickName(nicknameMap, userInfo);
        }

        Set<String> emailSet = findDuplicatedNickname(nicknameMap);
        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        answer = formsGetList(forms);
        return answer;
    }
}