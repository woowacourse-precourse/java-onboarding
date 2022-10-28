package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static List<String> getCryptogramIngredients(String cryptogram) {
        String[] splitCryptogram = cryptogram.split("");

        return Arrays.asList(splitCryptogram);
    }

    static Set<Integer> getDuplicatedCharIndex(List<String> list) {

        Set<Integer> duplicatedCharIndex = new HashSet<>();

        for (int i = 0; i < list.size() - 1; i++) {
            // 중복된 문자의 인덱스 찾기
            if (list.get(i).equals(list.get(i + 1))) {
                duplicatedCharIndex.add(i);
                duplicatedCharIndex.add(i + 1);
            }
        }

        return duplicatedCharIndex;
    }

    static List<Integer> setToListWithReverseOrder(Set<Integer> duplicatedCharIndexSet) {
        List<Integer> duplicatedCharIndexReverseOrder = new ArrayList<>(duplicatedCharIndexSet);
        Collections.reverse(duplicatedCharIndexReverseOrder);

        return duplicatedCharIndexReverseOrder;
    }
}
