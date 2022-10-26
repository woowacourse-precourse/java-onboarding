package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public boolean validation(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return false;
        } else if (!cryptogram.equals(cryptogram.toLowerCase())) {
            return false;
        } else {
            return true;
        }
    }

    public static int countDuplicatedNeighbor(List<Character> cryptogram, int start) {
        int cnt = 1;
        for (int i = start; i < cryptogram.size() - 1; i++) {
            if (cryptogram.get(i) == cryptogram.get(i + 1)) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public static void deleteDuplicatedNeighbor(List<Character> cryptogram, int start, int cnt) {
        if (cnt != 1) {
            for (int i = 0; i < cnt; i++) {
                cryptogram.remove(start);
            }
        }
    }

    public int hasDuplicateNeighbor(List<Character> cryptogram) {
        for (int i = 0; i < cryptogram.size() - 1; i++) {
            if (cryptogram.get(i) == cryptogram.get(i + 1))
                return i;
        }
        return -1;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        char[] temp = cryptogram.toCharArray();
        List<Character> charArr = new ArrayList<>();
        for (char c : temp) {
            charArr.add(c);
        }



        return answer;
    }
}
