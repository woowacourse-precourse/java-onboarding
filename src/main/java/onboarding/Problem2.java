package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {

        List<Character> cryptogramList = cryptogram.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> result = new ArrayList<>(cryptogramList);

        int beforeLength = cryptogramList.size();
        int afterLength = -1;

        while (beforeLength != afterLength) {

            beforeLength = cryptogramList.size();
            HashSet<Integer> indexSet = new HashSet<>();

            for (int i = 0; i < beforeLength - 1; i++) {

                if (cryptogramList.get(i) == cryptogramList.get(i+1)) {
                    indexSet.add(i);
                    indexSet.add(i+1);
                }
            }

            if (indexSet.size() == 0) {
                break;
            }

            List<Integer> indexList = new ArrayList<>(indexSet);
            Collections.sort(indexList, Collections.reverseOrder());

            for (int index : indexList) {
                result.remove(index);
            }
            afterLength = result.size();

            cryptogramList = new ArrayList<>(result);
        }

        String answer = result.stream()
                .map(e->e.toString())
                .reduce((acc, e) -> acc  + e)
                .get();

        return answer;
    }
}

class ExceptionProblem2 {
    static final String ERROR_MESSAGE = "입력이 잘못 입력되었습니다.";

    public static void validateCryptogram(String cryptogram) {

    }
}