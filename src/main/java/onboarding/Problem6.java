package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 중복될 수 있는 2글자 단어들 모으기
 *    - 중복될 수 있는 2글자 단어들 저장
 * 2. 1번으로 해당 닉네임이 중복인지 검사
 * 3. 2번의 결과를 정리
 *    - 이메일만 추출
 *    - 오름차순 정렬
 *    - 중복 제거
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicatedEmails(forms);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    /**
     * 중복될 수 있는 2글자 단어들을 모으고, 그 중 중복되는 단어들을 판별
     *
     * @param form
     * @param duplications
     */
    private static void getDuplications(List<String> form, HashMap<String, Boolean> duplications) {
        for (int i = 0; i < form.get(1).length() - 1; i++) {
            if (duplications.containsKey(form.get(1).substring(i, i + 2))) {
                duplications.put(form.get(1).substring(i, i + 2), Boolean.TRUE);
            } else {
                duplications.put(form.get(1).substring(i, i + 2), Boolean.FALSE);
            }
        }
    }

    /**
     * 닉네임의 중복 여부 검사
     *
     * @param forms
     * @return 중복된 닉네임의 이메일
     */
    private static List<String> getDuplicatedEmails(List<List<String>> forms) {
        List<String> duplicatedEmails = new ArrayList<>();
        HashMap<String, Boolean> duplications = new HashMap<>();

        for (List<String> form : forms) {
            getDuplications(form, duplications);
        }

        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                if (duplications.get(form.get(1).substring(i, i + 2))) {
                    duplicatedEmails.add(form.get(0));
                    break;
                }
            }
        }

        return duplicatedEmails;
    }
}
