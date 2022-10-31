package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] array = cryptogram.split("");
        List<String> str = new ArrayList<>(Arrays.asList(array));
        List<List<Integer>> removeList;
        int start;
        int end;
        List<String> left;
        List<String> right;
        String result = "";

        while (true) {
            removeList = findRemove(str);
            if (removeList.isEmpty()) {
                break;
            }

            for (int i = removeList.size() - 1; i > -1; i--) {
                start = removeList.get(i).get(0);
                end = removeList.get(i).get(1);
                left = str.subList(0, start);
                right = str.subList(end, str.size());
                str = Stream.concat(left.stream(), right.stream())
                        .collect(Collectors.toList());
            }
        }

        for (String s : str) {
            result += s;
        }
        return result;
    }

    public static List<List<Integer>> findRemove(List<String> str) {
        int start = 0;
        int end = 0;
        List<List<Integer>> removeList = new ArrayList<>();
        while (start < str.size() && end < str.size()) {
            while (end < str.size() && Objects.equals(str.get(start), str.get(end))) {
                end += 1;
            }
            if (end - start >= 2) {
                List<Integer> list = new ArrayList<>(Arrays.asList(start, end));
                removeList.add(list);
            }
            start = end;
            end += 1;
        }
        return removeList;
    }
}
