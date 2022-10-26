package onboarding;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * goal: 중복되는 문자열을 제거하여 암호를 해독하고 이를 리턴
 */

/**
 * 문제 풀이 순서
 * 1. 먼저 중복된 단어의 인덱스를 찾아서 set에 넣어준다.
 * 2. set에 포함된 인덱스를 반대로 정렬하고 해당 인덱스를 통해서 cryptogram의 중복 문자열을 지워준다.
 * 3. 중복 문자열이 나오면 재귀적으로 메서드를 반복하여 다시 중복이 있는지 확인한다.
 * 4. 중복 문자열이 없다면 해당 cryptogram을 리턴해준다.
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplicateStr(cryptogram);
    }

    // 중복된 부분이 있다면 재귀적으로 다시 중복 확인하는 메서드
    private static String removeDuplicateStr(String cryptogram) {
        Set<Integer> removeSet = new LinkedHashSet<>();
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                removeSet.add(i - 1);
                removeSet.add(i);
            }
        }

        if (removeSet.size() != 0) {
            cryptogram = removeDuplicateIdx(cryptogram, removeSet);
            return removeDuplicateStr(cryptogram);
        }
        return cryptogram;
    }

    // 중복된 부분 제거해주는 메서드
    private static String removeDuplicateIdx(String cryptogram, Set<Integer> removeSet) {
        List<Integer> removeList = removeSet.stream().sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        while (!removeList.isEmpty()) {
            Integer idx = removeList.remove(0);
            cryptogram = cryptogram.substring(0, idx) + cryptogram.substring(idx + 1);
        }
        return cryptogram;
    }
}
