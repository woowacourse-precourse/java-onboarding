package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  isProperForms 메서드 적절한 형태인지 확인
 *  isProperEmail 메서드 적절한 이메일인지 확인
 *  isProperNickName 매서드 적절한 닉네임인지 확인
 *  getOverlapNickName 메서드 2글자씩잘라서 중복된 값이 있다면 그 닉네임을 Map에 저환
 */

public class Problem6 {
    private static Map<String, String> nickNameMap = new HashMap<>();
    private static Set<String> overlapNickNameSet = new HashSet<>();
    private static final int EMAIL = 0;
    private static final int NICKNAME=1;
    public static List<String> solution(List<List<String>> forms) {
        forms.stream()
                .filter(Problem6::isProperForms)
                .forEach(Problem6::getOverlapNickName);

        return overlapNickNameSet.stream().sorted().collect(Collectors.toList());
    }


    private static void getOverlapNickName(List<String> list) {
        String nickName = list.get(NICKNAME);
        for (int i = 0; i < nickName.length() - 1; i++) {
            String subString = nickName.substring(i, i + 2);
            if (nickNameMap.containsKey(subString)) {
                overlapNickNameSet.add(nickNameMap.get(subString));
                overlapNickNameSet.add(list.get(EMAIL));
            }
            if (!nickNameMap.containsKey(subString))
                nickNameMap.put(subString, list.get(EMAIL));
        }
    }


    private static boolean isProperForms(List<String> forms) {
        return forms.size() == 2
                && isProperEmail(forms.get(EMAIL))
                && isProperNickName(forms.get(NICKNAME));
    }

    private static boolean isProperEmail(String email) {
        return 11 <= email.length()
                && email.length() < 20
                && email.endsWith("email.com");
    }
    private static boolean isProperNickName(String nickName) {
        return 1 <= nickName.length()
                && nickName.length() < 20
                && nickName.matches("^[ㄱ-ㅎ가-힣]*$");
    }

}
