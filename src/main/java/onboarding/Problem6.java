package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        //result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.

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
