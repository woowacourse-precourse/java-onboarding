package onboarding;

import java.util.*;

public class Problem6 {
    /*
        2번 이상 출현한 subName을 체크하기 위한 Map
        - 1번 출현 -> "subName": false
        - 2번 이상 출현 -> "subName": true
     */
    static Map<String, Boolean> appearMoreThanTwo = new HashMap<>();

    // 2번 이상 출현한 subName을 저장한 Set
    static Set<String> targetSubName = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        String name;
        String subName;
        List<String> result = new ArrayList<>();

        // 두 글자 이상의 문자가 연속적으로 출현하는지 확인
        forms.stream()
                .map(Problem6::getName)
                .forEach(Problem6::checkFrequency);

        // 2번 이상 출현한 subName을 저장
        appearMoreThanTwo.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .forEach(e -> targetSubName.add(e));

        // 2번 이상 출현한 name의 email 저장
        for (List<String> form: forms) {
            name = getName(form);

            for (int i = 0; i < name.length() - 1; i++) {
                subName = name.substring(i, i + 2);

                if (targetSubName.contains(subName)) {
                    result.add(getEmail(form));
                    break;
                }
            }
        }

        // 이메일을 오름차순으로 정렬
        result.sort(Comparator.naturalOrder());

        return result;
    }

    private static String getEmail(List<String> form) {
        return form.get(0);
    }

    private static String getName(List<String> form) {
        return form.get(1);
    }

    private static void checkFrequency(String str) {
        String subStr;

        for (int i = 0; i < str.length() - 1; i++) {
            subStr = str.substring(i, i + 2);

            // 1번 이상 나왔다면
            if (appearMoreThanTwo.containsKey(subStr)) {
                // 1번만 나왔다면
                if (!appearMoreThanTwo.get(subStr)) {
                    appearMoreThanTwo.put(subStr, true);
                }
            }
            // 한번도 나오지 않았다면
            else {
                appearMoreThanTwo.put(subStr, false);
            }
        }
    }

}
