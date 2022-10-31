package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        List<String> charList = new ArrayList<>(List.of(cryptogram.split("")));

        while (true) {
            List<Integer> indexesToRemove = findIndexesToRemove(charList);
            if (indexesToRemove.isEmpty()) {
                break;
            }
            removeChars(charList, indexesToRemove);
        }

        answer = convertToString(charList);
        return answer;
    }

    private static List<Integer> findIndexesToRemove(List<String> charList) {

        // 반복되는 문자들의 인덱스를 indexesToRemove라는 리스트에 넣기
        List<Integer> indexesToRemove = new ArrayList<>();
        for (int i = 0; i < charList.size(); i++) {
            if (i != 0 && charList.get(i).equals(charList.get(i-1))) {
                indexesToRemove.add(i);
                indexesToRemove.add(i-1);
            }
        }
        // 인덱스를 앞에서부터 삭제하면 index out of range 오류 발생 -> 방지 위해 reverse 정렬하기
        Collections.sort(indexesToRemove, Comparator.reverseOrder());
        return indexesToRemove;
    }

    private static List<String> removeChars(List<String> charList, List<Integer> indexesToRemove) {
        for (int index : indexesToRemove) {
            charList.remove(index);
        }
        return charList;
    }

    private static String convertToString(List<String> charList) {
        StringBuilder result = new StringBuilder();
        for (String letter : charList) {
            result.append(letter);
        }
        return result.toString();
    }
}