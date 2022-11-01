package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < cryptogram.length(); i++) {
            list.add(String.valueOf(cryptogram.charAt(i)));
        }
        while (isCheck(list)) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    list.remove(i + 1);
                    list.remove(i);
                    break;
                }
            }
        }

        for (String str : list) {
            answer.append(str);
        }
        return String.valueOf(answer);
    }

    public static boolean isCheck(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return list.size() != set.size();
    }

}
