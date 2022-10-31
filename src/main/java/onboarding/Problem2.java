package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        boolean check = true;

        List<String> cryptogramIngredients = getCryptogramIngredients(cryptogram);

        while (check) {
            check = false;

            List<String> temp = new ArrayList<>(cryptogramIngredients);

            Set<Integer> duplicatedCharIndex = getDuplicatedCharIndex(temp);
            List<Integer> duplicatedCharIndexReverseOrder = setToListWithReverseOrder(duplicatedCharIndex);

            // 문자열에서 인덱스 제거하기
            if (!duplicatedCharIndexReverseOrder.isEmpty()) {
                for (int charIndex : duplicatedCharIndexReverseOrder) {
                    temp.remove(charIndex);
                }

                check = true;
            }

            cryptogramIngredients = temp;
        }

        answer = listToString(cryptogramIngredients);

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

    static String listToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
