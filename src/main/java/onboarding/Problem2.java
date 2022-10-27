package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {


    public static String solution(String cryptogram) {
        List<String> splitString = Arrays.stream(cryptogram.split("")).collect(Collectors.toList());
        List<Integer> indexOfDuplicateWords = new ArrayList<>();

        while (true) {

            for (int i = 0; i < splitString.size() - 1; i++) {
                if (splitString.get(i).equals(splitString.get(i + 1))) {
                    indexOfDuplicateWords.add(i);
                }
            }

            if (indexOfDuplicateWords.size() == 0) {
                break;
            }

            indexOfDuplicateWords.sort(Collections.reverseOrder());

            for (Integer idx : indexOfDuplicateWords) {
                splitString.subList(idx, idx + 2).clear();
            }
            indexOfDuplicateWords.clear();
        }

        return String.join("", splitString);

    }



}
