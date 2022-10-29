package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (checkingCode(answer)) {
            answer = deleteDuplication(answer);
        }
        return answer;
    }

    private static boolean checkingCode(String cryptogram) {
        String[] code = cryptogram.split("");
        for (int i = 0; i < code.length - 1; i++) {
            if (code[i].equals(code[i + 1])) {
                return true;
            }
        }

        return false;
    }

    private static String deleteDuplication(String cryptogram) {
        List<String> code = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        for (int i = 0; i < code.size() - 1; i++) {
            if (code.get(i).equals(code.get(i + 1))) {
                code.remove(i);
                code.remove(i);
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
