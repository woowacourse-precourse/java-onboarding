package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 중복 출력을 방지하기 위한 Set
        Set<String> alertNickName = new HashSet<>();
        // Map<닉네임의 부분 문자열, 크루 정보>
        Map<String, List<String>> nickAndForm = new HashMap<>();
        List<String> result = null;

        run(forms, alertNickName, nickAndForm);

        result = new ArrayList<>(alertNickName);
        Collections.sort(result);
        return result;
    }

    /**
     * 주요 기능 동작 메소드
     */
    private static void run(List<List<String>> forms, Set<String> alertNickName, Map<String, List<String>> nickAndForm) {
        for (List<String> form : forms) {
            String nickName = form.get(1);

            makeSubNick(alertNickName, nickAndForm, form, nickName);
        }
    }

    /**
     * 닉네임을 부분으로 나눠 중복 검증 수행 메소드
     */
    private static void makeSubNick(Set<String> alertNickName, Map<String, List<String>> nickAndForm, List<String> form, String nickName) {
        for (int i = 0; i < nickName.length(); i++) {
            for (int j = i; j < nickName.length(); j++) {
                if (j - i >= 1) {
                    String subName = nickName.substring(i, j + 1);

                    findDupSubNick(alertNickName, nickAndForm, form, subName);
                    nickAndForm.put(subName, form);
                }
            }
        }
    }

    /**
     * 부분 닉네임 중복 찾기 메소드
     */
    private static void findDupSubNick(Set<String> alertNickName, Map<String, List<String>> nickAndForm, List<String> form, String subName) {
        if (nickAndForm.containsKey(subName)) {
            verifyDupSubNick(alertNickName, nickAndForm, form, subName);
        }
    }

    /**
     * 부분 닉네임 검증 메소드
     */
    private static void verifyDupSubNick(Set<String> alertNickName, Map<String, List<String>> nickAndForm, List<String> form, String subName) {
        for (Map.Entry<String, List<String>> entry : nickAndForm.entrySet()) {
            if (entry.getKey().equals(subName) && !entry.getValue().get(0).equals(form.get(0))) {
                addAlert(alertNickName, form, entry);
            }
        }
    }

    /**
     * 경고 지원자 추가 메소드
     */
    private static void addAlert(Set<String> alertNickName, List<String> form, Map.Entry<String, List<String>> entry) {
        alertNickName.add(entry.getValue().get(0));
        alertNickName.add(form.get(0));
    }
}
