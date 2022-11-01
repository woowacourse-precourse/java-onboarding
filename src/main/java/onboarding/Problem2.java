package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

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

    public static void deleteDuplicatedNeighbor(List<Character> cryptogram, int start) {
        int i = start;
        int cnt;
        while (i < cryptogram.size() - 1) {
            if (cryptogram.get(i) == cryptogram.get(i + 1)) {
                cnt = countDuplicatedNeighbor(cryptogram, i);
                for (int j = 0; j < cnt; j++) {
                    cryptogram.remove(i);
                }
            } else {
                i++;
            }
        }
    }

    public static int hasDuplicateNeighbor(List<Character> cryptogram) {
        for (int i = 0; i < cryptogram.size() - 1; i++) {
            if (cryptogram.get(i) == cryptogram.get(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean validation(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000){
            return false;
        }
        if (!cryptogram.equals(cryptogram.toLowerCase())){
            return false;
        }
        return true;
    }

    public static String solution(String cryptogram) {
        String answer;
        List<Character> charArr = new ArrayList<>();

        if (!validation(cryptogram)){
            return "입력 오류";
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            charArr.add(cryptogram.charAt(i));
        }

        while (true) {
            int idx = hasDuplicateNeighbor(charArr);
            if (idx == -1) {
                break;
            }
            deleteDuplicatedNeighbor(charArr, idx);
        }
        StringBuilder builder = new StringBuilder();
        for (Character ch : charArr) {
            builder.append(ch);
        }
        answer = builder.toString();

        return answer;
    }
}
