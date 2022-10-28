package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean checkingCode(String cryptogram) {
        String[] code = cryptogram.split("");
        for (int i = 0; i < code.length - 1; i++) {
            if (code[i] == code[i + 1]) {
                return true;
            }
        }

        return false;
    }

    private static String deleteDuplication(String cryptogram) {
        List<String> code = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        for (int i = 0; i < code.size() - 1; i++) {
            if (code.get(i) == code.get(i + 1)) {
                code.remove(i);
                code.remove(i + 1);
                i--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (String s : code) {
            result.append(s);
        }
        return result.toString();
    }


}
