package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {


    public static String solution(String cryptogram) {
        List<String> splitString = getSplitStrings(cryptogram);
        List<Integer> indexOfDuplicateWords = getIndexOfDuplicateWords(splitString);
        removeDuplicateWords(splitString, indexOfDuplicateWords);
        return String.join("", splitString);
    }

    private static List<String> getSplitStrings(String cryptogram) {
        return Arrays.stream(cryptogram.split("")).collect(Collectors.toList());
    }

    private static List<Integer> getIndexOfDuplicateWords(List<String> splitString) {
        return IntStream.range(0, splitString.size() -1)
                .filter(s -> splitString.get(s).equals(splitString.get(s + 1)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static void removeDuplicateWords(List<String> splitString, List<Integer> indexOfDuplicateWords) {
        if (indexOfDuplicateWords.size() == 0) {
            return;
        }

        indexOfDuplicateWords.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(idx -> splitString.subList(idx, idx + 2).clear());

        indexOfDuplicateWords = getIndexOfDuplicateWords(splitString);
        removeDuplicateWords(splitString, indexOfDuplicateWords);

    }

}
