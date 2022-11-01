/*
 *기능목록
 * 1. 닉네임이나 email 값을 꺼내는 함수
 * 2. 닉네임에서 2글자로 분리하는 함수
 * 3. 2글자로 분리된 닉네임이 겹치는 경우 카운트
 * 4. 겹치는 닉네임의 이메일을 꺼내는 함수
 * 5. 이메일을 sort 하는 함수
 */
package onboarding;

import java.util.*;

public class Problem6 {
    static final int EMAIL = 0;
    static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        return formsGetList(forms);
    }

    public static List<String> formsGetList(List<List<String>> forms) {
        Map<String, List<String>> nicknameSection = new HashMap<>();
        for (List<String> userInfo : forms) {
            divideNickname(nicknameSection, userInfo);
        }

        Set<String> emailSet = overlapNicknameWho(nicknameSection);
        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        System.out.println(answer);
        return answer;
    }

    public static void divideNickname(Map<String, List<String>> nicknameSectionMap, List<String> userInfo) {
        String nickname = returnNicknameOREmail(userInfo, NICKNAME);
        String email = returnNicknameOREmail(userInfo, EMAIL);
        for (int i = 0; i < nickname.length() - 1; i++) {
            putNicknameSection(nicknameSectionMap, nickname.substring(i, i + 2), email);
        }
    }

    public static String returnNicknameOREmail(List<String> userInfo, int data) {
        return userInfo.get(data);
    }

    public static void putNicknameSection(Map<String, List<String>> nicknameSectionMap, String nicknameSection, String email) {
        if (!nicknameSectionMap.containsKey(nicknameSection)) {
            List<String> indexList = emailListAddEmail(null, email);
            nicknameSectionMap.put(nicknameSection, indexList);
        } else {
            List<String> indexList = emailListAddEmail(nicknameSectionMap.get(nicknameSection), email);
            nicknameSectionMap.replace(nicknameSection, indexList);
        }
    }

    public static List<String> emailListAddEmail(List<String> emailList, String email) {
        if (emailList == null) {
            emailList = new LinkedList<>();
        }
        emailList.add(email);
        return emailList;
    }

    public static Set<String> overlapNicknameWho(Map<String, List<String>> nicknameSection) {
        Set<String> emailSet = new HashSet<>();
        for (List<String> emailList : nicknameSection.values()) {
            if (emailList.size() > 1) {
                emailSet.addAll(emailList);
            }
        }
        return emailSet;
    }
}
