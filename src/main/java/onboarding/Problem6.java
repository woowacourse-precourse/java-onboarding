package onboarding;

import java.util.*;

/*
* 기능 목록
* 1. 중복 횟수 저장하는 map 만드는 메서드 setDuplicationMap
* 2. map에 중복 횟수 계산하는 메서드 addDuplicatedString
* 3. 중복에 해당하는 회원 메일 set 만드는 메서드 createAnswerSet
* 4. 중복에 해당하는지 판단해서 set에 요소 추가하는 메서드 addAnswerString
* */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> numberOfDuplication = createNumberOfDuplicationsMap(forms);

        TreeSet<String> answerSet = createAnswerSet(forms, numberOfDuplication);

        createAnswerSet(forms, numberOfDuplication);

        return new ArrayList<>(answerSet);
    }

    private static TreeSet<String> createAnswerSet(List<List<String>> forms, Map<String, Integer> numberOfDuplication) {
        TreeSet<String> result = new TreeSet<>();

        for (List<String> form : forms) {
            addAnswerString(numberOfDuplication, result, form);
        }

        return result;
    }

    private static void addAnswerString(Map<String, Integer> numberOfDuplication, TreeSet<String> result, List<String> form) {
        String tmpName = form.get(1);

        for (int i = 0; i < tmpName.length()-1; i++) {
            if (numberOfDuplication.get(tmpName.substring(i, i+2)) > 1) {
                result.add(form.get(0));
                break;
            }
        }
    }

    private static Map<String, Integer> createNumberOfDuplicationsMap(List<List<String>> forms) {
        Map<String, Integer> result = new HashMap<>();

        for (List<String> form : forms) {
            String tmpName = form.get(1);
            addDuplicatedString(result, tmpName);
        }

        return result;
    }

    private static void addDuplicatedString(Map<String, Integer> result, String tmpName) {
        for (int i = 0; i < tmpName.length()-1; i++) {
            result.put(tmpName.substring(i, i + 2), result.getOrDefault(tmpName.substring(i, i + 2), 0) + 1);
        }
    }
}
