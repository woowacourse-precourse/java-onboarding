package onboarding;

import java.util.*;

public class Problem2 {
    public static ArrayList<String> divideWord(String word) {
        ArrayList<String> crypto = new ArrayList<>();

        for (int a = 0; a < word.length(); a++) {
            crypto.add(String.valueOf(word.charAt(a)));
        }

        return crypto;
    }

    public static ArrayList<String> removeChar(ArrayList<String> word) {
        int count = 0;
        int size = word.size();

        while (count < size - 1) {
            Set<Integer> set = new HashSet<>();
            // 제거해야할 인덱스 반환
            removeCharGetIndex(word, set, count);
            if (!set.isEmpty()) {
                List<Integer> noDup = new ArrayList<>(List.copyOf(set));
                noDup.sort(Comparator.reverseOrder());
                for (int i : noDup) {
                    word.remove(i);
                }
                size = word.size();
                count = 0;
            } else {
                count++;
            }
        }
        return word;
    }

    public static void removeCharGetIndex(ArrayList<String> word, Set<Integer> set, int temp) {
        if (word.get(temp).equals(word.get(temp + 1))) {
            if (word.size() > 3) {
                removeCharGetIndex(word, set, temp + 1);
            }
            set.add(temp);
            set.add(temp + 1);
        }
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        // 1. 문자를 따로 나눔
        ArrayList<String> word = divideWord(cryptogram);
        // 2. 연속적이고 중복된 문자의 인덱스를 구하고 제거
        ArrayList<String> removedChar = removeChar(word);
        // 3. 제거 후 남은 문자 재조합

        return answer;
    }
}
