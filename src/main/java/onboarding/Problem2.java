package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        checkList(cryptogram);

        String answer = "";
        int count = 1;

        List<Character> cut = new ArrayList<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            cut.add(cryptogram.charAt(i));
        }

        int size = cut.size();
        while (count>0) {
            count = 0;
            for (int j = 0; j < size - 1; j++) {
                if (cut.get(j) == cut.get(j + 1)) {
                    cut.remove(j);
                    cut.remove(j);
                    size -= 2;
                    j--;
                    count++;
                }
            }
        }

        for (int i = 0; i < cut.size(); i++) {
            answer += cut.get(i);
        }

        return answer;
    }

    public static void checkList(String cryptogram) throws IllegalArgumentException {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException("cryptogram은 길이가 1 미만 1000 초과인 문자열 입니다.");
        }
        if (cryptogram.toLowerCase() != cryptogram) {
            throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 이루어져 있지 않습니다.");
        }
        if (cryptogram.replaceAll(" ", "") != cryptogram) {
            throw new IllegalArgumentException("cryptogram에 공백이 있습니다.");
        }
    }
}



