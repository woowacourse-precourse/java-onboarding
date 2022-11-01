package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}