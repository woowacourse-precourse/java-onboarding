package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * isProperForms 메서드 적절한 형태인지 확인
 * isProperEmail 메서드 적절한 이메일인지 확인
 * isProperNickName 매서드 적절한 닉네임인지 확인
 * getOverlapNickName 메서드 2글자씩잘라서 중복된 값이 있다면 그 닉네임을 set에 저환
 * isProperCrewRange 메서드 크루원 수가 올바른지 확인
 */

public class Problem6 {
    private static Map<String, String> nickNameMap = new HashMap<>();
    private static Set<String> overlapNickNameSet = new HashSet<>();
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    private static final int FORMS_SIZE = 2;

    private static final String EMAIL_FORM = "email.com";

    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 20;
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 20;

    private static final String KOREAN_NAME = "^[ㄱ-ㅎ가-힣]*$";

    private static final int MIN_CREW_COUNT = 1;

    private static final int MAX_CREW_COUNT = 10000;

    public static List<String> solution(List<List<String>> forms) {
        isProperCrewRange(forms);
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
        return forms.size() == FORMS_SIZE
                && isProperEmail(forms.get(EMAIL))
                && isProperNickName(forms.get(NICKNAME));
    }

    private static boolean isProperEmail(String email) {
        return MIN_EMAIL_LENGTH <= email.length()
                && email.length() < MAX_EMAIL_LENGTH
                && email.endsWith(EMAIL_FORM);
    }

    private static boolean isProperNickName(String nickName) {
        return MIN_NICKNAME_LENGTH <= nickName.length()
                && nickName.length() < MAX_NICKNAME_LENGTH
                && nickName.matches(KOREAN_NAME);
    }

    private static void isProperCrewRange(List<List<String>> forms) {
        if (forms.size() < MIN_CREW_COUNT || forms.size() > MAX_CREW_COUNT)
            throw new IllegalArgumentException("크루는 1명이상 10000명 이하입니다.");
    }

}
