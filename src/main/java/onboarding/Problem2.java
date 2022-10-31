package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    static List<Character> ConvertStringToList(String str) {
        List<Character> list_cryptogram = new ArrayList<Character>();
        for (char c : str.toCharArray()) {
            list_cryptogram.add(c);
        }
        return list_cryptogram;
    }

    static List<Character> removeCharacter(List<Character> list_cryptogram) {
        while (true) {
            boolean isComplete = true;
            for (int i = 0; i < list_cryptogram.size() - 1; i++) {
                if (list_cryptogram.get(i) != list_cryptogram.get(i + 1))
                    continue;
                if (list_cryptogram.get(i) == list_cryptogram.get(i + 1)) {
                    list_cryptogram.remove(i);
                    list_cryptogram.remove(i);
                    isComplete = false;
                    break;
                }
            }
            if (isComplete) {
                return list_cryptogram;
            }
        }
    }


    public static String solution(String cryptogram) {
        List<Character> list_cryptogram = ConvertStringToList(cryptogram);
        String answer = "answer";
        return answer;
    }
}
